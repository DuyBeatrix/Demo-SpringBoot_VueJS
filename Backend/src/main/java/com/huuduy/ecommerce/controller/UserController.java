package com.huuduy.ecommerce.controller;

import com.huuduy.ecommerce.DTO.request.SignInRequest;
import com.huuduy.ecommerce.DTO.request.SignUpRequest;
import com.huuduy.ecommerce.DTO.response.SignInResponse;
import com.huuduy.ecommerce.DTO.response.SignUpResponse;
import com.huuduy.ecommerce.exception.CustomException;
import com.huuduy.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public SignUpResponse signUp(@RequestBody SignUpRequest signupDto) throws CustomException {
        return userService.signUp(signupDto);
    }

    @PostMapping("/signin")
    public SignInResponse signIn(@RequestBody SignInRequest signInDto) {
        return userService.signIn(signInDto);
    }
}
