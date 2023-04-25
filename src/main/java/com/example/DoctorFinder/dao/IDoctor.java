package com.example.DoctorFinder.dao;


import com.example.DoctorFinder.model.Doctor;
import com.example.DoctorFinder.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDoctor extends JpaRepository<Doctor,Integer> {

    List<Doctor> findByCityAndSpeciality(String city, Speciality speciality);
}
