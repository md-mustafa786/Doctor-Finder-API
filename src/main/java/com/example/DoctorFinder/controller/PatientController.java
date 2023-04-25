package com.example.DoctorFinder.controller;

import com.example.DoctorFinder.model.Patient;
import com.example.DoctorFinder.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;


    @PostMapping("add/patient")
    ResponseEntity<String> addPatient(@RequestBody @Valid Patient patient){
        patientService.addPatient(patient);
        return new ResponseEntity<>("Patient added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("remove/patient/{patientId}")
    ResponseEntity<String> deletePatient(@PathVariable Integer patientId){
        patientService.removePatient(patientId);
        return new ResponseEntity<>("Patient removed successfully",HttpStatus.OK);
    }

}
