package com.kreativstorm.hms.controller;

import com.kreativstorm.hms.dto.JWTSigninAuthenticationResponse;
import com.kreativstorm.hms.dto.RefreshTokenRequest;
import com.kreativstorm.hms.dto.SignUpRequest;
import com.kreativstorm.hms.dto.SigninRequest;
import com.kreativstorm.hms.entities.Users;
import com.kreativstorm.hms.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<Users> signup(@RequestBody SignUpRequest signUpRequest){
        return new  ResponseEntity<>(authenticationService.signup(signUpRequest), HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<JWTSigninAuthenticationResponse> signIn(@RequestBody SigninRequest signinRequest){
        return new ResponseEntity<>(authenticationService.signIn(signinRequest), HttpStatus.CREATED);
    }

    @PostMapping("/refresh")
    public ResponseEntity<JWTSigninAuthenticationResponse> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return new ResponseEntity<>(authenticationService.refreshToken(refreshTokenRequest), HttpStatus.CREATED);
    }
}
