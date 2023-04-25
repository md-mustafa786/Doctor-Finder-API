package com.example.DoctorFinder.controller;

import com.example.DoctorFinder.model.Doctor;
import com.example.DoctorFinder.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("add/doctor")
    ResponseEntity<String> addDoctor(@RequestBody @Valid Doctor doctor){
        doctorService.addDoctor(doctor);
        return new ResponseEntity<>("Doctor added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("remove/doctor/{doctorId}")
    ResponseEntity<String> deleteDoctor(@PathVariable Integer doctorId){
        doctorService.removeDoctor(doctorId);
        return new ResponseEntity<>("Doctor removed successfully",HttpStatus.OK);
    }

    @GetMapping("find/doctor/{patientId}")
    public List<Doctor> findDoctorsByPatientSymptom(@PathVariable Integer patientId){
        return doctorService.findDoctorsByPatientSymptom(patientId);
    }


}
