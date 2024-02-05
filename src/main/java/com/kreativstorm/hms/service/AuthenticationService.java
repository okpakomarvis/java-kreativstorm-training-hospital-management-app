package com.kreativstorm.hms.service;

import com.kreativstorm.hms.dto.JWTSigninAuthenticationResponse;
import com.kreativstorm.hms.dto.RefreshTokenRequest;
import com.kreativstorm.hms.dto.SignUpRequest;
import com.kreativstorm.hms.dto.SigninRequest;
import com.kreativstorm.hms.entities.Users;

public interface AuthenticationService {
    Users signup(SignUpRequest signUpRequest);

    JWTSigninAuthenticationResponse signIn(SigninRequest signinRequest);
    JWTSigninAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
