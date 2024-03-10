package org.doctorapp.repository;

import org.doctorapp.model.Doctor;
import org.doctorapp.util.DoctorDb;
import org.doctorapp.util.DoctorQueries;

import java.sql.*;
import java.util.*;


public class DoctorRepositoryImpl implements IDoctorRepository {
    @Override
    public void addDoctor(Doctor doctor) {
        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DoctorQueries.INSERTQUERY);
        ) {
            preparedStatement.setString(1, doctor.getDoctorName());
            preparedStatement.setString(2, doctor.getSpeciality());
            preparedStatement.setInt(3, doctor.getExperience());
            preparedStatement.setDouble(4, doctor.getFees());
            preparedStatement.setInt(5, doctor.getRatings());

            boolean result = preparedStatement.execute();
            System.out.println("Added doctor data " + !result);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void updateDoctor(int doctorId, double fees) {
        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DoctorQueries.UPDATEQUERY);
        ) {
            preparedStatement.setDouble(1, fees);
            preparedStatement.setInt(2, doctorId);

            int result = preparedStatement.executeUpdate();
            System.out.println("Updated doctor data rows are " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteDoctor(int doctorId) {
        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DoctorQueries.DELETEQUERY);
        ) {

            preparedStatement.setInt(1, doctorId);

            boolean result = preparedStatement.execute();
            System.out.println("Deleted row " + !result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Doctor findById(int doctorId) {
        Doctor doctor = new Doctor();
        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DoctorQueries.FINDBYID))
        {

            preparedStatement.setInt(1, doctorId);
            try(

            ResultSet resultSet = preparedStatement.executeQuery();
                    ){

            while (resultSet.next()) {
                doctor = new Doctor();
                doctor.setDoctorId(doctorId);
                doctor.setDoctorName(resultSet.getString("doctor_name"));
                doctor.setSpeciality(resultSet.getString("speciality"));
                doctor.setExperience(resultSet.getInt( "experience"));
                doctor.setFees(resultSet.getDouble("fees"));
                doctor.setRatings(resultSet.getInt( "ratings"));
            }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctor;
    }

    @Override
    public List<Doctor> findAll() {
        List<Doctor> doctors = new ArrayList<>();
        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DoctorQueries.FINDALLQUERY);
             ResultSet resultSet = preparedStatement.executeQuery();
             ) {

            while(resultSet.next()){
                Doctor doctor = new Doctor();
                doctor.setDoctorId(resultSet.getInt("doctor_id"));
                doctor.setDoctorName(resultSet.getString("doctor_name"));
                doctor.setSpeciality(resultSet.getString("speciality"));
                doctor.setExperience(resultSet.getInt("experience"));
                doctor.setFees(resultSet.getDouble("fees"));
                doctor.setRatings(resultSet.getInt("ratings"));
                doctors.add(doctor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }



    @Override
    public List<Doctor> findBySpeciality(String speciality)
    {
        List<Doctor> doctors = new ArrayList<>();
        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DoctorQueries.FINDBYSPECIALITY)) {

            preparedStatement.setString(1, speciality);
            try(
                ResultSet resultSet = preparedStatement.executeQuery(); ) {
                
                    while (resultSet.next()) {
                        Doctor doctor = new Doctor();
                        doctor.setDoctorId(resultSet.getInt("doctor_id"));
                        doctor.setDoctorName(resultSet.getString("doctor_name"));
                        doctor.setSpeciality(resultSet.getString("speciality"));
                        doctor.setExperience(resultSet.getInt("experience"));
                        doctor.setFees(resultSet.getDouble("fees"));
                        doctor.setRatings(resultSet.getInt("ratings"));
        
                        doctors.add(doctor);
                }


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    @Override
    public List<Doctor> findBySpecialityAndExp(String speciality, int experience) {
        List<Doctor> doctors = new ArrayList<>();
        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DoctorQueries.FINDBYSPECIALITYANDEXP))
        {

            preparedStatement.setString(1, speciality);
            preparedStatement.setInt(2, experience);
            try(
                ResultSet resultSet = preparedStatement.executeQuery();){

                    
                    while (resultSet.next()) {
                        Doctor doctor = new Doctor();
                        doctor.setDoctorId(resultSet.getInt("doctor_id"));
                        doctor.setDoctorName(resultSet.getString("doctor_name"));
                        doctor.setSpeciality(resultSet.getString("speciality"));
                        doctor.setExperience(resultSet.getInt("experience"));
                        doctor.setFees(resultSet.getDouble("fees"));
                        doctor.setRatings(resultSet.getInt("ratings"));
                        
                        doctors.add(doctor);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;

    }

    @Override
    public List<Doctor> findBySpecialityAndLessFees(String speciality, double fees) {
        List<Doctor> doctors = new ArrayList<>();
        try(Connection connection = DoctorDb.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DoctorQueries.FINDBYSPECIALITYANDFEES);
        ){
            preparedStatement.setString(1,speciality);
            preparedStatement.setDouble(2, fees);
            try(ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()){
                    Doctor doctor = new Doctor();
                    doctor.setDoctorId(resultSet.getInt("doctor_id"));
                    doctor.setDoctorName(resultSet.getString("doctor_name"));
                    doctor.setSpeciality(resultSet.getString("speciality"));
                    doctor.setExperience(resultSet.getInt("experience"));
                    doctor.setFees(resultSet.getDouble("fees"));
                    doctor.setRatings(resultSet.getInt("ratings"));
                    
                    doctors.add(doctor);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return doctors;
    }

    @Override
    public List<Doctor> findBySpecialityAndRatings(String speciality, int ratings) {
        List<Doctor> doctors = new ArrayList<>();
        try(Connection connection = DoctorDb.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DoctorQueries.FINDBYSPECIALITYANDRATINGS);
        ){
            preparedStatement.setString(1,speciality);
            preparedStatement.setDouble(2, ratings);
            try (
                ResultSet resultSet = preparedStatement.executeQuery();
                ) {

                    
                    
                    while (resultSet.next()){
                        Doctor doctor = new Doctor();
                        doctor.setDoctorId(resultSet.getInt("doctor_id"));
                        doctor.setDoctorName(resultSet.getString("doctor_name"));
                        doctor.setSpeciality(resultSet.getString("speciality"));
                        doctor.setExperience(resultSet.getInt("experience"));
                        doctor.setFees(resultSet.getDouble("fees"));
                        doctor.setRatings(resultSet.getInt("ratings"));
                        
                        doctors.add(doctor);
                    }

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return doctors;
    }

    @Override
    public List<Doctor> findBySpecialityAndNameContains(String speciality, String doctorName) {
        List<Doctor> doctors = new ArrayList<>();
        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DoctorQueries.FINDBYSPECIALITYANDNAME);
        ) {
            preparedStatement.setString(1, speciality);
            preparedStatement.setString(2, "%"+doctorName+"%");
            try(ResultSet resultSet = preparedStatement.executeQuery();) {

                
                
                while (resultSet.next()) {
                Doctor doctor = new Doctor();
                doctor.setDoctorId(resultSet.getInt("doctor_id"));
                doctor.setDoctorName(resultSet.getString("doctor_name"));
                doctor.setSpeciality(resultSet.getString("speciality"));
                doctor.setExperience(resultSet.getInt("experience"));
                doctor.setFees(resultSet.getDouble("fees"));
                doctor.setRatings(resultSet.getInt("ratings"));
                
                doctors.add(doctor);
            }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctors;
    }
}
