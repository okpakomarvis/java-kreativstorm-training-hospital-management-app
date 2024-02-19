package com.kreativstorm.hms.service;

import com.kreativstorm.hms.dto.*;
import com.kreativstorm.hms.entities.Users;

import java.util.Optional;

public interface AuthenticationService {
    Users signup(SignUpRequest signUpRequest);

    JWTSigninAuthenticationResponse signIn(SigninRequest signinRequest);
    JWTSigninAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

    void deleteUser(DeleteRequest deleteRequest);

    Optional<Users> update(String email, SignUpRequest signUpRequest);
}
