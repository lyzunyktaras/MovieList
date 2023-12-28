package com.codeseek.movie.controller;

import com.codeseek.movie.dto.AuthUserDTO;
import com.codeseek.movie.dto.RegisterUserDTO;
import com.codeseek.movie.dto.ResponseDTO;
import com.codeseek.movie.dto.UserDTO;
import com.codeseek.movie.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseDTO<String> authenticateUser(@RequestBody AuthUserDTO authUserDTO) {
        return new ResponseDTO<>(authenticationService.authenticateUser(authUserDTO));
    }

    @PostMapping("/register")
    public ResponseDTO<UserDTO> registerUser(@RequestBody RegisterUserDTO registerUserDTO) {
        return new ResponseDTO<>(authenticationService.registerUser(registerUserDTO));
    }
}
