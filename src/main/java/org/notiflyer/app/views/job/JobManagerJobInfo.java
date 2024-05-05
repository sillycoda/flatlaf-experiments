package org.notiflyer.app.views.job;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

// app config
import org.notiflyer.app.config.ApplicationConfig;

public class JobManagerJobInfo extends JPanel {

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

    private ApplicationConfig appConfig;

    public JobManagerJobInfo() {
        initialize();
    }

    private void initialize() {

        appConfig = new ApplicationConfig();

        // set layout manager
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Add fields and button to panel
        constraints.gridx = -1;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 0, 0, 0);
        JLabel idLabel = new JLabel("ID:");
        this.add(idLabel);
        constraints.insets = new Insets(10, 100, 0, 0);
        idField = new JTextField(30);
        this.add(idField, constraints);

        constraints.gridy = 1;
        constraints.insets = new Insets(10, 0, 0, 0);
        JLabel nameLabel = new JLabel("Name:");
        this.add(nameLabel, constraints);
        constraints.insets = new Insets(10, 100, 0, 0);
        nameField = new JTextField(30);
        this.add(nameField, constraints);

        constraints.gridy = 2;
        constraints.insets = new Insets(10, 0, 0, 0);
        JLabel subjectLabel = new JLabel("Email Subject:");
        this.add(subjectLabel, constraints);
        constraints.insets = new Insets(10, 100, 0, 0);
        subjectField = new JTextField(30);
        this.add(subjectField, constraints);

        constraints.gridy = 3;
        constraints.insets = new Insets(10, 0, 0, 0);
        JLabel ccLabel = new JLabel("Email CC:");
        this.add(ccLabel, constraints);
        constraints.insets = new Insets(10, 100, 0, 0);
        ccField = new JTextField(30);
        this.add(ccField, constraints);

        constraints.gridy = 4;
        constraints.insets = new Insets(10, 0, 0, 0);
        JLabel bccLabel = new JLabel("Email BCC:");
        this.add(bccLabel, constraints);
        constraints.insets = new Insets(10, 100, 0, 0);
        bccField = new JTextField(30);
        this.add(bccField, constraints);

        constraints.gridy = 5;
        constraints.insets = new Insets(10, 0, 0, 0);
        JLabel headerLabel = new JLabel("Email Body Header:");
        this.add(headerLabel, constraints);
        constraints.insets = new Insets(10, 100, 0, 0);
        headerField = new JTextField(30);
        this.add(headerField, constraints);

        constraints.gridy = 6;
        constraints.insets = new Insets(10, 0, 0, 0);
        JLabel frequencyLabel = new JLabel("Frequency:");
        this.add(frequencyLabel, constraints);
        constraints.insets = new Insets(10, 100, 0, 0);
        frequencyField = new JTextField(30);
        this.add(frequencyField, constraints);

        constraints.gridy = 7;
        constraints.insets = new Insets(10, 0, 0, 0);
        JLabel runTimeLabel = new JLabel("Run Time:");
        this.add(runTimeLabel, constraints);
        constraints.insets = new Insets(10, 100, 0, 0);
        runTimeField = new JTextField(30);
        this.add(runTimeField, constraints);

        constraints.gridy = 8;
        constraints.insets = new Insets(10, 0, 0, 0);
        JLabel mondayLabel = new JLabel("Run on Monday:");
        this.add(mondayLabel, constraints);
        constraints.insets = new Insets(10, 100, 0, 0);
        mondayCheckBox = new JCheckBox();
        this.add(mondayCheckBox, constraints);

        constraints.gridy = 9;
        constraints.insets = new Insets(10, 0, 0, 0);
        JLabel tuesdayLabel = new JLabel("Run on Tuesday:");
        this.add(tuesdayLabel, constraints);
        constraints.insets = new Insets(10, 100, 0, 0);
        tuesdayCheckBox = new JCheckBox();
        this.add(tuesdayCheckBox, constraints);

        constraints.gridy = 10;
        constraints.insets = new Insets(10, 0, 0, 0);
        JLabel wednesdayLabel = new JLabel("Run on Wednesday:");
        this.add(wednesdayLabel, constraints);
        constraints.insets = new Insets(10, 100, 0, 0);
        wednesdayCheckBox = new JCheckBox();
        this.add(wednesdayCheckBox, constraints);

        constraints.gridy = 11;
        constraints.insets = new Insets(10, 0, 0, 0);
        JLabel thursdayLabel = new JLabel("Run on Thursday:");
        this.add(thursdayLabel, constraints);
        constraints.insets = new Insets(10, 100, 0, 0);
        thursdayCheckBox = new JCheckBox();
        this.add(thursdayCheckBox, constraints);

