package com.kreativstorm.hms.service;

import com.kreativstorm.hms.dto.SignUpRequest;
import com.kreativstorm.hms.entities.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    UserDetailsService userDetailsService();

    void deleteUser(Integer userId);

    Optional<Users> update(int id, SignUpRequest signUpRequest);

    Users getCurrentUser(Integer id);

    List<Users> getAllPatients();

    List<Users> getAllUsers();

    Optional<Users> getUserByID(Long id);
}
