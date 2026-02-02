package furknttr.randevusistemi.AccountMVC.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginReqDto {

    @Email
    @NotBlank(message = "Email boş olamaz.")
    private String email;

    @NotBlank(message = "Şifre boş olamaz.")
    private String password;
}
