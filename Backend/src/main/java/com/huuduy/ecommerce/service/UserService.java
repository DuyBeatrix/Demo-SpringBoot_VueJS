package com.huuduy.ecommerce.service;

import com.huuduy.ecommerce.DTO.request.SignInRequest;
import com.huuduy.ecommerce.DTO.request.SignUpRequest;
import com.huuduy.ecommerce.DTO.response.SignInResponse;
import com.huuduy.ecommerce.DTO.response.SignUpResponse;
import com.huuduy.ecommerce.exception.AuthenticationFailException;
import com.huuduy.ecommerce.exception.CustomException;
import com.huuduy.ecommerce.model.AuthenticationToken;
import com.huuduy.ecommerce.model.User;
import com.huuduy.ecommerce.repository.AuthenticationTokenRepo;
import com.huuduy.ecommerce.repository.UserRepo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import javax.naming.AuthenticationException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class UserService
{
    @Autowired
    UserRepo userRepo;

    Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private AuthenticationTokenRepo authenticationTokenRepo;

    public SignUpResponse signUp(SignUpRequest signUpRequest) throws CustomException
    {
        // Check email already been registered
        if(Objects.nonNull(userRepo.findByEmail(signUpRequest.getEmail()))) {
            throw new CustomException("Email already in use");
        }
        String encryptedPassword = signUpRequest.getPassword();
        try {
            encryptedPassword = hashPassword(signUpRequest.getPassword());
        } catch (NoSuchAlgorithmException e) {
            logger.error("hashing password failed {}", e.getMessage());
        }

        User user = User.builder()
                .firstName(signUpRequest.getFirstName())
                .lastName(signUpRequest.getLastName())
                .email(signUpRequest.getEmail())
                .password(encryptedPassword)
                .build();
        userRepo.save(user);

        AuthenticationToken authenticationToken = new AuthenticationToken(user);
        authenticationTokenRepo.save(authenticationToken);

        return new SignUpResponse("success", "User created successfully");
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException
    {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString().toUpperCase();
    }

    public SignInResponse signIn(SignInRequest signInDto) {
        User user = userRepo.findByEmail(signInDto.getEmail());
        if(Objects.isNull(user)) {
            throw new AuthenticationFailException("User is not valid");
        }
        try {
            if(!user.getPassword().equals(hashPassword(signInDto.getPassword()))){
                throw new AuthenticationFailException("Wrong password");
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        AuthenticationToken token = authenticationTokenRepo.findByUser(user);
        if (Objects.isNull(token)) {
            throw new RuntimeException("Token not found");
        }

        return new SignInResponse("sucess", token.getToken());
    }
}
