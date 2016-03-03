package com.InterviewQuestions;

import java.sql.*;
import java.util.Properties;

/**
 * Created by Laks on 1/21/16.
 *
 * Question asked for Sahitya in Oracle interview 2015
 *
 */
public class JDBCConnection {

    public static void main(String[] args) {

        //URL of Oracle database server
        String url = "jdbc:oracle:thin@localhost:8001:DEVINSTANCE";

        //properties for creating connection to Oracle database
        Properties prop = new Properties();
        prop.setProperty("username","scott");
        prop.setProperty("password","tiger");

        try {

            //creating connection to Oracle database using JDBC
            Connection conn = DriverManager.getConnection(url,prop);
            String sql = "select sysdate as current_day from dual";

            //creating PreparedStatement object to execute query
            PreparedStatement prep = conn.prepareStatement(sql);
           // Statement pre = conn.createStatement();
            //pre.execute(sql);
            ResultSet rs = prep.executeQuery();


            while (rs.next()) {
                System.out.println("Current date from Oracle : " + rs.getString("current_day"));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
}
