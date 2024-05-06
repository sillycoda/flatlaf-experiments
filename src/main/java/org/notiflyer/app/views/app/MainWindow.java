package org.notiflyer.app.views.app;

import javax.swing.JPanel;

import org.notiflyer.app.controller.FormsManager;
import org.notiflyer.app.views.job.JobManagerGrid;

/**
 * creates the home page of the application post successful login
 */
public class MainWindow extends JPanel {

    /**
     * MainWindow constructor
     */
    public MainWindow() {
        initialize();
    }

    /**
     * Initialize main window view
     */
    private void initialize() {

        FormsManager.getInstance().showPanelWithNavBar(new JobManagerGrid());

    }
    
}
