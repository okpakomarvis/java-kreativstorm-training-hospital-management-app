package com.kreativstorm.hms.dto;

import lombok.Data;

@Data
public class JWTSigninAuthenticationResponse {
    private String token;
    private String refreshToken;
}
