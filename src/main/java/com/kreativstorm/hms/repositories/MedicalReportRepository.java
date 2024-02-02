package com.kreativstorm.hms.repositories;

import com.kreativstorm.hms.entities.MedicalReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalReportRepository extends JpaRepository<MedicalReport, Integer> {
}
