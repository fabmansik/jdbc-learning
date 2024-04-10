package milansomyk.jdbclearning;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    Long id;
    String name;
    String surname;
    String email;
}
