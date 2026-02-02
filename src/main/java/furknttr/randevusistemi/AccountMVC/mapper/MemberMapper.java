package furknttr.randevusistemi.AccountMVC.mapper;

import furknttr.randevusistemi.AccountMVC.model.dto.request.RegisterReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.request.UpdateReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.response.LoginResDto;
import furknttr.randevusistemi.AccountMVC.model.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public Member registerToMember(RegisterReqDto dto) {
        Member member = new Member();
        member.setUserName(dto.getUserName());
        member.setEmail(dto.getEmail());
        member.setPhone(dto.getPhone());
        return member;
    }

    public void updateDtoToMember(UpdateReqDto updateReqDto, Member member){
        member.setUserName(updateReqDto.getUserName());
        member.setEmail(updateReqDto.getEmail());
        member.setPhone(updateReqDto.getPhone());
    }

    public RegisterReqDto toRegisterDto(Member member) {
        RegisterReqDto dto = new RegisterReqDto();
        dto.setUserName(member.getUserName());
        dto.setEmail(member.getEmail());
        dto.setPhone(member.getPhone());
        dto.setPassword(member.getPassword());
        return dto;
    }

    public LoginResDto toLoginResDto(Member member){
        LoginResDto loginResDto = new LoginResDto();
        loginResDto.setId(member.getId());
        loginResDto.setEmail(member.getEmail());
        loginResDto.setUserName(member.getUserName());
        loginResDto.setPhone(member.getPhone());
        loginResDto.setHasCompany(member.isHasCompany());
        loginResDto.setActive(member.isActive());

        return loginResDto;
    }

}
