// source credits: https://github.com/DJ-Raven/social-media-ui/blob/main/src/main/java/raven/manager/FormsManager.java
package org.notiflyer.app.controller;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JComponent;

import org.notiflyer.app.Application;

import com.formdev.flatlaf.extras.FlatAnimatedLafChange;

public class FormsManager {
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
        
    }

    // initialize new application instance
    public void initApplication(Application application) {
        this.application = application;
    }

    public void showForm(JComponent form, String title) {
        EventQueue.invokeLater(() -> {
            FlatAnimatedLafChange.showSnapshot();
            // application.setContentPane(form);
            application.add(form, BorderLayout.CENTER);
            application.setTitle(title);
            application.revalidate();
            application.repaint();
            FlatAnimatedLafChange.hideSnapshotWithAnimation();
            application.dispose();
            application.setUndecorated(false);
            application.setVisible(true);
        });
    }

    public void showIndependentPanel(JComponent form) {
        try {
            EventQueue.invokeLater(() -> {
                FlatAnimatedLafChange.showSnapshot();
                application.getContentPane().removeAll();
                application.setContentPane(form);
                application.revalidate();
                application.repaint();
                FlatAnimatedLafChange.hideSnapshotWithAnimation();
                application.setVisible(true);
            });
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
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