package org.doctorapp.service;

import org.doctorapp.exception.DoctorNotFoundException;
import org.doctorapp.exception.IdNotFoundException;
import org.doctorapp.model.Doctor;
import org.doctorapp.repository.DoctorRepositoryImpl;
import org.doctorapp.repository.IDoctorRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DoctorServiceImpl implements IDoctorService {
    IDoctorRepository doctorRepository = new DoctorRepositoryImpl();
    @Override
    public void addDoctor(Doctor doctor) {
        doctorRepository.addDoctor(doctor);
    }

    @Override
    public void updateDoctor(int doctorId, double fees) {
        doctorRepository.updateDoctor(doctorId, fees);
    }

    @Override
    public void deleteDoctor(int doctorId) {
        doctorRepository.deleteDoctor(doctorId);
    }

    @Override
    public Doctor findById(int doctorId) throws IdNotFoundException {
        Doctor doctor = doctorRepository.findById(doctorId);
        if(doctor == null) throw new IdNotFoundException("Id not found");
        return doctor;
    }

    @Override
    public List<Doctor> findAll() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors;
    }

    @Override
    public List<Doctor> findBySpeciality(String speciality) throws DoctorNotFoundException {
        List<Doctor> doctors = doctorRepository.findBySpeciality(speciality);
        System.out.println(speciality);
        if(doctors.isEmpty()) throw new DoctorNotFoundException("Doctor with the speciality entered not found");
        Collections.sort(doctors,(d1,d2) -> d1.getDoctorName().compareTo(d2.getSpeciality()));
        return doctors;
    }

    @Override
    public List<Doctor> findBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException {
        List<Doctor> doctors = doctorRepository.findBySpecialityAndExp(speciality, experience);
        if(doctors.isEmpty()) throw new DoctorNotFoundException("Doctor with the speciality and experience entered not found");
        Collections.sort(doctors,(d1,d2)-> ((Integer)(d2.getExperience())).compareTo(d1.getExperience()));
        return doctors;
    }

    @Override
    public List<Doctor> findBySpecialityAndLessFees(String speciality, double fees) throws DoctorNotFoundException {
        List<Doctor> doctors = doctorRepository.findBySpecialityAndLessFees(speciality, fees);
        if (doctors.isEmpty()) throw new DoctorNotFoundException("Doctor with this speciality and fees entered not found");
        Collections.sort(doctors, (d1,d2)-> ((Double)(d1.getFees())).compareTo(d2.getFees()));
        return doctors;
    }

    @Override
    public List<Doctor> findBySpecialityAndRatings(String speciality, int ratings) throws DoctorNotFoundException {
        List<Doctor> doctors = doctorRepository.findBySpecialityAndRatings(speciality, ratings);
        if (doctors.isEmpty()) throw new DoctorNotFoundException("Doctor with this speciality and ratings entered not found");
        Collections.sort(doctors,(d1,d2)-> ((Integer)(d1.getRatings())).compareTo(d1.getRatings()));
        return doctors;
    }

    @Override
    public List<Doctor> findBySpecialityAndNameContains(String speciality, String doctorName) throws DoctorNotFoundException {
        List<Doctor> doctors = doctorRepository.findBySpecialityAndNameContains(speciality, doctorName);
        if (doctors.isEmpty()) throw new DoctorNotFoundException("Doctor with this speciality and name entered not found");
        Collections.sort(doctors,(d1,d2)-> (d2.getDoctorName().compareTo(d2.getDoctorName())));
        return doctors;
    }
}