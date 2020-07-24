package com.guilogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQL {

    private Connection connection;
    private Statement statement;

    public String connect(String email, String password) {
        String result = "Access denied, try again.";
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:54328/students", "postgres", "applepie");
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM login");
            while (resultSet.next()) {
                String email1 = resultSet.getString(1);
                String password1 = resultSet.getString(2);

                for (int i=0; i<1000;i++) {
                    if (email.equals(email1) && password.equals(password1)) {
                        result = "Access granted!";
                        break;
                    }}}

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

