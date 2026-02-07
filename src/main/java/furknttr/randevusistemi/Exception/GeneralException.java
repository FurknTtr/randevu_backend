package furknttr.randevusistemi.Exception;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GeneralException extends RuntimeException{
    private final HttpStatus httpStatus;

    // Kullanımı: throw new GeneralException(HttpStatus.NOT_FOUND, "Kullanıcı yok!");
    public GeneralException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
