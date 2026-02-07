package furknttr.randevusistemi.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

// @RestControllerAdvice: Tüm Controller'ları dinleyen bir "Dinleme Cihazı"dır.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 1. SENİN FIRLATTIĞIN HATALARI YAKALAR (GeneralException)
    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(GeneralException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getHttpStatus().value(),
                ex.getHttpStatus().getReasonPhrase(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
    }

    // 2. VALIDATION HATALARINI YAKALAR (@NotNull, @Size vs.)
    // Burası biraz karışık görünür ama yaptığı şey: Hangi alan hatalıysa onu listelemek.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        // Hatalı alanları tek tek gezip map'e atıyoruz (örn: "email": "Email boş olamaz")
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        // Validation için özel bir response dönüyoruz (Basitlik olsun diye Map döndüm)
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // 3. BEKLENMEYEN DİĞER TÜM HATALAR (NullPointer vs.)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                ex.getMessage(), // Güvenlik için production'da buraya sabit mesaj yazılır
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}