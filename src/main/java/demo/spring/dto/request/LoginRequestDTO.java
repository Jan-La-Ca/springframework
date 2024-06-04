package demo.spring.dto.request;


import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginRequestDTO {
    @NotNull(message = "USER_NOTNULLUSERNAME")
    String userName;
    @NotNull(message = "USER_NOTNULLPASSWORD")
    String password;
}
