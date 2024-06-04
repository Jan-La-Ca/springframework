package demo.spring.exception;


import demo.spring.dto.respone.ApiRespone;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<ApiRespone> handlingRuntimeException(RuntimeException exception){
        ApiRespone respone = ApiRespone.builder().code(ErrorCode.USER_EXIST.getCode()).message(ErrorCode.USER_EXIST.getMessage()).build();
        return ResponseEntity.internalServerError().body(respone);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiRespone> handlingMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        String enumKey = exception.getFieldError().getDefaultMessage();
        ErrorCode errorCode = ErrorCode.valueOf(enumKey);
        ApiRespone respone = ApiRespone.builder().code(errorCode.getCode()).message(errorCode.getMessage()).build();
        return ResponseEntity.badRequest().body(respone);
    }
}
