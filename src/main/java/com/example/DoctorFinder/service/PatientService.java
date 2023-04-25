package com.example.DoctorFinder.service;

import com.example.DoctorFinder.dao.IDoctor;
import com.example.DoctorFinder.dao.IPatient;
import com.example.DoctorFinder.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private IPatient patientRepo;


    public void addPatient(Patient patient) {
        patientRepo.save(patient);
    }

    public void removePatient(Integer patientId) {
        patientRepo.deleteById(patientId);
    }

}
