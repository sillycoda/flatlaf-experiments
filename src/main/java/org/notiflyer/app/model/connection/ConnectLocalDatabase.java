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
@date           05/01/2024
@homepage       https://github.com/cleancoda/notiflyer-app
@log
                05/01/2024  v0.0.1  cleancoda - basic scaffolding added
*/
package org.notiflyer.app.model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.SQLDataException;

import org.notiflyer.app.config.ApplicationConfig;

/**
 * ConnectLocalDatabase class to handle connection to local database
 */
public class ConnectLocalDatabase {

    // local database object
    Connection connection;
    // app config object
    ApplicationConfig appConfig = new ApplicationConfig();
    
    // constructor
    public ConnectLocalDatabase() {
        
    }

    // create connection
    public void createConnection() {
        // create a connection to the SQLite database
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + appConfig.APP_DB_FILE_PATH + appConfig.APP_DB_FILE_NAME);
            } catch (SQLDataException e) {
                e.printStackTrace();
            } catch (SQLTimeoutException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    
    // close connection
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLDataException e) {
            e.printStackTrace();
        } catch (SQLTimeoutException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
