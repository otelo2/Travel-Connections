/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.connections;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author admin
 */
public class NavArrow extends JLabel {
     int pointerWidth=20;
     int pointerHeight=30;
     
     NavArrow(String name, int posx, int posy){
        try {
            BufferedImage pointer = ImageIO.read(new File("pointer.png"));
            ImageIcon icon = new ImageIcon(pointer);
            setIcon(icon);
        } catch (IOException ex) {
            System.out.println("Pointer image not found");
        }
        setText(name);
        setOpaque(false);
        setBounds(posx,posy,pointerWidth,pointerHeight);
     }
}
