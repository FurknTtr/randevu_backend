package furknttr.randevusistemi.AccountMVC.service.impl;


import furknttr.randevusistemi.AccountMVC.mapper.MemberMapper;
import furknttr.randevusistemi.AccountMVC.model.dto.request.ChangePasswordReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.request.LoginReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.request.RegisterReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.request.UpdateReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.response.GetMeResDto;
import furknttr.randevusistemi.AccountMVC.model.dto.response.LoginResDto;
import furknttr.randevusistemi.AccountMVC.model.entity.Member;
import furknttr.randevusistemi.AccountMVC.repository.MemberRepository;
import furknttr.randevusistemi.AccountMVC.service.IAccountService;
import furknttr.randevusistemi.Exception.GeneralException;
import furknttr.randevusistemi.JWT.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class AccountService implements IAccountService {

    private final JwtService jwtService;
    private final EmailService emailService;
    private final MemberMapper memberMapper;
    private final MemberRepository memberRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void addMember(RegisterReqDto registerReqDto) {

        /*
        //deneme yaparken aynı Temp Mailden check ettigim için şimdilik kapadım,
        if(memberDto.getMail().equals(memberRepo.findByEmail(memberDto.getMail()))){
            System.out.println("Eposta zaten kayıtlı.");
            return;
        }
        */
        Member member = memberMapper.registerToMember(registerReqDto);
        updateMemberPassword(member, registerReqDto.getPassword());
        memberRepo.save(member);

        //emailService.sendWelcomeEmail(registerReqDto.getEmail(), registerReqDto.getUserName());
    }

    @Override
    public LoginResDto loginUser(LoginReqDto loginReq) {
        Member member = memberRepo.findByEmail(loginReq.getEmail())
                .orElseThrow(()-> new GeneralException(HttpStatus.NOT_FOUND, "Kullanıcı Bulunamadı!"));

        if (!passwordEncoder.matches(loginReq.getPassword(), member.getPassword())){
            throw new GeneralException(HttpStatus.BAD_REQUEST, "Şifre Hatalı");
        }

        String memberId = String.valueOf(member.getId());
        return new LoginResDto(jwtService.generateToken(memberId));
    }

    @Override
    public void updateProfile(UpdateReqDto updateReqDto, String authHeader) {
        // Varsa member'ı getirir, YOKSA anında senin özel hatanı fırlatır.
        String token = authHeader.substring(7);
        String tokenIdStr = jwtService.extractMemberId(token);
        Long tokenId = Long.parseLong(tokenIdStr);

        Member member = memberRepo.findById(tokenId)
                .orElseThrow(() -> new GeneralException(HttpStatus.NOT_FOUND, "Kullanıcı Bulunamadı!"));
        memberMapper.updateDtoToMember(updateReqDto, member);
        memberRepo.save(member);
        emailService.changeProfileInformation(member.getEmail());
    }

    @Override
    public void changePassword(ChangePasswordReqDto changePasswordReqDto, String authHeader) {
        // Varsa member'ı getirir, YOKSA anında senin özel hatanı fırlatır.
        String token = authHeader.substring(7);
        String tokenIdStr = jwtService.extractMemberId(token);
        Long tokenId = Long.parseLong(tokenIdStr);

        Member member = memberRepo.findById(tokenId)
                .orElseThrow(() -> new GeneralException(HttpStatus.NOT_FOUND, "Kullanıcı Bulunamadı!"));
        String oldPass = changePasswordReqDto.getOldPassword();

        if (!passwordEncoder.matches(oldPass, member.getPassword())){
            throw new GeneralException(HttpStatus.BAD_REQUEST, "Mevcut Şifreniz Hatalı");
        }

        updateMemberPassword(member, changePasswordReqDto.getNewPassword());
        memberRepo.save(member);
        emailService.changePasswordInformation(member.getEmail());
    }

    @Override
    public GetMeResDto getMe(String authHeader) {
        String token = authHeader.substring(7);
        String tokenIdStr = jwtService.extractMemberId(token);
        Long tokenId = Long.parseLong(tokenIdStr);
        Member member = memberRepo.findById(tokenId).orElseThrow(()->new GeneralException(HttpStatus.NOT_FOUND, "Kullanıcı Bulunamadı"));
        return memberMapper.toGetMeResDto(member);
    }

    private void updateMemberPassword(Member member, String rawPassword) {
        member.setPassword(passwordEncoder.encode(rawPassword));
    }

}
