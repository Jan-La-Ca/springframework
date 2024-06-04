package demo.spring.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDTO {

    @NotNull(message = "user's name should not emty")
            @Size(min = 3,message = "USER_INVALID")
    String userName;

    @NotNull(message = "Password should not emty")
    String password;

    @NotNull(message = "Dob should not emty")
    LocalDate dob;
}
