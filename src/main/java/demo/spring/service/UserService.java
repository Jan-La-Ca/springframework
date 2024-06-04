package demo.spring.service;


import demo.spring.dto.request.LoginRequestDTO;
import demo.spring.dto.request.UserRequestDTO;
import demo.spring.entity.Users;
import demo.spring.exception.ApiException;
import demo.spring.exception.ErrorCode;
import demo.spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Integer insertUser(UserRequestDTO user){
        if(userRepository.existsByUserName(user.getUserName()))
            throw new  ApiException(ErrorCode.USER_EXIST);
        Users data = Users.builder()
                .userName(user.getUserName())
                .dob(user.getDob())
                .password(user.getPassword())
                .build();
        userRepository.save(data);
        return 100;
    }

    public boolean login(LoginRequestDTO login){
        if(!userRepository.existsByUserName(login.getUserName()))
            throw new ApiException(ErrorCode.USER_NOTEXIST);
        return userRepository.existsByUserName(login.getUserName());
    }
}
