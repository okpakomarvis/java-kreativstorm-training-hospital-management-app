package com.kreativstorm.hms.repositories;

import com.kreativstorm.hms.entities.UserLogin;

import java.util.Optional;

public interface UserRepository {
    Optional<UserLogin> getUserByUsername(String username);
}
