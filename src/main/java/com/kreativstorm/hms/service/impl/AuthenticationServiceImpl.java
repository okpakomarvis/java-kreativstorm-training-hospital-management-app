package com.kreativstorm.hms.service.impl;

import com.kreativstorm.hms.dto.*;
import com.kreativstorm.hms.entities.Role;
import com.kreativstorm.hms.entities.Users;
import com.kreativstorm.hms.exception.ClientException;
import com.kreativstorm.hms.repositories.UsersRepository;
import com.kreativstorm.hms.service.AuthenticationService;
import com.kreativstorm.hms.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private  final JWTService jwtService;

    public Users signup(SignUpRequest signUpRequest){
       Optional<Users> userExist = usersRepository.findByEmail(signUpRequest.getEmail());

       if(userExist.isPresent()){
           throw new ClientException("User  Already exist");
       }
        Users users = new Users();

        users.setEmail(signUpRequest.getEmail());
        users.setName(signUpRequest.getName());
        users.setTitle(signUpRequest.getTitle());
        users.setInfo(signUpRequest.getInfo());
        users.setRole(Role.PATIENT);
        users.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        return usersRepository.save(users);

    }
    public JWTSigninAuthenticationResponse signIn(SigninRequest signinRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                signinRequest.getEmail(), signinRequest.getPassword()));
        var user = usersRepository.findByEmail(signinRequest.getEmail()).orElseThrow(()-> new ClientException("invalid email or password"));
        var jwt = jwtService.generateToken(user);
        var resfreshJwt = jwtService.generateRefreshToken(new HashMap<>(), user);
        JWTSigninAuthenticationResponse jwtSigninAuthenticationResponse = new JWTSigninAuthenticationResponse();

        jwtSigninAuthenticationResponse.setToken(jwt);
        jwtSigninAuthenticationResponse.setRefreshToken(resfreshJwt);

        return  jwtSigninAuthenticationResponse;
    }

    public JWTSigninAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest){
        String userEmail = jwtService.extractUserName(refreshTokenRequest.getToken());
        Users user = usersRepository.findByEmail(userEmail).orElseThrow();
        if(jwtService.isTokenValid(refreshTokenRequest.getToken(), user)){
            var jwt = jwtService.generateToken(user);

            JWTSigninAuthenticationResponse jwtSigninAuthenticationResponse = new JWTSigninAuthenticationResponse();

            jwtSigninAuthenticationResponse.setToken(jwt);
            jwtSigninAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());

            return  jwtSigninAuthenticationResponse;

        }

        return null;


    }

    @Override
    public void deleteUser(DeleteRequest deleteRequest) {
        usersRepository.deleteUsersByEmail(deleteRequest.email);
    }

    @Override
    public Optional<Users> update(String email, SignUpRequest signUpRequest) {
        return usersRepository.updateUsersByEmail(email, signUpRequest);
    }
}
