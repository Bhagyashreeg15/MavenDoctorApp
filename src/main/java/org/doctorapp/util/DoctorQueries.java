package org.doctorapp.util;

public class DoctorQueries {
    public static final String INSERTQUERY = "insert into doctor(doctor_name,speciality,experience,fees,ratings) values(?,?,?,?,?)";

    public static final String UPDATEQUERY = "UPDATE DOCTOR SET fees=? WHERE doctor_id=?";

    public static final String DELETEQUERY = "DELETE FROM DOCTOR WHERE doctor_id=?";

    public static final String FINDBYID = "SELECT * FROM DOCTOR WHERE doctor_id = ?";

    public static final String FINDALLQUERY = "SELECT * FROM DOCTOR";

    public static final String FINDBYSPECIALITY = "SELECT * FROM DOCTOR WHERE speciality = ?";

    public static final String FINDBYSPECIALITYANDEXP = "SELECT * FROM DOCTOR WHERE speciality = ? AND experience >= ?";

    public static final String FINDBYSPECIALITYANDFEES = "SELECT * FROM DOCTOR WHERE speciality = ? AND fees <= ?";

    public static final String FINDBYSPECIALITYANDRATINGS = "SELECT * FROM DOCTOR WHERE speciality = ? AND ratings>?";

    public static final String FINDBYSPECIALITYANDNAME = "SELECT * FROM DOCTOR WHERE speciality = ? AND doctor_name like ?";

}
