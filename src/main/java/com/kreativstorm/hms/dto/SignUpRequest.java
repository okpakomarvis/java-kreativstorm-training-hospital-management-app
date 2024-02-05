package com.kreativstorm.hms.dto;

import lombok.Data;

@Data
public class SignUpRequest {
    private String email;
    private String password;
    private String title;
    private String name;
    private String info;
}
