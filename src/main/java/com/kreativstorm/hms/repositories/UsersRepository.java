package com.kreativstorm.hms.repositories;



import com.kreativstorm.hms.dto.SignUpRequest;
import com.kreativstorm.hms.entities.Role;
import com.kreativstorm.hms.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);

    Users findByRole(Role role);

    Users getUsersById(Integer id);

    List<Users> getAllByAuthoritiesIs(String authority);
}


