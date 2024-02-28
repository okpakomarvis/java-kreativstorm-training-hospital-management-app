package com.kreativstorm.hms.service.impl;

import com.kreativstorm.hms.dto.SignUpRequest;
import com.kreativstorm.hms.entities.Role;
import com.kreativstorm.hms.entities.Users;
import com.kreativstorm.hms.exception.ClientException;
import com.kreativstorm.hms.repositories.UsersRepository;
import com.kreativstorm.hms.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    @Override
    public void deleteUser(Integer userId) {
        Optional<Users> user  = usersRepository.findById((long) userId);
        if(user.isEmpty()){
            throw new ClientException("User does not exist");
        }else {
            usersRepository.deleteById((long) userId);
        }
    }

    @Override
    public Optional<Users> update(int id, SignUpRequest signUpRequest) {
        Users user = new Users();
        user.setId((long) id);
        user.setEmail(signUpRequest.getEmail());
        user.setTitle(signUpRequest.getTitle());
        user.setInfo(signUpRequest.getInfo());
        user.setName(signUpRequest.getName());
        user.setPassword(signUpRequest.getPassword());
        user.setRole(Role.PATIENT);
        return Optional.of(usersRepository.saveAndFlush(user));
    }

    @Override
    public Optional<Users> getCurrentUser(String email) {
        return usersRepository.findByEmail(email);
    }

    @Override
    public List<Users> getAllPatients() {

        Predicate<Users> user = (u)->u.getRole() ==Role.PATIENT ;

        //return usersRepository.getAllByAuthoritiesIs("PATIENT");
        List<Users> users = usersRepository.findAll();

        if(users.isEmpty()){
            users = Collections.emptyList();
        }else {
          users = users.stream().filter(user).collect(Collectors.toList());
        }

        return users;

    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<Users> getUserByID(Long id) {
        return usersRepository.findById(id);
    }


}
