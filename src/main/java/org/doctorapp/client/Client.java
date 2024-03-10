package org.doctorapp.client;

import java.util.List;
import java.util.Scanner;

import org.doctorapp.model.Doctor;
import org.doctorapp.model.SpecializationEnum;
import org.doctorapp.service.DoctorServiceImpl;
import org.doctorapp.service.IDoctorService;

public class Client {
    public static void main(String[] args)
    {
        IDoctorService doctorService = new DoctorServiceImpl();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1.Create a new doctor record\n2.Update fees of doctor\n3.Delete doctor record"
                    + "\n4.Find Doctor by id\n5.Find all doctors\n6.Find doctors by speciality"
                    + "\n7.Find doctors by speciality and experience\n8.Find doctors by speciality and consultation fees\n9.Find doctors by speciality and rating"
                    + "\n10.Find doctors by speciality and name"
                    + "\n11.Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            try {
                switch (choice) {
                    case 1 :{
                        System.out.println("----- Creating a new doctor record -----");
                        System.out.println("Enter the doctor name: ");
                        String doctor_name = scanner.next();
                        System.out.println("Enter the speciality(ORTHO | PEDIA | PHYSICIAN | GYNAEC | NEURO | DERMA): ");
                        String speciality = scanner.next();
                        SpecializationEnum SpecializationEnum = org.doctorapp.model.SpecializationEnum.valueOf(speciality);
                        String spec = SpecializationEnum.getSpeciality();
                        System.out.println("Enter the experience: ");
                        int experience = scanner.nextInt();
                        System.out.println("Enter the ratings: ");
                        int ratings = scanner.nextInt();
                        System.out.println("Enter the fees: ");
                        double fees = scanner.nextDouble();

                        Doctor doctor = new Doctor(doctor_name, spec, fees, experience, ratings);
                        doctorService.addDoctor(doctor);
                        System.out.println("Created new doctor entry");
                    }
                    break;
                    case 2 :{
                        System.out.println("----- Updating a fees of doctor -----");
                        System.out.println("Enter the id of the doctor: ");
                        int docId = scanner.nextInt();
                        System.out.println("Enter the consultation fees of doctor:");
                        double fees = scanner.nextDouble();
                        doctorService.updateDoctor( docId, fees);
                        System.out.println("Doctor fees is updated.");
                    }
                    break;
                    case 3 :{
                        System.out.println("----- Deleting a doctor record -----");
                        System.out.println("Enter the doctor id to be deleted: ");
                        int doctorId = scanner.nextInt();
                        doctorService.deleteDoctor(doctorId);
                    }
                    break;
                    case 4 :{
                        System.out.println("----- Display Doctor Information -----");
                        System.out.println("Enter the doctor id: ");
                        int doctorId = scanner.nextInt();
                        Doctor doctor = doctorService.findById(doctorId);
                        System.out.println(doctor);
                    }
                    break;
                    case 5 :{
                        System.out.println("Display all Doctors Information: ");
                        List<Doctor> doctors = doctorService.findAll();
                        for (Doctor doctor : doctors) {
                            System.out.println(doctor);
                        }
                    }
                    break;
                    case 6 :{
                        System.out.println("----- Display doctors by speciality -----");
                        System.out.println("Enter a specialiaztion(ORTHO | PEDIA | PHYSICIAN | GYNAEC | NEURO | DERMA): ");
                        String spec = scanner.next();
                        SpecializationEnum specialiaztion = SpecializationEnum.valueOf(spec);
                        List<Doctor> doctorsBySpeciality = doctorService.findBySpeciality(specialiaztion.getSpeciality());
                        for (Doctor doctor : doctorsBySpeciality) {
                            System.out.println(doctor);
                        }
                    }
                    break;
                    case 7 :{
                        System.out.println("----- Display doctors with speciality and experience -----");
                        System.out.println("Enter a specialiaztion(ORTHO | PEDIA | PHYSICIAN | GYNAEC | NEURO | DERMA): ");
                        String spec = scanner.next();
                        SpecializationEnum specialiaztion = SpecializationEnum.valueOf(spec);
                        System.out.println("Enter doctor experience: ");
                        int experience = scanner.nextInt();
                        List<Doctor> doctorsBySpecAndExp = doctorService.findBySpecialityAndExp(specialiaztion.getSpeciality(), experience);
                        for (Doctor doctor : doctorsBySpecAndExp) {
                            System.out.println(doctor);
                        }
                    }
                    break;
                    case 8 :{
                        System.out.println("----- Display doctors with speciality and experience -----");
                        System.out.println("Enter a specialiaztion(ORTHO | PEDIA | PHYSICIAN | GYNAEC | NEURO | DERMA): ");
                        String spec = scanner.next();
                        SpecializationEnum specialiaztion = SpecializationEnum.valueOf(spec);
                        System.out.println("Enter doctor consultation fees: ");
                        double conFee = scanner.nextInt();
                        List<Doctor> doctorsBySpecAndFee = doctorService.findBySpecialityAndLessFees(specialiaztion.getSpeciality(), conFee);
                        for (Doctor doctor : doctorsBySpecAndFee) {
                            System.out.println(doctor);
                        }

                    }
                    break;
                    case 9 :{
                        System.out.println("----- Display doctors with speciality and experience -----");
                        System.out.println("Enter a specialiaztion(ORTHO | PEDIA | PHYSICIAN | GYNAEC | NEURO | DERMA): ");
                        String spec = scanner.next();
                        SpecializationEnum specialiaztion = SpecializationEnum.valueOf(spec);
                        System.out.println("Enter doctor ratings: ");
                        int rating = scanner.nextInt();
                        List<Doctor> doctorsBySpecAndExp  = doctorService.findBySpecialityAndRatings(specialiaztion.getSpeciality(), rating);
                        for (Doctor doctor : doctorsBySpecAndExp) {
                            System.out.println(doctor);
                        }
                    }
                    break;
                    case 10 :{
                        System.out.println("----- Display doctors with speciality and experience -----");
                        System.out.println("Enter a specialiaztion(ORTHO | PEDIA | PHYSICIAN | GYNAEC | NEURO | DERMA): ");
                        String spec = scanner.next();
                        SpecializationEnum specialiaztion = SpecializationEnum.valueOf(spec);
                        System.out.println("Enter doctor name: ");
                        String name = scanner.next();
                        List<Doctor> doctorsBySpecAndRating = doctorService.findBySpecialityAndNameContains(specialiaztion.getSpeciality(), name);
                        for (Doctor doctor : doctorsBySpecAndRating) {
                            System.out.println(doctor);
                        }
                    }
                    break;
                    case 11 :{
                        System.exit(0);
                    }
                    break;
                    default:
                        break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
