package com.kreativstorm.hms.repositories;


import com.kreativstorm.hms.entities.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Integer> {
    Optional<Treatment> findTreatmentById(Integer id);
}
