package org.notiflyer.app.views.navigation;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class NavBar extends JPanel {
    public NavBar() {
        // instantiate the parent JPanel class
        super();
    }

    public NavBar(double hostWindowWidth, double hostWindowHeight) {
        // instantiate the parent JPanel class
        super();
        // render the navigation bar
        renderNavBar(hostWindowWidth,hostWindowHeight);
    }

    

    private void renderNavBar(double hostWindowWidth, double hostWindowHeight) {
        // render the navigation bar
        // create a new JPanel 
        // get the current host monitor resolution
        // set the JPanel size to the host monitor resolution
        // 25% of the panel resolution
        System.out.println(hostWindowWidth);
        hostWindowWidth = hostWindowWidth * 0.1;
        
        System.out.println(hostWindowWidth);
        setPreferredSize(new Dimension((int)hostWindowWidth, (int)hostWindowHeight));
        setBackground(Color.decode("#7c162e"));
    }

}
