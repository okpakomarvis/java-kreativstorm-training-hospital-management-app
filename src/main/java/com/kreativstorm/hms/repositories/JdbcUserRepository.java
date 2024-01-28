package com.kreativstorm.hms.repositories;

import com.kreativstorm.hms.entities.UserLogin;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor
public class JdbcUserRepository implements UserRepository{
    @Override
    public Optional<UserLogin> getUserByUsername(String username) {
        return Optional.empty();
    }
}
