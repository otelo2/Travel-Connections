/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.connections;

import java.awt.*;
import java.awt.event.*;
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
public class GUI extends JFrame implements ActionListener {

    //Set size and position of main window
    int FRAME_WIDTH = 900;
    int FRAME_HEIGHT = 447;
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

        //Sets the map background
        try {
            Image backgroundImage = javax.imageio.ImageIO.read(new File("map.jpg"));
            setContentPane(new JPanel(new BorderLayout()) {

                public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Adds the red pointer
        Image pointer = javax.imageio.ImageIO.read(new File("pointer.png"));
        ImageIcon icon = new ImageIcon(pointer);
        JLabel redThing = new JLabel();
        redThing.setIcon(icon);
        int posx, posy;
        posx=posy=200;
        redThing.setHorizontalAlignment(posx);
        redThing.setVerticalAlignment(posy);
        contentPane.add(redThing);

        //So it stops the program once you close the windows
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent arg) {
        //yes
    }

}
