package com.kreativstorm.hms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    String username;
    Role role;
    String name;
    String title;
    String info;
}
