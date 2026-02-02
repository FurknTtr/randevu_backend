package furknttr.randevusistemi.AccountMVC.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterReqDto {

    @Email
    @NotBlank(message = "Email alanı boş bırakılamaz")
    private String email;

    @NotBlank
    @Size(min = 5, max = 30, message = "Kullanıcı adı min5 max 30 karakter olmalıdır.")
    private String userName;

    @NotBlank
    private String password;

    @NotBlank
    @Size(min = 11, max = 11, message = "Telefon numarası 11 haneli olmalıdır.")
    private String phone;

}
