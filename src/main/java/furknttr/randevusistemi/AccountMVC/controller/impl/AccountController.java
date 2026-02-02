package furknttr.randevusistemi.AccountMVC.controller.impl;

import furknttr.randevusistemi.AccountMVC.controller.IAccountController;
import furknttr.randevusistemi.AccountMVC.model.dto.request.ChangePasswordReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.request.LoginReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.request.RegisterReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.request.UpdateReqDto;
import furknttr.randevusistemi.AccountMVC.model.dto.response.LoginResDto;
import furknttr.randevusistemi.AccountMVC.service.IAccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class AccountController implements IAccountController {

    private final IAccountService accountService;


    @Override
    @PostMapping("/register")
    public void addMember(@RequestBody @Valid RegisterReqDto member) {
        accountService.addMember(member);
    }


    @Override
    @PostMapping("/login")
    public LoginResDto loginUser(@RequestBody @Valid LoginReqDto login) {
        return accountService.loginUser(login);
    }

    //id ler Token kırılıp gelicek, şimdilik yok gene.
    @Override
    @PutMapping("/{id}/update")
    public void updateProfile(@RequestBody @Valid UpdateReqDto updateReq, @PathVariable Long id) {
        accountService.updateProfile(updateReq, id);
    }

    @Override
    @PutMapping("/{id}/password")
    public void changePassword(@RequestBody @Valid ChangePasswordReqDto changePasswordReqDto, @PathVariable Long id) {
        accountService.changePassword(changePasswordReqDto, id);
    }

}
