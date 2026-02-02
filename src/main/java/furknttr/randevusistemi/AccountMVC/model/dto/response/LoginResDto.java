package furknttr.randevusistemi.AccountMVC.model.dto.response;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResDto {

    private long id;
    private String userName;
    @Email
    private String email;
    private String phone;
    private boolean isActive;
    private boolean hasCompany;
}
