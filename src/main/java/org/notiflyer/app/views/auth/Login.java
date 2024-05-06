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
@name           Login.java
@description    login user form view
@version        0.0.1
@date           04/24/2024
@homepage       https://github.com/cleancoda/notiflyer-app
@log
                04/24/2024  v0.0.1  cleancoda - basic scaffolding added
*/

// declare package
package org.notiflyer.app.views.auth;

// import dependencies for gui forms
import java.awt.AlphaComposite;
import java.awt.Color;
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

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.notiflyer.app.config.ApplicationConfig;
import org.notiflyer.app.controller.FormsManager;
import org.notiflyer.app.views.app.MainWindow;

/*
 * Login class to generate UI components on login form
 */
public class Login extends JPanel {

    // constructor
    public Login() {
        initComponents();
    }

    // declare fields
    private Image backgroundImage;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    // declare app config
    ApplicationConfig appConfig = new ApplicationConfig();

    private void initComponents() {

        // set layout manager
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Create fields and button
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        registerButton.addActionListener(e -> {
            FormsManager.getInstance().showIndependentPanel(new Register());
        });

        loginButton.addActionListener(e -> {
            MainWindow mainWindow = new MainWindow();
            //FormsManager.getInstance().showForm(new JobManager(), "Job Manager");
        });

        // Add fields and button to panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 0, 0, 0);
        this.add(new JLabel("Username:"), constraints);

        constraints.gridx = 1;
        this.add(usernameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(10, 0, 0, 0);
        this.add(new JLabel("Password:"), constraints);

        constraints.gridx = 1;
        this.add(passwordField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(10, -50, 0, 0);
        this.add(loginButton, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(10, 100, 0, 0);
        // registerButton.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         register();
        //     }
        // });
        this.add(registerButton, constraints);
        
    }
    /*
     * paint the background image
     * @param g
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            backgroundImage = ImageIO.read(new File(appConfig.LOGIN_FORM_BACKGROUND_IMAGE));
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
        g.fillRoundRect(200, 300, 500, 300, 50,50); // Draw a rectangle at (50,50) with width 200 and height 100.
        
    }
}