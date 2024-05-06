package org.notiflyer.app.views.navigation;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.notiflyer.app.config.ApplicationConfig;

public class NavBar extends JPanel {

    private ApplicationConfig config = new ApplicationConfig();

    /**
     * NavBar constructor - default resolution
     */
    public NavBar() {
        // instantiate the parent JPanel class
        super();
        // render the navigation bar
        renderNavBar();
        // add the components of the navigation bar
        addNavBarComponents();
    }

    /**
     * NavBar constructor - custom resolution
     *
     * @param hostWindowWidth
     * @param hostWindowHeight
     */
    public NavBar(double hostWindowWidth, double hostWindowHeight) {
        // instantiate the parent JPanel class
        super();
        // render the navigation bar
        renderNavBar(hostWindowWidth,hostWindowHeight);
        // add the components of the navigation bar
        addNavBarComponents();
    }

    
    /**
     * render the navigation bar - default resolution
     */
    private void renderNavBar() {
        // render the navigation bar
        // create a new JPanel 
        // get the current host monitor resolution
        // set the JPanel size to the host monitor resolution
        // 25% of the panel resolution
        setPreferredSize(new Dimension(config.NAV_BAR_WIDTH, config.NAV_BAR_HEIGHT));
        
    }

    private void renderNavBar(double hostWindowWidth, double hostWindowHeight) {
        // render the navigation bar
        // create a new JPanel 
        // get the current host monitor resolution
        // set the JPanel size to the host monitor resolution
        // 25% of the panel resolution
        hostWindowWidth = hostWindowWidth * 0.1;
        
        setPreferredSize(new Dimension((int)hostWindowWidth, (int)hostWindowHeight));
        
    }

    /**
     * get the components of the navigation bar
     * @return 
     */
    private void addNavBarComponents() {

        setBackground(Color.decode(config.NAV_BAR_BG_COLOR));
        
        // home page link - dashboard for all job information
        JLabel homePageLink = new JLabel("Home");
        homePageLink.setIcon(new ImageIcon("assets/img/icons/home.png"));
        add(homePageLink);

        // query page link - add new query

        // query edit/delete link - edit or delete existing query

        // job page link - add new job

        // job edit/delete link - edit or delete existing job


    }

}
