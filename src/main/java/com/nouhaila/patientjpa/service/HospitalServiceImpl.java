package com.nouhaila.patientjpa.service;

import com.nouhaila.patientjpa.entities.Consultation;
import com.nouhaila.patientjpa.entities.Medecin;
import com.nouhaila.patientjpa.entities.Patient;
import com.nouhaila.patientjpa.entities.RendezVous;
import com.nouhaila.patientjpa.repositories.ConsultationRepo;
import com.nouhaila.patientjpa.repositories.MedecinRepo;
import com.nouhaila.patientjpa.repositories.PatientRepo;
import com.nouhaila.patientjpa.repositories.RDVRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @Transactional
public class HospitalServiceImpl implements HospitalService {
    private PatientRepo patientRepo;
    private ConsultationRepo consultationRepo;
    private RDVRepo rdvRepo;
    private MedecinRepo medecinRepo;

    public HospitalServiceImpl(PatientRepo patientRepo,
                               ConsultationRepo consultationRepo,
                               RDVRepo rdvRepo,
                               MedecinRepo medecinRepo) {
        this.patientRepo = patientRepo;
        this.consultationRepo = consultationRepo;
        this.rdvRepo = rdvRepo;
        this.medecinRepo = medecinRepo;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepo.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepo.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rdvRepo.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepo.save(consultation);
    }
}
