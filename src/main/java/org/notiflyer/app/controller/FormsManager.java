// source credits: https://github.com/DJ-Raven/social-media-ui/blob/main/src/main/java/raven/manager/FormsManager.java
package org.notiflyer.app.controller;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JComponent;

import org.notiflyer.app.Application;
import org.notiflyer.app.config.ApplicationConfig;
import org.notiflyer.app.views.navigation.NavBar;

import com.formdev.flatlaf.extras.FlatAnimatedLafChange;

public class FormsManager {
    private ApplicationConfig config;
    private Application application;
    private static FormsManager instance;

    // singleton pattern to access instance of FormsManager
    public static FormsManager getInstance() {
        if (instance == null) {
            instance = new FormsManager();
        }
        return instance;
    }

    private FormsManager() {
        config = new ApplicationConfig();
    }

    // initialize new application instance
    public void initApplication(Application application) {
        this.application = application;
    }

    /**
     * show independent panel - loads a jpanel object into it's own borderfree window
     * @param panel
     */
    public void showIndependentPanel(JComponent panel) {
        try {
            EventQueue.invokeLater(() -> {
                FlatAnimatedLafChange.showSnapshot();
                application.getContentPane().removeAll();
                application.setContentPane(panel);
                application.setUndecorated(true);
                application.setLocationRelativeTo(null);
                application.revalidate();
                application.repaint();
                FlatAnimatedLafChange.hideSnapshotWithAnimation();
                application.setVisible(true);
            });
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void showPanelWithNavBar(JComponent panel) {
        try {
            EventQueue.invokeLater(() -> {
                FlatAnimatedLafChange.showSnapshot();
                // set frame size
                application.setSize(config.MAIN_WINDOW_WIDTH, config.MAIN_WINDOW_HEIGHT);

                // set frame layout
                application.setLayout(new BorderLayout());
                application.getContentPane().removeAll();
                application.add(new NavBar(),BorderLayout.WEST);
                application.add(panel, BorderLayout.CENTER);
                FlatAnimatedLafChange.hideSnapshotWithAnimation();
                application.setVisible(true);
            });
            
        } catch (Exception e) {
        }
    }


    /**
     * show form - loads a jpanel object into the main application window. can set title
     * @param panel
     * @param title
     */
    public void showForm(JComponent panel, String title) {
        EventQueue.invokeLater(() -> {
            FlatAnimatedLafChange.showSnapshot();
            // application.setContentPane(form);
            application.getContentPane().removeAll();
            application.setLayout(new BorderLayout());
            application.add(panel, BorderLayout.CENTER);
            application.setTitle(title);
            application.revalidate();
            application.repaint();
            FlatAnimatedLafChange.hideSnapshotWithAnimation();
            application.dispose();
            application.setUndecorated(false);
            application.setVisible(true);
        });
    }

    // switch between forms
    public void showForm(JComponent form) {
        EventQueue.invokeLater(() -> {
            FlatAnimatedLafChange.showSnapshot();

            application.getContentPane().removeAll();
            application.setContentPane(form);
            // application.addNavBar();
            application.add(form, BorderLayout.CENTER);
            application.revalidate();
            application.repaint();
            FlatAnimatedLafChange.hideSnapshotWithAnimation();
        });
    }

    public void showForm(JComponent form, boolean keepNavBar) {
        EventQueue.invokeLater(() -> {
            FlatAnimatedLafChange.showSnapshot();

            Component[] components = application.getContentPane().getComponents();
            for (Component component : components) {
                if (component.toString().contains("NavBar") && keepNavBar) {
                    continue;
                }
                else {
                    application.remove(component);
                }
            }
            // application.getContentPane().removeAll();
            // application.setContentPane(form);
            application.add(form, BorderLayout.CENTER);
            application.revalidate();
            application.repaint();
            FlatAnimatedLafChange.hideSnapshotWithAnimation();
        });
    }
}