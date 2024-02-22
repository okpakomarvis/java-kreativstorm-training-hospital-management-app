package com.kreativstorm.hms.repositories;



import com.kreativstorm.hms.dto.SignUpRequest;
import com.kreativstorm.hms.entities.Role;
import com.kreativstorm.hms.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);

    Users findByRole(Role role);


<<<<<<< HEAD
    //Optional<Users> updateUsersByEmail(String email, SignUpRequest signUpRequest);
=======
>>>>>>> 894f12e529360fca67f1c58310f63373596da94d
}


