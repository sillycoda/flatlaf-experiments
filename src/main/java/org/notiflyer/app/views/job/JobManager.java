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
@name           JobManager.java
@description    displays job manager view
@version        0.0.1
@date           04/28/2024
@homepage       https://github.com/cleancoda/notiflyer-app
@log
                04/28/2024  v0.0.1  cleancoda - basic scaffolding added
*/
package org.notiflyer.app.views.job;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.notiflyer.app.config.ApplicationConfig;

public class JobManager extends JPanel {

    // declare class variables
    private JTabbedPane tabbedPane;

    // gui components
    private JTextField idField;
    private JTextField nameField;
    private JTextField subjectField;
    private JTextField recipientField;
    private JTextField ccField;
    private JTextField bccField;
    private JTextField headerField;
    private JTextField frequencyField;
    private JTextField runTimeField;
    private JCheckBox mondayCheckBox;
    private JCheckBox tuesdayCheckBox;
    private JCheckBox wednesdayCheckBox;
    private JCheckBox thursdayCheckBox;
    private JCheckBox fridayCheckBox;
    private JCheckBox saturdayCheckBox;
    private JCheckBox sundayCheckBox;
    private JTextArea descriptionArea;
    
    public JobManager() {
        initialize();        
    }
    
    // initialize job manager view
    private void initialize() {

        ApplicationConfig appConfig = new ApplicationConfig();

        this.setSize(appConfig.MAIN_WINDOW_WIDTH, appConfig.MAIN_WINDOW_HEIGHT);
        
        tabbedPane = new JTabbedPane();
    
        tabbedPane.setTabPlacement(JTabbedPane.LEFT);
        tabbedPane.setPreferredSize(new Dimension(appConfig.MAIN_WINDOW_WIDTH, appConfig.MAIN_WINDOW_HEIGHT));

        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.addTab("Jobs", test());
        tabbedPane.addTab("test", new JTable());
        add(tabbedPane);
    }

    private JPanel test() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 30, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        // Add idField
        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(idLabel, gbc);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(idField, gbc);
        
        // Add nameField
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(nameLabel, gbc);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(nameField, gbc);

        // Add descriptionArea
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel descriptionLabel = new JLabel("Description:");
        descriptionArea = new JTextArea();
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(descriptionLabel, gbc);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(descriptionArea, gbc);
        
        // Add subjectField
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel subjectLabel = new JLabel("Subject:");
        subjectField = new JTextField();
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(subjectLabel, gbc);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(subjectField, gbc);
        
        // Add recipientField
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel recipientLabel = new JLabel("Recipient:");
        recipientField = new JTextField();
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(recipientLabel, gbc);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(recipientField, gbc);
        
        // Add ccField
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel ccLabel = new JLabel("CC:");
        ccField = new JTextField();
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(ccLabel, gbc);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(ccField, gbc);
        
        // Add bccField
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel bccLabel = new JLabel("BCC:");
        bccField = new JTextField();
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(bccLabel, gbc);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(bccField, gbc);
        
        // Add headerField
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel headerLabel = new JLabel("Header:");
        headerField = new JTextField();
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(headerLabel, gbc);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(headerField, gbc);
        
        // Add frequencyField
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel frequencyLabel = new JLabel("Frequency:");
        frequencyField = new JTextField();
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(frequencyLabel, gbc);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(frequencyField, gbc);
        
        // Add runTimeField
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel runTimeLabel = new JLabel("Run Time:");
        runTimeField = new JTextField();
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(runTimeLabel, gbc);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(runTimeField, gbc);
        
        // Add checkboxes
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel daysLabel = new JLabel("Days:");
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(daysLabel, gbc);
        
        JPanel checkboxesPanel = new JPanel();
        checkboxesPanel.setLayout(new GridBagLayout());
        GridBagConstraints checkboxGbc = new GridBagConstraints();
        checkboxGbc.insets = new Insets(0, 5, 0, 5);
        
        mondayCheckBox = new JCheckBox("Monday");
        checkboxGbc.gridx = 0;
        checkboxGbc.gridy = 0;
        checkboxesPanel.add(mondayCheckBox, checkboxGbc);
        
        tuesdayCheckBox = new JCheckBox("Tuesday");
        checkboxGbc.gridx++;
        checkboxesPanel.add(tuesdayCheckBox, checkboxGbc);
        
        wednesdayCheckBox = new JCheckBox("Wednesday");
        checkboxGbc.gridx++;
        checkboxesPanel.add(wednesdayCheckBox, checkboxGbc);
        
        thursdayCheckBox = new JCheckBox("Thursday");
        checkboxGbc.gridx++;
        checkboxesPanel.add(thursdayCheckBox, checkboxGbc);
        
        fridayCheckBox = new JCheckBox("Friday");
        checkboxGbc.gridx++;
        checkboxesPanel.add(fridayCheckBox, checkboxGbc);
        
        saturdayCheckBox = new JCheckBox("Saturday");
        checkboxGbc.gridx++;
        checkboxesPanel.add(saturdayCheckBox, checkboxGbc);
        
        sundayCheckBox = new JCheckBox("Sunday");
        checkboxGbc.gridx++;
        checkboxesPanel.add(sundayCheckBox, checkboxGbc);
        
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(checkboxesPanel, gbc);
        
        return panel;
    }
}
