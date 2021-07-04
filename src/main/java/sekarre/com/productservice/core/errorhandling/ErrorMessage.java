package sekarre.com.productservice.core.errorhandling;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class ErrorMessage {
    private final Timestamp timestamp;
    private final String name;
}
