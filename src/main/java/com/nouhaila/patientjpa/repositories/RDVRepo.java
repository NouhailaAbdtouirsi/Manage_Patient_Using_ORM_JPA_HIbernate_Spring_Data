package com.nouhaila.patientjpa.repositories;

import com.nouhaila.patientjpa.entities.Medecin;
import com.nouhaila.patientjpa.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RDVRepo extends JpaRepository<RendezVous, String> {
}
