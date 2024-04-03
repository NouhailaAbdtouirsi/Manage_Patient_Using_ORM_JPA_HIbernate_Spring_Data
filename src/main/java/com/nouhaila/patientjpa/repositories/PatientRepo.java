package com.nouhaila.patientjpa.repositories;

import com.nouhaila.patientjpa.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {
    Patient findByNom(String nom);
}
