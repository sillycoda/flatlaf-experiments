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
@name           Register.java
@description    register user form view
@version        0.0.1
@date           04/28/2024
@homepage       https://github.com/cleancoda/notiflyer-app
@log
                04/28/2024  v0.0.1  cleancoda - basic scaffolding added
*/
package org.notiflyer.app.views.auth;

import javax.imageio.ImageIO;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.notiflyer.app.config.ApplicationConfig;
import org.notiflyer.app.controller.FormsManager;

import org.notiflyer.app.model.auth.LocalDBAuthentication;

public class Register extends JPanel {
     
     public Register() {
          initialize();
     }

     // declare fields
     private Image backgroundImage;
     private JTextField firstNameField;
     private JTextField lastNameField;
     private JTextField emailField;
     private JPasswordField passwordField;
     private JPasswordField confirmPasswordField;
     private JButton loginButton;
     private JButton registerButton;

     // declare app config
     ApplicationConfig appConfig = new ApplicationConfig();

     // declare local db authentication
     LocalDBAuthentication dbAuth = new LocalDBAuthentication();

     private void initialize() {
          // set layout manager
          setLayout(new GridBagLayout());
          GridBagConstraints constraints = new GridBagConstraints();

          // Create fields and button
          firstNameField = new JTextField(20);
          lastNameField = new JTextField(20);
          emailField = new JTextField(20);
          passwordField = new JPasswordField(20);
          confirmPasswordField = new JPasswordField(20);

          loginButton = new JButton("Return to login");
          registerButton = new JButton("Register");

          loginButton.addActionListener(e -> {
               FormsManager.getInstance().showForm(new Login());
          });

          registerButton.addActionListener(e -> {
               registerUser();
          });

          // Add fields and button to panel
          constraints.gridx = 0;
          constraints.gridy = 0;
          constraints.insets = new Insets(120, 0, 0, 0);
          JLabel firstNameLabel = new JLabel("First Name:");
          firstNameLabel.setFont(firstNameLabel.getFont().deriveFont(Font.BOLD));
          this.add(firstNameLabel, constraints);

          constraints.gridx = 1;
          this.add(firstNameField, constraints);

          constraints.gridx = 0;
          constraints.gridy = 1;
          constraints.insets = new Insets(20, 0, 0, 0);
          JLabel lastNameLabel = new JLabel("Last Name:");
          lastNameLabel.setFont(lastNameLabel.getFont().deriveFont(Font.BOLD));
          this.add(lastNameLabel, constraints);

          constraints.gridx = 1;
          this.add(lastNameField, constraints);

          constraints.gridx = 0;
          constraints.gridy = 2;
          constraints.insets = new Insets(20, 0, 0, 0);
          JLabel emailLabel = new JLabel("Email Address:");
          emailLabel.setFont(lastNameLabel.getFont().deriveFont(Font.BOLD));
          this.add(emailLabel, constraints);

          constraints.gridx = 1;
          this.add(emailField, constraints);

          constraints.gridx = 0;
          constraints.gridy = 3;
          constraints.insets = new Insets(20, 0, 0, 0);
          JLabel passwordLabel = new JLabel("Password:");
          passwordLabel.setFont(passwordLabel.getFont().deriveFont(Font.BOLD));
          this.add(passwordLabel, constraints);

          constraints.gridx = 1;
          this.add(passwordField, constraints);

          constraints.gridx = 0;
          constraints.gridy = 4;
          constraints.insets = new Insets(20, 0, 0, 0);
          JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
          confirmPasswordLabel.setFont(confirmPasswordLabel.getFont().deriveFont(Font.BOLD));
          this.add(confirmPasswordLabel, constraints);

          constraints.gridx = 1;
          this.add(confirmPasswordField, constraints);

          constraints.gridx = 0;
          constraints.gridy = 5;
          constraints.gridwidth = 2;
          constraints.insets = new Insets(20, -50, 0, 0);
          this.add(loginButton, constraints);

          constraints.gridx = 1;
          constraints.gridy = 5;
          constraints.gridwidth = 2;
          constraints.insets = new Insets(20, 100, 0, 0);
          this.add(registerButton, constraints);
     }

     private void registerUser() {
          String firstName = firstNameField.getText();
          String lastName = lastNameField.getText();
          String email = emailField.getText();
          String password = new String(passwordField.getPassword());
          String confirmPassword = new String(confirmPasswordField.getPassword());

          if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
               System.out.println("All fields are required");
          } else if (!password.equals(confirmPassword)) {
                  JOptionPane.showMessageDialog(this, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
          } else {
               String userRegisterMessage = dbAuth.registerUser(firstName, lastName, email, password);
               if(userRegisterMessage.equals("User already exists")) {
                    JOptionPane.showMessageDialog(this, userRegisterMessage, "Error", JOptionPane.ERROR_MESSAGE);
               }
               else {
                    JOptionPane.showMessageDialog(this, userRegisterMessage, "Success", JOptionPane.INFORMATION_MESSAGE);
               }
               
          }
     }

     /*
     * paint the background image
     * @param g
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            backgroundImage = ImageIO.read(new File(appConfig.REGISTER_FORM_BACKGROUND_IMAGE));
            this.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    backgroundImage = backgroundImage.getScaledInstance(appConfig.LOGIN_FORM_BACKGROUND_IMAGE_WIDTH, appConfig.LOGIN_FORM_BACKGROUND_IMAGE_HEIGHT, Image.SCALE_SMOOTH);
                    repaint();
                }
            });
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        // resize image
        backgroundImage = backgroundImage.getScaledInstance(appConfig.LOGIN_FORM_BACKGROUND_IMAGE_WIDTH, appConfig.LOGIN_FORM_BACKGROUND_IMAGE_HEIGHT, Image.SCALE_SMOOTH);

        // Draw the background image.
        g.drawImage(backgroundImage, 0, 0, this);

        // Draw a rectangle on top of the background image.
        // cast graphics object to graphics2d
        Graphics2D g2d = (Graphics2D) g;

        // set transparency
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f));


        // Convert hexadecimal color code to Color
        Color bgColor = Color.decode(appConfig.PRIMARY_BG_COLOR);
        g.setColor(bgColor); // Set the color of the rectangle.
        g.fillRoundRect(200, 320, 500, 400, 50,50); // Draw a rectangle at (50,50) with width 200 and height 100.
        
    }
}
