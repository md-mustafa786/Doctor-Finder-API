package com.example.DoctorFinder.service;

import com.example.DoctorFinder.dao.IDoctor;
import com.example.DoctorFinder.dao.IPatient;
import com.example.DoctorFinder.model.Doctor;
import com.example.DoctorFinder.model.Patient;
import com.example.DoctorFinder.model.Speciality;
import com.example.DoctorFinder.model.Symptom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private IDoctor iDoctor;

    @Autowired
    private IPatient patientRepo;

    public void addDoctor(Doctor doctor) {
        iDoctor.save(doctor);
    }


    public List<Doctor> findDoctorsByPatientSymptom(Integer patientId) throws RuntimeException {
        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        List<Doctor> doctors = iDoctor.findByCityAndSpeciality(patient.getCity(), getSpeciality(patient.getSymptom()));
        if(!city(patient.getCity())){
            throw new RuntimeException("Sorry!! We are still waiting to expand to your location");
        }
        if (doctors.isEmpty()) {
            throw new RuntimeException("There isn't any doctor present at your location for your symptom");
        }

        return doctors;
    }

    private Speciality getSpeciality(Symptom symptom) {
        switch (symptom) {
            case ARTHRITIS:
            case BACK_PAIN:
            case TISSUE_INJURIES:
                return Speciality.ORTHOPEDIC;
            case DYSMENORRHEA:
                return Speciality.GYNECOLOGY;
            case SKIN_INFECTION:
            case SKIN_BURN:
                return Speciality.DERMATOLOGY;
            case EAR_PAIN:
                return Speciality.ENT_SPECIALIST;
        }
        return null;
    }

    public void removeDoctor(Integer doctorId) {
        iDoctor.deleteById(doctorId);
    }


    public List<String> cityList=new ArrayList<>();
    public boolean city(String city){
        cityList.add("Delhi");
        cityList.add("Faridabad");
        cityList.add("Noida");
        return cityList.contains(city);
    }
}