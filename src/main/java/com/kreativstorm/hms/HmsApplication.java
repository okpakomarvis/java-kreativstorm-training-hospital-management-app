package com.kreativstorm.hms;

import com.kreativstorm.hms.entities.Role;
import com.kreativstorm.hms.entities.Users;
import com.kreativstorm.hms.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class HmsApplication  implements CommandLineRunner {
    @Autowired
    private UsersRepository usersRepository;
    public static void main(String[] args) {
        SpringApplication.run(HmsApplication.class, args);
    }
    public void run(String... Args){
        Users adminAccount = usersRepository.findByRole(Role.ADMIN);
        if(null == adminAccount){
            Users users = new Users();
            users.setEmail("admin@gmail.com");
            users.setName("admin");
            users.setTitle("Mr");
            users.setInfo("Super user");
            users.setRole(Role.ADMIN);
            users.setPassword(new BCryptPasswordEncoder().encode("admin"));
            usersRepository.save(users);
        }
    }
}
