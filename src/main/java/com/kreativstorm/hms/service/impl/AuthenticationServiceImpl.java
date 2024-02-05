package com.kreativstorm.hms.service.impl;

import com.kreativstorm.hms.dto.JWTSigninAuthenticationResponse;
import com.kreativstorm.hms.dto.RefreshTokenRequest;
import com.kreativstorm.hms.dto.SignUpRequest;
import com.kreativstorm.hms.dto.SigninRequest;
import com.kreativstorm.hms.entities.Role;
import com.kreativstorm.hms.entities.Users;
import com.kreativstorm.hms.repositories.UserRepository;
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
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private  final JWTService jwtService;

    public Users signup(SignUpRequest signUpRequest){
       Optional<Users> userExist = userRepository.findByEmail(signUpRequest.getEmail());

       if(userExist.isPresent()){
           throw new RuntimeException("User  Already exist");
       }
        Users users = new Users();

        users.setEmail(signUpRequest.getEmail());
        users.setName(signUpRequest.getName());
        users.setTitle(signUpRequest.getTitle());
        users.setInfo(signUpRequest.getInfo());
        users.setRole(Role.PATIENT);
        users.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        return userRepository.save(users);

    }
    public JWTSigninAuthenticationResponse signIn(SigninRequest signinRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                signinRequest.getEmail(), signinRequest.getPassword()));
        var user = userRepository.findByEmail(signinRequest.getEmail()).orElseThrow(()-> new IllegalArgumentException("invalid email or password"));
        var jwt = jwtService.generateToken(user);
        var resfreshJwt = jwtService.generateRefreshToken(new HashMap<>(), user);
        JWTSigninAuthenticationResponse jwtSigninAuthenticationResponse = new JWTSigninAuthenticationResponse();

        jwtSigninAuthenticationResponse.setToken(jwt);
        jwtSigninAuthenticationResponse.setRefreshToken(resfreshJwt);

        return  jwtSigninAuthenticationResponse;
    }

    public JWTSigninAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest){
        String userEmail = jwtService.extractUserName(refreshTokenRequest.getToken());
        Users user = userRepository.findByEmail(userEmail).orElseThrow();
        if(jwtService.isTokenValid(refreshTokenRequest.getToken(), user)){
            var jwt = jwtService.generateToken(user);

            JWTSigninAuthenticationResponse jwtSigninAuthenticationResponse = new JWTSigninAuthenticationResponse();

            jwtSigninAuthenticationResponse.setToken(jwt);
            jwtSigninAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());

            return  jwtSigninAuthenticationResponse;

        }

        return null;


    }
}
