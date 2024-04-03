package com.nouhaila.patientjpa.web;

import com.nouhaila.patientjpa.entities.Patient;
import com.nouhaila.patientjpa.repositories.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepo patientRepo;

    @GetMapping("/Patients")
    public List<Patient> listPatients() {
        return patientRepo.findAll();
    }

}
