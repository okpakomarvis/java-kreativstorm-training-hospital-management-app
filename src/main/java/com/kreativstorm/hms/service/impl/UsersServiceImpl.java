package com.kreativstorm.hms.service.impl;

import com.kreativstorm.hms.exception.ClientException;
import com.kreativstorm.hms.repositories.UsersRepository;
import com.kreativstorm.hms.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

    @Override
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return usersRepository.findByEmail(username).orElseThrow(() -> new ClientException("User not found"));
            }
        };
    }
}
