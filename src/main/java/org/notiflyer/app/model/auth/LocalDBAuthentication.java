/*
Copyright 2024 cleancoda

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

@author         cleancoda
@name           LocalDBAuthentication.java
@description    handles register/login events for local database
@version        0.0.1
@date           04/24/2024
@homepage       https://github.com/cleancoda/notiflyer-app
@log
                04/24/2024  v0.0.1  cleancoda - basic scaffolding added
*/
package org.notiflyer.app.model.auth;

// import dependencies
// application config library
import org.notiflyer.app.config.ApplicationConfig;
// sql libraries
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * LocalDBAuthentication class to handle register/login events for local database
 */
public class LocalDBAuthentication {
    // app config object
    ApplicationConfig appConfig = new ApplicationConfig();
    // local database object
    Connection connection;

    // constructor
    public LocalDBAuthentication() {
        try {
            // create a connection to the SQLite database
            connection = DriverManager.getConnection("jdbc:sqlite:" + appConfig.APP_DB_FILE_PATH + appConfig.APP_DB_FILE_NAME);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // register user
    public String registerUser(String firstname, String lastname, String email, String password) {
        try {

            // Check if the user already exists in the users table
            String checkQuery = "SELECT COUNT(*) FROM users WHERE email = ?";
            PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
            checkStatement.setString(1, email);
            ResultSet resultSet = checkStatement.executeQuery();
            int count = resultSet.getInt(1);
            resultSet.close();
            checkStatement.close();

            if (count > 0) {
                // User already exists
                // System.out.println("User already exists");
                return "User already exists";
            }

            // Create a prepared statement with the SQL query
            String query = "INSERT INTO users (firstname, lastname, email, password) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            // Set the values for the parameters in the query
            statement.setString(1, firstname);
            statement.setString(2, lastname);
            statement.setString(3, email);
            statement.setString(4, password);

            // Execute the query
            statement.executeUpdate();

            // Close the statement
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "User registered successfully";
    }

    // login user
    public boolean loginUser(String username, String password) {
        try {
            // Create a prepared statement with the SQL query
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Set the values for the parameters in the query
            statement.setString(1, username);
            statement.setString(2, password);

            // Execute the query
            boolean result = statement.executeQuery().next();

            // Close the statement
            statement.close();

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
