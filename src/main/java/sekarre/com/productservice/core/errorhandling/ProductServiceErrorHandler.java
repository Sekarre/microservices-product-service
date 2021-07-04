package sekarre.com.productservice.core.errorhandling;

import org.axonframework.commandhandling.CommandExecutionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@ControllerAdvice
public class ProductServiceErrorHandler {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorMessage> handleIllegalStateException(IllegalStateException ex) {

        ErrorMessage errorMessage = new ErrorMessage(Timestamp.valueOf(LocalDateTime.now()), ex.getMessage());

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CommandExecutionException.class)
    public ResponseEntity<ErrorMessage> handleCommandExecutionException(CommandExecutionException ex) {

        ErrorMessage errorMessage = new ErrorMessage(Timestamp.valueOf(LocalDateTime.now()), ex.getMessage());

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleExceptions(Exception ex) {

        ErrorMessage errorMessage = new ErrorMessage(Timestamp.valueOf(LocalDateTime.now()), ex.getMessage());

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
