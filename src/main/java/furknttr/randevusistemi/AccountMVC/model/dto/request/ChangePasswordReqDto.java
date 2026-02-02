package furknttr.randevusistemi.AccountMVC.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ChangePasswordReqDto {

    @NotBlank
    private String oldPassword;

    @NotBlank
    private String newPassword;
}
