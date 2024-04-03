package com.nouhaila.patientjpa;

import com.nouhaila.patientjpa.entities.*;
import com.nouhaila.patientjpa.repositories.ConsultationRepo;
import com.nouhaila.patientjpa.repositories.MedecinRepo;
import com.nouhaila.patientjpa.repositories.PatientRepo;
import com.nouhaila.patientjpa.repositories.RDVRepo;
import com.nouhaila.patientjpa.service.HospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class PatientJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientJpaApplication.class, args);
    }
    /*
    CommandLineRunner start(PatientRepo patientRepo,
                            MedecinRepo medecinRepo,
                            RDVRepo rdvRepo,
                            ConsultationRepo consultationRepo) {
        return args -> {
            Stream.of("Amine", "Nouhaila", "Yassine", "Oumaima").forEach(nom -> {
                Patient patient = new Patient();
                patient.setNom(nom);
                patient.setDateNaissance(new Date());
                patient.setMalade(Math.random() < 0.5);
                patientRepo.save(patient);
            });
            Stream.of("Dr. Ali", "Dr. Youssef", "Dr. Fatima", "Dr. Samira").forEach(nom -> {
                Medecin medecin = new Medecin();
                medecin.setNom(nom);
                medecin.setEmail(nom.replaceAll("\\s", "") + "@gmail.com");
                medecin.setSpecialite(Math.random() < 0.5 ? "Dentiste" : "Cardiologue");
                medecinRepo.save(medecin);
            });
            System.out.println("***************************");
            System.out.println("Find by id 1");
            Patient patient = patientRepo.findById(1L).orElse(null);
            System.out.println("find by nom Nouhaila");
            Patient patient2 = patientRepo.findByNom("Nouhaila");
            System.out.println("***************************");
            Medecin medecin = medecinRepo.findByNom("Dr. Ali");
            RendezVous rdv = new RendezVous();
            rdv.setDate(new Date());
            rdv.setStatus(StatusRdv.DONE);
            rdv.setMedecin(medecin);
            rdv.setPatient(patient);
            rdvRepo.save(rdv);
            RendezVous rdv1 = rdvRepo.findById(1L).orElse(null);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rdv1);
            consultation.setRapport("Rapport de consultation");
            consultationRepo.save(consultation);

        };
    }
     */
    @Bean
    CommandLineRunner start(HospitalService hospitalService,
                            PatientRepo patientRepo,
                            MedecinRepo medecinRepo,
                            RDVRepo rdvRepo,
                            ConsultationRepo consultationRepo) {
        return args -> {
            Stream.of("Amine", "Nouhaila", "Yassine", "Oumaima").forEach(nom -> {
                Patient patient = new Patient();
                patient.setNom(nom);
                patient.setDateNaissance(new Date());
                patient.setMalade(Math.random() < 0.5);
                hospitalService.savePatient(patient);
            });
            Stream.of("Dr. Ali", "Dr. Youssef", "Dr. Fatima", "Dr. Samira").forEach(nom -> {
                Medecin medecin = new Medecin();
                medecin.setNom(nom);
                medecin.setEmail(nom.replaceAll("\\s", "") + "@gmail.com");
                medecin.setSpecialite(Math.random() < 0.5 ? "Dentiste" : "Cardiologue");
                hospitalService.saveMedecin(medecin);
            });
            Patient patient = patientRepo.findById(1L).orElse(null);
            Patient patient2 = patientRepo.findByNom("Nouhaila");
            Medecin medecin = medecinRepo.findByNom("Dr. Ali");
            RendezVous rdv = new RendezVous();
            rdv.setDate(new Date());
            rdv.setStatus(StatusRdv.DONE);
            rdv.setMedecin(medecin);
            rdv.setPatient(patient);
            RendezVous savedRdv = hospitalService.saveRendezVous(rdv);
            System.out.println(savedRdv.getId());
            RendezVous rdv1 = rdvRepo.findAll().get(0);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rdv1);
            consultation.setRapport("Rapport de consultation");
            hospitalService.saveConsultation(consultation);

        };
    }

}
