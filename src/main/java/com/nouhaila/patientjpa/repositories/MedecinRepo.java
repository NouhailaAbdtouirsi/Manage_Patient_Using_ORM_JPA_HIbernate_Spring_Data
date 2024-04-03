package com.nouhaila.patientjpa.repositories;

import com.nouhaila.patientjpa.entities.Medecin;
import com.nouhaila.patientjpa.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepo extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String nom);
}
