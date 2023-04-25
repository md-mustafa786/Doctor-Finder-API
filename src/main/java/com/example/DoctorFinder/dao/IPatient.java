package com.example.DoctorFinder.dao;

import com.example.DoctorFinder.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatient extends JpaRepository<Patient,Integer> {
}
