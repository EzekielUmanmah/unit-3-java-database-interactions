package com.javaunit3.springmvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Properties;

public class BitioExample {
    public static void main(String[] args) {
        Connection c = null;
        String bitApiKey = "v2_3yUfg_HKZv2rTCAZ7z7DutL5eCVzd";
        String bitDB = "EzekielUmanmah.myDB";
        String bitUser = "EzekielUmanmah";
        String bitHost = "db.bit.io";
        String bitPort = "5432"; // We keep this as a string here as we are concact'ing it into the connection string
        Properties props = new Properties();
        props.setProperty("sslmode","require"); // if verify-full fails, use 'require'
        props.setProperty("user",bitUser);
        props.setProperty("password",bitApiKey);
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://" + bitHost + ":" + bitPort + "/" + bitDB, bitUser, bitApiKey);
//            c = DriverManager
//                    .getConnection("jdbc:postgresql://" + bitHost + ":" + bitPort + "/" + bitDB, props);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users limit 10;");

            while (rs.next()) {
                ResultSetMetaData rsmd = rs.getMetaData();
                // The ResultSet .getXXX() methods expect the column index to start at 1.
                // No idea why.
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    System.out.print(rsmd.getColumnName(i) + "="+ rs.getString(i) + " ");
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
}
