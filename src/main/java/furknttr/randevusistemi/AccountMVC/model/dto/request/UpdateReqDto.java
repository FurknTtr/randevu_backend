package furknttr.randevusistemi.AccountMVC.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateReqDto {

    @Size(min = 5, max = 30, message = "Kullanıcı adı min 5 max 30 karakter olmalıdır.")
    private String userName;

    @Email
    private String email;

    @Size(min = 11, max = 11, message = "Telefon Numarası 11 haneli olmalıdır.")
    private String phone;
}
