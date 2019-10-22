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

/**
 *
 * @author admin
 */
public class GUI extends JFrame implements MouseListener {

    //Set size and position of main window
    int FRAME_WIDTH = 900;
    int FRAME_HEIGHT = 457;
    int FRAME_X_ORIGIN = 300;
    int FRAME_Y_ORIGIN = 180;

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
        background.setBounds(0,0,900,447);
        background.setOpaque(false);
//       contentPane.add(background);

        //Adds the red pointer
        NavArrow NY = new NavArrow("New York",170,95);
        NY.addMouseListener(this);
        NavArrow FR = new NavArrow("France",366,75);
        FR.addMouseListener(this);
        NavArrow AF = new NavArrow("Afganistan",530,115);
        AF.addMouseListener(this);
        NavArrow AMS = new NavArrow("Amsterdam",375,60);
        AMS.addMouseListener(this);
        NavArrow CHL = new NavArrow("Chile",173,335);
        CHL.addMouseListener(this);
        NavArrow RU = new NavArrow("Russia",445,40);
        RU.addMouseListener(this);
        NavArrow CHI = new NavArrow("China",640,130);
        CHI.addMouseListener(this);
        NavArrow MAR = new NavArrow("Marruecos",344,120);
        MAR.addMouseListener(this);
        NavArrow MX = new NavArrow("Mexico",90,160);
        MX.addMouseListener(this);
        NavArrow HAW = new NavArrow("Hawai",13,131);
        HAW.addMouseListener(this);
        NavArrow EA = new NavArrow("Emiratos Arabes",504,145);
        EA.addMouseListener(this);
        NavArrow JP = new NavArrow("Japan",716,108);
        JP.addMouseListener(this);
        NavArrow TAI = new NavArrow("Thailand",633,172);
        TAI.addMouseListener(this);
        NavArrow AUS = new NavArrow("Australia",711,294);
        AUS.addMouseListener(this);
        NavArrow IR = new NavArrow("Ireland",343,53);
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

        if(event.getComponent().toString().contains("text=New York")){
            System.out.println("Selected New York airport.");
        }
        if(event.getComponent().toString().contains("text=France")){
            System.out.println("Selected France airport.");
        }
        if(event.getComponent().toString().contains("text=Afganistan")){
            System.out.println("Selected Afganistan airport.");
        }
        if(event.getComponent().toString().contains("text=Amsterdam")){
            System.out.println("Selected Amsterdam airport.");
        }
        if(event.getComponent().toString().contains("text=Chile")){
            System.out.println("Selected Chile airport.");
        }
        if(event.getComponent().toString().contains("text=Russia")){
            System.out.println("Selected Russia airport.");
        }
        if(event.getComponent().toString().contains("text=China")){
            System.out.println("Selected China airport.");
        }
        if(event.getComponent().toString().contains("text=Marruecos")){
            System.out.println("Selected Marruecos airport.");
        }
        if(event.getComponent().toString().contains("text=Mexico")){
            System.out.println("Selected Mexico City airport.");
        }
        if(event.getComponent().toString().contains("text=Hawai")){
            System.out.println("Selected Hawai airport.");
        }
        if(event.getComponent().toString().contains("text=Emiratos Arabes")){
            System.out.println("Selected Emiratos Arabes airport.");
        }
        if(event.getComponent().toString().contains("text=Japan")){
            System.out.println("Selected Japan airport.");
        }
        if(event.getComponent().toString().contains("text=Thailand")){
            System.out.println("Selected Thailand airport.");
        }
        if(event.getComponent().toString().contains("text=Australia")){
            System.out.println("Selected Australia airport.");
        }
        if(event.getComponent().toString().contains("text=Ireland")){
            System.out.println("Selected Ireland airport.");
        }
        
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

}
