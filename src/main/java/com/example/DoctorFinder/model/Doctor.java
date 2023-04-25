package com.example.DoctorFinder.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doctor_tbl")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorId;
    private String doctorName;
    @Pattern(regexp = "^(Delhi|Noida|Faridabad)$", message = "City can only be Delhi, Noida, or Faridabad")
    private String city;
    private String email;
    private String phoneNumber;
    @NotNull(message = "Speciality cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(name = "speciality", nullable = false)
    private Speciality speciality;

}

