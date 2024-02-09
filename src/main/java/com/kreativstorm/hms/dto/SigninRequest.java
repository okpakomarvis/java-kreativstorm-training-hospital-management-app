package com.kreativstorm.hms.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SigninRequest {
    @NotNull(message = "must not be null")
    private String email;
    @NotNull(message = "must not be null")
    private String password;
}
