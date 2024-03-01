package com.kreativstorm.hms.controller;

import com.kreativstorm.hms.dto.*;
import com.kreativstorm.hms.entities.Users;
import com.kreativstorm.hms.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    public static String email;

    @PostMapping("/signup")
    public ResponseEntity<ResponseRequest> signup(@RequestBody @Valid SignUpRequest signUpRequest){
        ResponseRequest response = new ResponseRequest();
        response.setResponse(authenticationService.signup(signUpRequest));
        return new  ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<JWTSigninAuthenticationResponse> signIn(@RequestBody  @Valid SigninRequest signinRequest){
         return new ResponseEntity<>(authenticationService.signIn(signinRequest), HttpStatus.CREATED);

    }

    @PostMapping("/refresh")
    public ResponseEntity<JWTSigninAuthenticationResponse> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return new ResponseEntity<>(authenticationService.refreshToken(refreshTokenRequest), HttpStatus.CREATED);
    }


}
