package furknttr.randevusistemi.AccountMVC.service;

import furknttr.randevusistemi.AccountMVC.model.dto.request.ChangePasswordReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.request.LoginReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.request.RegisterReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.request.UpdateReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.response.LoginResDto;

public interface IAccountService {

    void addMember(RegisterReqDto member);

    LoginResDto loginUser(LoginReqDto loginReq);

    void updateProfile(UpdateReqDto updateReqDto, Long id);

    void changePassword(ChangePasswordReqDto changePasswordReqDto, Long id);
}
