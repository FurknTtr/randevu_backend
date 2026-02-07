package furknttr.randevusistemi.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private int status;            // Örn: 400, 404, 500
    private String error;          // Örn: "Not Found"
    private String message;        // Örn: "Kullanıcı bulunamadı"
    private LocalDateTime timestamp;
}
