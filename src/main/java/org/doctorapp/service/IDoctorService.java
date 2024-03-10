package org.doctorapp.service;

import org.doctorapp.exception.DoctorNotFoundException;
import org.doctorapp.exception.IdNotFoundException;
import org.doctorapp.model.Doctor;

import java.util.List;

public interface IDoctorService {

    void addDoctor(Doctor doctor);
    void updateDoctor(int doctorId,double fees);
    void deleteDoctor(int doctorId);
    Doctor findById(int doctorId) throws IdNotFoundException;
    List<Doctor> findAll();
    List<Doctor> findBySpeciality(String speciality) throws DoctorNotFoundException;
    List<Doctor> findBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException;
    List<Doctor> findBySpecialityAndLessFees(String speciality, double fees)throws DoctorNotFoundException;
    List<Doctor> findBySpecialityAndRatings(String speciality, int ratings)throws DoctorNotFoundException;
    List<Doctor> findBySpecialityAndNameContains(String speciality, String doctorName)throws DoctorNotFoundException;



}
