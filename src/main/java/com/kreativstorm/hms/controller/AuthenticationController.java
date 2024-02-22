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


<<<<<<< HEAD
    /*@PutMapping("/update/email={email}")
    public ResponseEntity<Users> upadateUser(@PathVariable("email") String email,
                                             @Valid @RequestBody SignUpRequest signUpRequest){
        Users users = new Users();
        if(authenticationService.update(email, signUpRequest).isPresent())
        {
            users = authenticationService.update(email, signUpRequest).get();
            return new  ResponseEntity<>(users, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
*/
=======


>>>>>>> 894f12e529360fca67f1c58310f63373596da94d
}
