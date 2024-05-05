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
@name           SetupLocalDatabase.java
@description    model class to setup and configure local app database
@version        0.0.1
@date           04/24/2024
@homepage       https://github.com/cleancoda/notiflyer-app
@log
                12/31/2023  v0.0.1  cleancoda - basic scaffolding added
*/

// declare package
package org.notiflyer.app.model.setup;

// import dependencies
// file & file path check libraries
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
// sqlite libraries
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
// io exception library
import java.io.IOException;

// declare class
/**
 * SetupLocalDatabase class to configure and setup local database
 * @version        0.0.1
 */
public class SetupLocalDatabase {

    /**
     * Check if the app database is configured
     * @return boolean
     */
    public boolean isAppDatabaseConfigured(String dbFilePath, String dbFileName) {
        // check if sqlite database file exists in assets/db directory

        // return flag
        boolean isConfigured = false;
        
        // check if sqlite database file exists in assets/db directory
        if (Files.exists(Paths.get(dbFilePath+dbFileName))) {
            isConfigured = true;
        }

        return isConfigured;
    }

    public boolean createAppDatabase(String dbFilePath, String dbFileName) {

        try {
            Path pathToFile = Paths.get(dbFilePath+dbFileName);
            // create directories if they do not exist
            if (Files.notExists(pathToFile.getParent())) {
                Files.createDirectories(pathToFile.getParent());
            }
            // create the file if it does not exist
            if (Files.notExists(pathToFile)) {
                Files.createFile(pathToFile);
            }
            return true;
        } catch (IOException e) {
            System.err.println("Failed to create database file: " + e.getMessage());
            return false;
        }
    }
    
    // create tables
    public boolean createTables(String dbFilePath, String dbFileName) {
        
        // user table
        String createUserTableQuery = "create table if not exists users (id integer primary key, firstname text, lastname text, email text, password text, created_at text, updated_at text);";
        // log table
        String createLogTableQuery = "create table if not exists logs (id integer primary key, user_id integer, log text, created_at text);";

        // create tables
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + dbFilePath + dbFileName);
            Statement statement = connection.createStatement()) {
            // create user table
            statement.execute(createUserTableQuery);
            // create log table
            statement.execute(createLogTableQuery);
            return true;
        } catch (SQLException e) {
            System.err.println("Failed to create table: " + e.getMessage());
            return false;
        }
    }

}
