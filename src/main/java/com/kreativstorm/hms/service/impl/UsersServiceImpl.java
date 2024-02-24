package com.kreativstorm.hms.service.impl;

import com.kreativstorm.hms.dto.DeleteRequest;
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

import java.util.List;
import java.util.Optional;

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
    public Users getCurrentUser(Integer id) {
        return usersRepository.getUsersById(id);
    }

    @Override
    public List<Users> getAllPatients() {
        return usersRepository.getAllByAuthoritiesIs("PATIENT");
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
