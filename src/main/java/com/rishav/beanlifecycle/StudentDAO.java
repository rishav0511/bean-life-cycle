package com.rishav.beanlifecycle;

import java.sql.*;

public class StudentDAO {
    private String driver;
    private String url;
    private String username;
    private String password;

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void selectAllRows() throws ClassNotFoundException, SQLException {
        //load Driver
        Class.forName(driver);

        //get a connection
        Connection con = DriverManager.getConnection(url,username,password);

        //execute query
        Statement statement = con.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM ESNew.HostelStudentInfo");

        while(resultSet.next())
        {
            int studentID = resultSet.getInt(1);
            String studentName = resultSet.getString(2);
            double hostelFees = resultSet.getDouble(3);
            String foodType = resultSet.getString(4);
            System.out.println(studentID+" "+studentName+" "+hostelFees+" "+foodType);
        }
        con.close();
    }

    public void deleteStudentRecord(int studentId) throws ClassNotFoundException, SQLException {
        //load Driver
        Class.forName(driver);

        //get a connection
        Connection con = DriverManager.getConnection(url,username,password);

        //execute query
        Statement statement = con.createStatement();

        statement.executeUpdate("delete from ESNew.HostelStudentInfo where Student_id = "+studentId);
        System.out.println("Record deleted with id: " + studentId);
        con.close();
    }
}
