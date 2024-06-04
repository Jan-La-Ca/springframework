package demo.spring.exception;


import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public enum ErrorCode {
    USER_EXIST(400,"User is existed"),
    USER_INVALID(400,"Character 3 -> 10"),
    USER_NOTEXIST(400,"User is not exist"),
    USER_NOTNULLUSERNAME(400,"User Name should not be emty"),
    USER_NOTNULLPASSWORD(400,"Password should not be emty")
    ;

    int code;
    String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
