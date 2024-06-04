package demo.spring.controller;


import demo.spring.dto.request.LoginRequestDTO;
import demo.spring.dto.request.UserRequestDTO;
import demo.spring.dto.respone.ApiRespone;
import demo.spring.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Year;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

     private final UserService userService;


     @PostMapping("/register")
     public Integer insertUser(@RequestBody @Valid UserRequestDTO user){
         return userService.insertUser(user);
     }

//     @PostMapping("/login")
//    public ApiRespone login(@RequestBody @Valid LoginRequestDTO user){
//
//     }

}
