package com.nouhaila.patientjpa.repositories;

import com.nouhaila.patientjpa.entities.Consultation;
import com.nouhaila.patientjpa.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepo extends JpaRepository<Consultation, Long> {
}
