package com.nouhaila.patientjpa.service;

import com.nouhaila.patientjpa.entities.Consultation;
import com.nouhaila.patientjpa.entities.Medecin;
import com.nouhaila.patientjpa.entities.Patient;
import com.nouhaila.patientjpa.entities.RendezVous;

public interface HospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
