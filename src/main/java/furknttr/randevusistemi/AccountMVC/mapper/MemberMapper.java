package furknttr.randevusistemi.AccountMVC.mapper;

import furknttr.randevusistemi.AccountMVC.model.dto.request.RegisterReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.request.UpdateReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.response.GetMeResDto;
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

    public GetMeResDto toGetMeResDto(Member member){
        GetMeResDto getMeResDto = new GetMeResDto();
        getMeResDto.setId(member.getId());
        getMeResDto.setEmail(member.getEmail());
        getMeResDto.setUserName(member.getUserName());
        getMeResDto.setPhone(member.getPhone());
        getMeResDto.setHasCompany(member.isHasCompany());
        getMeResDto.setActive(member.isActive());

        return getMeResDto;
    }

}
