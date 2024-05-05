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
@name           Application.java
@description    start notiflyer application
@version        0.0.1
@date           05/05/2024
@homepage       https://github.com/cleancoda/notiflyer-app
@log
                05/05/2024  v0.0.1  cleancoda - basic scaffolding added
*/

// declare package
package org.notiflyer.app;

import javax.swing.JFrame;

import org.notiflyer.app.config.ApplicationConfig;
import org.notiflyer.app.controller.FormsManager;
import org.notiflyer.app.views.auth.Login;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;

// import dependencies

// declare class
public class Application extends JFrame {

    // declare variables
    private ApplicationConfig config;

    // declare main method
    public static void main(String[] args) {
        // create new instance of application
        Application app = new Application();
        // initialize application
        app.initApplication();
    }

    public Application() {
        // initialize application configuration
        config = new ApplicationConfig();
        // check if app database is configured
        config.ConfigureAppDB();
    }

    private void initApplication() {

        // init flatlaf
        FlatMacDarkLaf.setup();

        
        // set application title
        this.setTitle(config.APP_NAME);

        // set application size
        this.setSize(config.MAIN_WINDOW_WIDTH, config.MAIN_WINDOW_HEIGHT);
        
        /*
         * flow:
         * 1. user login form - independent jpanel
         * 2. registration form - independent jpanel
         * 3. main application window - navigation bar + jpanel for each form as below
         * 
         * navigation bar:
         *  1. dashboard
         *  2. configure target database
         *  3. job manager
         *      3.1 job grid list - has button to view job info header
         *      3.2 job info header (add/edit/delete jobs) - has buttons to view job grid list, job query grid
         *      3.3 job query grid (add/edit/delete queries from job) - has buttons to view job info header, job grid list
         *      3.4 job query grid parameters (add/edit/delete parameters for query) - has buttons to go BACK to job query grid
         *  4. query manager
         *      4.1 query grid list - has button to view query info header
         *      4.2 query info header (add/edit/delete queries) - has buttons to view query grid list, query query grid
         *      4.3 query parameter grid (add/edit/delete parameters from query) - has buttons to view query info header, query grid list
         */

        // create new instance of window from FormsManager
        FormsManager.getInstance().initApplication(this);

        // show login form
        FormsManager.getInstance().showIndependentPanel(new Login());

        
    }
}