package furknttr.randevusistemi.AccountMVC.controller;

import furknttr.randevusistemi.AccountMVC.model.dto.request.ChangePasswordReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.request.LoginReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.request.RegisterReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.request.UpdateReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.response.LoginResDto;

public interface IAccountController {

    void addMember(RegisterReqDto member);

    LoginResDto loginUser(LoginReqDto login);

    void updateProfile(UpdateReqDto updateReq, Long id);

    void changePassword(ChangePasswordReqDto changePasswordReqDto, Long id);

}