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
@date           04/24/2024
@homepage       https://github.com/cleancoda/notiflyer-app
@log
                12/31/2023  v0.0.1  cleancoda - basic scaffolding added
*/
package org.notiflyer.app.config;

import org.notiflyer.app.model.setup.SetupLocalDatabase;

// declare class
/*
 * ApplicationConfig class to configure notiflyer application and hold static configuration values
 * @version        0.0.1
 */
public class ApplicationConfig {
    
        // declare constants
        // app name
        public final String APP_NAME = "Notiflyer";
        // app version
        public final String APP_VERSION = "0.0.1";
        // app homepage
        public final String APP_HOMEPAGE = "https://notiflyer.org";
        // app database file path
        public final String APP_DB_FILE_PATH = "assets/db/";
        // app database file name
        public final String APP_DB_FILE_NAME = "notiflyer_db.db";

        // ## DATABASE
        // sql server host
        public final String DATABASE_HOST = "192.168.50.150";
        // sql server port
        public final int DATABASE_PORT = 2342;
        // sql server database name
        public final String DATABASE_NAME = "WideWorldImporters";

        // sql server database url
        public final String DATABASE_URL = "jdbc:sqlserver://" + DATABASE_HOST + ":" + DATABASE_PORT + ";databaseName=" + DATABASE_NAME + ";";
        // database driver
        public final String DATABASE_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        // database user
        public final String DATABASE_USER = "SA";
        // database password
        public final String DATABASE_PASSWORD = "";
    

        // gui components
        // colors
        // primary color
        public final String PRIMARY_BG_COLOR = "#b0ace0";
        // secondary color
        public final String SECONDARY_BG_COLOR = "#35354f";
        // text color
        public final String TEXT_COLOR = "#ffffff";
        // button color
        public final String BUTTON_COLOR = "#ff6f61";
        // button hover color
        public final String BUTTON_HOVER_COLOR = "#ff8c7f";
        // button text color
        public final String BUTTON_TEXT_COLOR = "#ffffff";
        // button text hover color
        public final String BUTTON_TEXT_HOVER_COLOR = "#ffffff";
        // input field color
        public final String INPUT_FIELD_COLOR = "#ffffff";
        // input field text color
        public final String INPUT_FIELD_TEXT_COLOR = "#000000";
        // input field border color
        public final String INPUT_FIELD_BORDER_COLOR = "#ffffff";
        // input field border hover color
        public final String INPUT_FIELD_BORDER_HOVER_COLOR = "#ff6f61";

        // ## MAIN WINDOW FRAME
        // title
        public final String MAIN_WINDOW_TITLE = "Notiflyer";
        // width
        public final int MAIN_WINDOW_WIDTH = 900;
        // height
        public final int MAIN_WINDOW_HEIGHT = 900;
        
        // ## LOGIN FORM JPANEL
        // background image
        public final String LOGIN_FORM_BACKGROUND_IMAGE = "assets/img/login_form.png";
        // background image height
        public final int LOGIN_FORM_BACKGROUND_IMAGE_HEIGHT = 900;
        // background image width
        public final int LOGIN_FORM_BACKGROUND_IMAGE_WIDTH = 900;
        // height
        public final int LOGIN_FORM_HEIGHT = 900;
        // width
        public final int LOGIN_FORM_WIDTH = 900;

        // ## REGISTER FORM JPANEL
        // background image
        public final String REGISTER_FORM_BACKGROUND_IMAGE = "assets/img/register_form.png";
        // background image height
        public final int REGISTER_FORM_BACKGROUND_IMAGE_HEIGHT = 900;
        // background image width
        public final int REGISTER_FORM_BACKGROUND_IMAGE_WIDTH = 900;
        // height
        public final int REGISTER_FORM_HEIGHT = 900;
        // width
        public final int REGISTER_FORM_WIDTH = 900;
        

        // local database
        SetupLocalDatabase setupLocalDatabase = new SetupLocalDatabase();

        // check if app database is configured and create if not
        public void ConfigureAppDB() {
            if(setupLocalDatabase.isAppDatabaseConfigured(APP_DB_FILE_PATH, APP_DB_FILE_NAME)) {
            } else {
                setupLocalDatabase.createAppDatabase(APP_DB_FILE_PATH, APP_DB_FILE_NAME);
            }
        }

}
