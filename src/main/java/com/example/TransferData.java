package com.example;

import java.sql.*;
import java.util.Properties;

public class TransferData {

    public static void main(String[] args) {
        try {
            // Oracle DB details
            String oracleUrl = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
            String oracleUser = "SYSTEM";
            String oraclePass = "manik";

            // Connect to Oracle
            Connection oracleConn = DriverManager.getConnection(oracleUrl, oracleUser, oraclePass);
            Statement oracleStmt = oracleConn.createStatement();
            ResultSet rs = oracleStmt.executeQuery("SELECT * FROM EMPLOYEES");


            // Snowflake details
            String sfUrl = "jdbc:snowflake://czifagn-dr52412.snowflakecomputing.com";
            Properties props = new Properties();
            props.put("user", "ruby");
            props.put("password", "Manicbatcha@2003");
            props.put("warehouse", "ex1");
            props.put("db", "ex1_db");
            props.put("schema", "ex1_sh");

            // Connect to Snowflake
            Connection sfConn = DriverManager.getConnection(sfUrl, props);
            PreparedStatement sfInsert = sfConn.prepareStatement(
                    "INSERT INTO EMPLOYEES (ID, NAME, DEPARTMENT, HIRE_DATE, SALARY) VALUES (?, ?, ?, ?, ?)"
            );

            // Loop through Oracle results and insert into Snowflake
            while (rs.next()) {
                sfInsert.setInt(1, rs.getInt("ID"));
                sfInsert.setString(2, rs.getString("NAME"));
                sfInsert.setString(3, rs.getString("DEPARTMENT"));
                sfInsert.setDate(4, rs.getDate("HIRE_DATE"));
                sfInsert.setDouble(5, rs.getDouble("SALARY"));
                sfInsert.executeUpdate();
            }

            // Cleanup
            sfInsert.close();
            sfConn.close();
            rs.close();
            oracleStmt.close();
            oracleConn.close();

            System.out.println("✅ Data transferred successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Error during transfer.");
        }
    }

}