        constraints.gridy = 12;
        constraints.insets = new Insets(10, 0, 0, 0);
        JLabel fridayLabel = new JLabel("Run on Friday:");
        this.add(fridayLabel, constraints);
        constraints.insets = new Insets(10, 100, 0, 0);
        fridayCheckBox = new JCheckBox();
        this.add(fridayCheckBox, constraints);

        constraints.gridy = 13;
        constraints.insets = new Insets(10, 0, 0, 0);
        JLabel saturdayLabel = new JLabel("Run on Saturday:");
        this.add(saturdayLabel, constraints);
        constraints.insets = new Insets(10, 100, 0, 0);
        saturdayCheckBox = new JCheckBox();
        this.add(saturdayCheckBox, constraints);

        constraints.gridy = 14;
        constraints.insets = new Insets(10, 0, 0, 0);
        JLabel sundayLabel = new JLabel("Run on Sunday:");
        this.add(sundayLabel, constraints);
        constraints.insets = new Insets(10, 100, 0, 0);
        sundayCheckBox = new JCheckBox();
        this.add(sundayCheckBox, constraints);

        constraints.gridy = 15;
        constraints.insets = new Insets(10, 0, 0, 0);
        JLabel descriptionLabel = new JLabel("Description:");
        this.add(descriptionLabel, constraints);
        constraints.insets = new Insets(10, 100, 0, 0);
        descriptionArea = new JTextArea();
        this.add(descriptionArea, constraints);
        
        this.setPreferredSize(new Dimension(appConfig.MAIN_WINDOW_WIDTH, appConfig.MAIN_WINDOW_HEIGHT));

        // JLabel subjectLabel = new JLabel("Email Subject:");
        // subjectField = new JTextField(30);
        // add(subjectLabel);
        // add(subjectField);

        // JLabel recipientLabel = new JLabel("Email Recipient:");
        // recipientField = new JTextField(30);
        // add(recipientLabel);
        // add(recipientField);

        // JLabel ccLabel = new JLabel("Email CC:");
        // ccField = new JTextField(30);
        // add(ccLabel);
        // add(ccField);

        // JLabel bccLabel = new JLabel("Email BCC:");
        // bccField = new JTextField(30);
        // add(bccLabel);
        // add(bccField);

        // JLabel headerLabel = new JLabel("Email Body Header:");
        // headerField = new JTextField(30);
        // add(headerLabel);
        // add(headerField);

        // JLabel frequencyLabel = new JLabel("Frequency:");
        // frequencyField = new JTextField(30);
        // add(frequencyLabel);
        // add(frequencyField);

        // JLabel runTimeLabel = new JLabel("Run Time:");
        // runTimeField = new JTextField(30);
        // add(runTimeLabel);
        // add(runTimeField);

        // JLabel mondayLabel = new JLabel("Run on Monday:");
        // mondayCheckBox = new JCheckBox();
        // add(mondayLabel);
        // add(mondayCheckBox);

        // JLabel tuesdayLabel = new JLabel("Run on Tuesday:");
        // tuesdayCheckBox = new JCheckBox();
        // add(tuesdayLabel);
        // add(tuesdayCheckBox);

        // JLabel wednesdayLabel = new JLabel("Run on Wednesday:");
        // wednesdayCheckBox = new JCheckBox();
        // add(wednesdayLabel);
        // add(wednesdayCheckBox);

        // JLabel thursdayLabel = new JLabel("Run on Thursday:");
        // thursdayCheckBox = new JCheckBox();
        // add(thursdayLabel);
        // add(thursdayCheckBox);

        // JLabel fridayLabel = new JLabel("Run on Friday:");
        // fridayCheckBox = new JCheckBox();
        // add(fridayLabel);
        // add(fridayCheckBox);

        // JLabel saturdayLabel = new JLabel("Run on Saturday:");
        // saturdayCheckBox = new JCheckBox();
        // add(saturdayLabel);
        // add(saturdayCheckBox);

        // JLabel sundayLabel = new JLabel("Run on Sunday:");
        // sundayCheckBox = new JCheckBox();
        // add(sundayLabel);
        // add(sundayCheckBox);

        // JLabel descriptionLabel = new JLabel("Description:");
        // descriptionArea = new JTextArea();
        // add(descriptionLabel);
        // add(descriptionArea);

    }
}
        