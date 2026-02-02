package furknttr.randevusistemi.AccountMVC.service.impl;

import furknttr.randevusistemi.AccountMVC.mapper.MemberMapper;
import furknttr.randevusistemi.AccountMVC.model.dto.request.ChangePasswordReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.request.LoginReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.request.RegisterReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.request.UpdateReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.response.LoginResDto;
import furknttr.randevusistemi.AccountMVC.model.entity.Member;
import furknttr.randevusistemi.AccountMVC.repository.MemberRepository;
import furknttr.randevusistemi.AccountMVC.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class AccountService implements IAccountService {

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

        emailService.sendWelcomeEmail(registerReqDto.getEmail(), registerReqDto.getUserName());
    }

    @Override
    public LoginResDto loginUser(LoginReqDto loginReq) {
        Member member = memberRepo.findByEmail(loginReq.getEmail()).orElseThrow();

        if (!passwordEncoder.matches(loginReq.getPassword(), member.getPassword())){
            throw new RuntimeException("Kullanıcı Adı veya Şifre Hatalı");
        }

        return memberMapper.toLoginResDto(member);
    }

    @Override
    public void updateProfile(UpdateReqDto updateReqDto, Long id) {
        Member member = memberRepo.getReferenceById(id);
        memberMapper.updateDtoToMember(updateReqDto, member);
        memberRepo.save(member);
        emailService.changeProfileInformation(member.getEmail());
    }

    @Override
    public void changePassword(ChangePasswordReqDto changePasswordReqDto, Long id) {
        Member member = memberRepo.getReferenceById(id);
        String oldPass = changePasswordReqDto.getOldPassword();

        if (!passwordEncoder.matches(oldPass, member.getPassword())){
            throw new RuntimeException("Mevcut Şifre Hatalı");
        }

        updateMemberPassword(member, changePasswordReqDto.getNewPassword());
        memberRepo.save(member);
        emailService.changePasswordInformation(member.getEmail());
    }

    private void updateMemberPassword(Member member, String rawPassword) {
        member.setPassword(passwordEncoder.encode(rawPassword));
    }

}
