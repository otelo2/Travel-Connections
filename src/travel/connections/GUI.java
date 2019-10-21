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
//        Image pointer = javax.imageio.ImageIO.read(new File("pointer.png"));
        BufferedImage pointer = ImageIO.read(new File("pointer.png"));
        ImageIcon icon = new ImageIcon(pointer);
        int pointerWidth=20;
        int pointerHeight=30;
        JLabel NY = new JLabel("NY");
        NY.setIcon(icon);
        NY.setBounds(170,95,pointerWidth,pointerHeight);
        NY.setOpaque(false);
        NY.addMouseListener(this);
        JLabel MX = new JLabel("MX");
        MX.setIcon(icon);
        MX.setBounds(90,160,pointerWidth,pointerHeight);
        MX.setOpaque(false);
        MX.addMouseListener(this);
        contentPane.add(NY);
        contentPane.add(MX);
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
        String ans = event.getComponent().toString();
        if(event.getComponent().toString().contains("text=NY")){
            System.out.println("Selected New York airport.");
        }
        if(event.getComponent().toString().contains("text=MX")){
            System.out.println("Selected Mexico City airport.");
        }
        
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

}
