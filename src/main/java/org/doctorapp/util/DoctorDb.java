package org.doctorapp.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DoctorDb {
    static Connection connection;

    public static Connection openConnection() {
        String url = "jdbc:mysql://localhost:3306/newvoya";
        String username = "root";
        String password = "root";
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to db");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
