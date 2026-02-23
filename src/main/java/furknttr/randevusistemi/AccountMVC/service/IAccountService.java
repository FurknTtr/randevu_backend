package furknttr.randevusistemi.AccountMVC.service;

import furknttr.randevusistemi.AccountMVC.model.dto.request.ChangePasswordReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.request.LoginReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.request.RegisterReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.request.UpdateReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.response.GetMeResDto;
import furknttr.randevusistemi.AccountMVC.model.dto.response.LoginResDto;

public interface IAccountService {

    void addMember(RegisterReqDto member);

    LoginResDto loginUser(LoginReqDto loginReq);

    void updateProfile(UpdateReqDto updateReqDto, String authHeader);

    void changePassword(ChangePasswordReqDto changePasswordReqDto, String authHeader);

    GetMeResDto getMe(String authHeader);
}
