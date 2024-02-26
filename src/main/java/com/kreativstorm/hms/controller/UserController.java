package com.kreativstorm.hms.controller;

import com.kreativstorm.hms.dto.SignUpRequest;
import com.kreativstorm.hms.entities.Users;
import com.kreativstorm.hms.exception.ClientException;
import com.kreativstorm.hms.service.UsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final  UsersService usersService;

    @PutMapping("/update/{id}")
    public ResponseEntity<Users> upadateUser(@PathVariable("id") Integer id,
                                             @Valid @RequestBody SignUpRequest signUpRequest){
        Optional<Users> user = usersService.update(id, signUpRequest);
        if(user.isEmpty()){
            throw new ClientException("User Not Found");
        }
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        usersService.deleteUser(id);
    }

    @GetMapping("/current-user")
    public ResponseEntity<Users> getCurrentUser(){
        Optional<Users> user = usersService.getCurrentUser(1);
        if(user.isEmpty()){
            throw new ClientException("User Not Found");
        }
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    @GetMapping("/patients")
    public List<Users> getAllPatients(){
        return usersService.getAllPatients();
    }

    @GetMapping("/all")
    public List<Users> getAllUsers(){
        return usersService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserByID(@PathVariable("id") Long id){
        return usersService.getUserByID(id).map(users -> ResponseEntity.status(HttpStatus.FOUND))
                .orElseGet(()-> ResponseEntity.status(HttpStatus.NOT_FOUND)).build();
    }

}
