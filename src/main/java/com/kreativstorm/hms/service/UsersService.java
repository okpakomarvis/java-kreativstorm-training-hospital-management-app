package com.kreativstorm.hms.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService {
    UserDetailsService userDetailsService();
}