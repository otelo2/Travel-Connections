/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.connections;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.geom.*;

/**
 *
 * @author admin
 */
public class GUI extends JFrame implements MouseListener {

    //Set size and position of main window
    int FRAME_WIDTH = 1200;
    int FRAME_HEIGHT = 457;
    int FRAME_X_ORIGIN = 110;
    int FRAME_Y_ORIGIN = 180;

    boolean firstTime = true;
    int origin, destination;
    int locX, locY, orCoordX, orCoordY, desCoordX, desCoordY;
    int selection = 9999;

    GUI() throws IOException {
        Container contentPane;

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setTitle("Travel Connections");
        setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.setBackground(Color.black);

        //Adds the map background image
        BufferedImage img = ImageIO.read(new File("map.jpg"));
        JLabel background = new JLabel(new ImageIcon(img));
        background.setBounds(0, 0, 900, 447);
        background.setOpaque(false);
        contentPane.add(background);
        
        JTextArea itineraryArea;

        //Adds the red pointer
        NavArrow NY = new NavArrow("New York", 170, 95);
        NY.addMouseListener(this);
        NavArrow FR = new NavArrow("France", 366, 75);
        FR.addMouseListener(this);
        NavArrow AF = new NavArrow("Afganistan", 530, 115);
        AF.addMouseListener(this);
        NavArrow AMS = new NavArrow("Amsterdam", 375, 60);
        AMS.addMouseListener(this);
        NavArrow CHL = new NavArrow("Chile", 173, 335);
        CHL.addMouseListener(this);
        NavArrow RU = new NavArrow("Russia", 445, 40);
        RU.addMouseListener(this);
        NavArrow CHI = new NavArrow("China", 640, 130);
        CHI.addMouseListener(this);
        NavArrow MAR = new NavArrow("Marruecos", 344, 120);
        MAR.addMouseListener(this);
        NavArrow MX = new NavArrow("Mexico", 90, 160);
        MX.addMouseListener(this);
        NavArrow HAW = new NavArrow("Hawai", 13, 131);
        HAW.addMouseListener(this);
        NavArrow EA = new NavArrow("Emiratos Arabes", 504, 145);
        EA.addMouseListener(this);
        NavArrow JP = new NavArrow("Japan", 716, 108);
        JP.addMouseListener(this);
        NavArrow TAI = new NavArrow("Thailand", 633, 172);
        TAI.addMouseListener(this);
        NavArrow AUS = new NavArrow("Australia", 711, 294);
        AUS.addMouseListener(this);
        NavArrow IR = new NavArrow("Ireland", 343, 53);
        IR.addMouseListener(this);
        contentPane.add(NY);
        contentPane.add(FR);
        contentPane.add(AF);
        contentPane.add(AMS);
        contentPane.add(CHL);
        contentPane.add(RU);
        contentPane.add(CHI);
        contentPane.add(MAR);
        contentPane.add(MX);
        contentPane.add(HAW);
        contentPane.add(EA);
        contentPane.add(JP);
        contentPane.add(TAI);
        contentPane.add(AUS);
        contentPane.add(IR);

        
        itineraryArea = new JTextArea();
        itineraryArea.setBounds(900, 0, 300,457);
        itineraryArea.setEditable(true);
        itineraryArea.setForeground(Color.black);
        itineraryArea.setBackground(Color.white);
        contentPane.add(itineraryArea);
        
        contentPane.add(background);


        //So it stops the program once you close the windows
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
    }

    @Override
    public void mousePressed(MouseEvent arg0) {

    }

    @Override
    public void mouseReleased(MouseEvent event) {
//        System.out.println("Clicked on a red pointer " + event.getComponent());

        if (event.getSource() instanceof NavArrow) {

            if (event.getComponent().toString().contains("text=New York")) {
                locX = event.getXOnScreen();
                locY = event.getYOnScreen();
                selection = 0;
                System.out.println("Selected New York airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=France")) {
                locX = event.getXOnScreen();
                locY = event.getYOnScreen();
                selection = 1;
                System.out.println("Selected France airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=Afganistan")) {
                locX = event.getXOnScreen();
                locY = event.getYOnScreen();
                selection = 2;
                System.out.println("Selected Afganistan airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=Amsterdam")) {
                locX = event.getXOnScreen();
                locY = event.getYOnScreen();
                selection = 3;
                System.out.println("Selected Amsterdam airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=Chile")) {
                locX = event.getXOnScreen();
                locY = event.getYOnScreen();
                selection = 4;
                System.out.println("Selected Chile airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=Russia")) {
                locX = event.getXOnScreen();
                locY = event.getYOnScreen();
                selection = 5;
                System.out.println("Selected Russia airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=China")) {
                locX = event.getXOnScreen();
                locY = event.getYOnScreen();
                selection = 6;
                System.out.println("Selected China airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=Marruecos")) {
                locX = event.getXOnScreen();
                locY = event.getYOnScreen();
                selection = 7;
                System.out.println("Selected Marruecos airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=Mexico")) {
                locX = event.getXOnScreen();
                locY = event.getYOnScreen();
                selection = 8;
                System.out.println("Selected Mexico City airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=Hawai")) {
                locX = event.getXOnScreen();
                locY = event.getYOnScreen();
                selection = 9;
                System.out.println("Selected Hawai airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=Emiratos Arabes")) {
                locX = event.getXOnScreen();
                locY = event.getYOnScreen();
                selection = 10;
                System.out.println("Selected Emiratos Arabes airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=Japan")) {
                locX = event.getXOnScreen();
                locY = event.getYOnScreen();
                selection = 11;
                System.out.println("Selected Japan airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=Thailand")) {
                locX = event.getXOnScreen();
                locY = event.getYOnScreen();
                selection = 12;
                System.out.println("Selected Thailand airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=Australia")) {
                locX = event.getXOnScreen();
                locY = event.getYOnScreen();
                selection = 13;
                System.out.println("Selected Australia airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=Ireland")) {
                locX = event.getXOnScreen();
                locY = event.getYOnScreen();
                selection = 14;
                System.out.println("Selected Ireland airport. " + selection + " " + locX + " " + locY + " " + event.getComponent());
            }


            if (firstTime) {
                orCoordX = locX;
                orCoordY = locY;
                origin = selection;
                firstTime = false;
            } else {
                desCoordX = locX;
                desCoordY = locY;
                destination = selection;
                System.out.println(orCoordX + " " + orCoordY + " " + desCoordX + " " + desCoordY);
                System.out.println("Origin: " + origin + " Destination: " + destination);
                firstTime = true;
            }

        }
    }

  
    

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

}
