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
    boolean directFlight = true;
    int origin, destination;
    int locX, locY, orCoordX, orCoordY, desCoordX, desCoordY;
    int selection = 9999;

    JTextArea itineraryArea;
    NavArrow NY;
    NavArrow FR;
    NavArrow AF;
    NavArrow AMS;
    NavArrow CHL;
    NavArrow RU;
    NavArrow CHI;
    NavArrow MAR;
    NavArrow MX;
    NavArrow HAW;
    NavArrow EA;
    NavArrow JP;
    NavArrow TAI;
    NavArrow AUS;
    NavArrow IR;

    Maat matrix;
    int price = 6942069;
    String itinerary;
    int lineArr[][];

    GUI() throws IOException {
        Container contentPane;

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setTitle("Travel Connections");
        setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.setBackground(Color.white);

        //Adds the map background image
        BufferedImage img = ImageIO.read(new File("map.jpg"));
        JLabel background = new JLabel(new ImageIcon(img));
        background.setBounds(0, 0, 900, 447);
        background.setOpaque(false);
        contentPane.add(background);

        //Adds the red pointer
        NY = new NavArrow("New York", 170, 95);
        NY.addMouseListener(this);
        FR = new NavArrow("France", 366, 75);
        FR.addMouseListener(this);
        AF = new NavArrow("Afganistan", 530, 115);
        AF.addMouseListener(this);
        AMS = new NavArrow("Amsterdam", 375, 60);
        AMS.addMouseListener(this);
        CHL = new NavArrow("Chile", 173, 335);
        CHL.addMouseListener(this);
        RU = new NavArrow("Russia", 445, 40);
        RU.addMouseListener(this);
        CHI = new NavArrow("China", 640, 130);
        CHI.addMouseListener(this);
        MAR = new NavArrow("Marruecos", 344, 120);
        MAR.addMouseListener(this);
        MX = new NavArrow("Mexico", 90, 160);
        MX.addMouseListener(this);
        HAW = new NavArrow("Hawai", 13, 131);
        HAW.addMouseListener(this);
        EA = new NavArrow("Emiratos Arabes", 504, 145);
        EA.addMouseListener(this);
        JP = new NavArrow("Japan", 716, 108);
        JP.addMouseListener(this);
        TAI = new NavArrow("Thailand", 633, 172);
        TAI.addMouseListener(this);
        AUS = new NavArrow("Australia", 711, 294);
        AUS.addMouseListener(this);
        IR = new NavArrow("Ireland", 343, 53);
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

        JLabel itLogo = new JLabel();
        itLogo.setText("Itinerary:");
        itLogo.setBounds(900, 0, 80, 80);
        contentPane.add(itLogo);

        itineraryArea = new JTextArea();
        itineraryArea.setBounds(900, 80, 300, 457);
        itineraryArea.setEditable(false);
        itineraryArea.setForeground(Color.black);
        itineraryArea.setBackground(Color.white);
        contentPane.add(itineraryArea);

        contentPane.add(background);

        //So it stops the program once you close the windows
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        matrix = new Maat();
        matrix.Fill();
    }

    @Override
    public void mouseReleased(MouseEvent event) {
//        System.out.println("Clicked on a red pointer " + event.getComponent());
        selection = 999;
        if (event.getSource() instanceof NavArrow) {

            if (event.getComponent().toString().contains("text=New York")) {
                locX = NY.xCoord;
                locY = NY.yCoord;
                selection = 0;
                System.out.println("Selected New York airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=France")) {
                locX = FR.xCoord;
                locY = FR.yCoord;
                selection = 1;
                System.out.println("Selected France airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=Afganistan")) {
                locX = AF.xCoord;
                locY = AF.yCoord;
                selection = 2;
                System.out.println("Selected Afganistan airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=Amsterdam")) {
                locX = AMS.xCoord;
                locY = AMS.yCoord;
                selection = 3;
                System.out.println("Selected Amsterdam airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=Chile")) {
                locX = CHL.xCoord;
                locY = CHL.yCoord;
                selection = 4;
                System.out.println("Selected Chile airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=Russia")) {
                locX = RU.xCoord;
                locY = RU.yCoord;
                selection = 5;
                System.out.println("Selected Russia airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=China")) {
                locX = CHI.xCoord;
                locY = CHI.yCoord;
                selection = 6;
                System.out.println("Selected China airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=Marruecos")) {
                locX = MAR.xCoord;
                locY = MAR.yCoord;
                selection = 7;
                System.out.println("Selected Marruecos airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=Mexico")) {
                locX = MX.xCoord;
                locY = MX.yCoord;
                selection = 8;
                System.out.println("Selected Mexico City airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=Hawai")) {
                locX = HAW.xCoord;
                locY = HAW.yCoord;
                selection = 9;
                System.out.println("Selected Hawai airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=Emiratos Arabes")) {
                locX = EA.xCoord;
                locY = EA.yCoord;
                selection = 10;
                System.out.println("Selected Emiratos Arabes airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=Japan")) {
                locX = JP.xCoord;
                locY = JP.yCoord;
                selection = 11;
                System.out.println("Selected Japan airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=Thailand")) {
                locX = TAI.xCoord;
                locY = TAI.yCoord;
                selection = 12;
                System.out.println("Selected Thailand airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=Australia")) {
                locX = AUS.xCoord;
                locY = AUS.yCoord;
                selection = 13;
                System.out.println("Selected Australia airport. " + selection + " " + locX + " " + locY);
            }
            if (event.getComponent().toString().contains("text=Ireland")) {
                locX = IR.xCoord;
                locY = IR.yCoord;
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
                System.out.println("Origin: " + origin + " Destination: " + destination);
//                itinerary = printItinerary();
//                itineraryArea.setText(itinerary);
//                repaint();
                if (origin != destination) {
                    price = matrix.BuscarD(origin, destination);
                    if (price == 0) {
                        System.out.println("Non-Direct flight");
                        directFlight = false;
                        matrix.FindNemo(origin, destination, 0);
                        for (int i = 0; i < matrix.RoyalR; i++) {
                            System.out.println(matrix.Royalroute[i]);
                        }
                        itinerary = printItinerary(matrix.Royalroute, matrix.Royalprice, matrix.RoyalR);
                        itineraryArea.setText(itinerary);
                        lineArr = coordinateArray(matrix.Royalroute, matrix.RoyalR);
//                        matrix.Fill();
                    } else {
                        System.out.println("Direct flight");
                        directFlight = true;
                        itinerary = printItinerary(price);
                        itineraryArea.setText(itinerary);
                    }
                    firstTime = true;

                    repaint();
                } else {
                    System.out.println("Origin and destination are the same");
                    itineraryArea.setText("Same origin and destination!");
                }

            }

        }
    }

    public String printItinerary(int[] vec, int price, int size) {
        String itin = "";

        //Le da el nombre del aeropuerto a cada número de aeropuerto
        //Posteriormente añade todo a la string que el método regresa.
        for (int i = 0; i < size; i++) {
            switch (vec[i]) {
                case 0:
                    itin = itin + "New York " + System.lineSeparator();
                    break;
                case 1:
                    itin = itin + "France " + System.lineSeparator();
                    break;
                case 2:
                    itin = itin + "Afganistan " + System.lineSeparator();
                    break;
                case 3:
                    itin = itin + "Amsterdam " + System.lineSeparator();
                    break;
                case 4:
                    itin = itin + "Chile " + System.lineSeparator();
                    break;
                case 5:
                    itin = itin + "Russia " + System.lineSeparator();
                    break;
                case 6:
                    itin = itin + "China " + System.lineSeparator();
                    break;
                case 7:
                    itin = itin + "Marruecos " + System.lineSeparator();
                    break;
                case 8:
                    itin = itin + "Mexico " + System.lineSeparator();
                    break;
                case 9:
                    itin = itin + "Hawai " + System.lineSeparator();
                    break;
                case 10:
                    itin = itin + "Emiratos Arabes " + System.lineSeparator();
                    break;
                case 11:
                    itin = itin + "Japan " + System.lineSeparator();
                    break;
                case 12:
                    itin = itin + "Thailand " + System.lineSeparator();
                    break;
                case 13:
                    itin = itin + "Australia " + System.lineSeparator();
                    break;
                case 14:
                    itin = itin + "Ireland " + System.lineSeparator();
                    break;
                default:
                    itin = "OH NO";
                    break;

            }
        }
        itin = itin + "Price: $" + price + System.lineSeparator();
        itin = itin + "Return route is the same" + System.lineSeparator() + System.lineSeparator();
        itin = itin + "Final price: $" + price*2 + System.lineSeparator();
        return itin;
    }

    //Prints the itinerary of a direct flight and returns a string of the result.
    public String printItinerary(int price) {
        String itin = "";
        int temp[] = new int[2];
        //Assign the airport numbers to the array
        temp[0] = origin;
        temp[1] = destination;

        //Le da el nombre del aeropuerto a cada número de aeropuerto
        //Posteriormente añade todo a la string que el método regresa.
        for (int i = 0; i < temp.length; i++) {
            switch (temp[i]) {
                case 0:
                    itin = itin + "New York " + System.lineSeparator();
                    break;
                case 1:
                    itin = itin + "France " + System.lineSeparator();
                    break;
                case 2:
                    itin = itin + "Afganistan " + System.lineSeparator();
                    break;
                case 3:
                    itin = itin + "Amsterdam " + System.lineSeparator();
                    break;
                case 4:
                    itin = itin + "Chile " + System.lineSeparator();
                    break;
                case 5:
                    itin = itin + "Russia " + System.lineSeparator();
                    break;
                case 6:
                    itin = itin + "China " + System.lineSeparator();
                    break;
                case 7:
                    itin = itin + "Marruecos " + System.lineSeparator();
                    break;
                case 8:
                    itin = itin + "Mexico " + System.lineSeparator();
                    break;
                case 9:
                    itin = itin + "Hawai " + System.lineSeparator();
                    break;
                case 10:
                    itin = itin + "Emiratos Arabes " + System.lineSeparator();
                    break;
                case 11:
                    itin = itin + "Japan " + System.lineSeparator();
                    break;
                case 12:
                    itin = itin + "Thailand " + System.lineSeparator();
                    break;
                case 13:
                    itin = itin + "Australia " + System.lineSeparator();
                    break;
                case 14:
                    itin = itin + "Ireland " + System.lineSeparator();
                    break;
                default:
                    itin = "OH NO";
                    break;

            }
        }
        itin = itin + "Price: $" + price + System.lineSeparator();
        itin = itin + "Return route is the same" + System.lineSeparator() + System.lineSeparator();
        itin = itin + "Final price: $" + price*2 + System.lineSeparator();
        return itin;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //Add the lines to create the itinerary "Table"
        //Vertical lines
        g.drawLine(900, 380, 900, 112);
        g.drawLine(1100, 380, 1100, 112);

        //Horizontal lines
        g.drawLine(900, 380, 1100, 380);
        g.drawLine(1100, 112, 900, 112);

        //Draw the lines from and to each selected airport
        int xOffset = 20;
        int yOffset = 40;
        if (directFlight) {
            g.drawLine(desCoordX + xOffset, desCoordY + yOffset, orCoordX + xOffset, orCoordY + yOffset);
        } else {
            for (int i = 0; i < matrix.RoyalR - 1; i++) {
                g.drawLine(lineArr[i + 1][i + 1] + xOffset, lineArr[i + 1][i + 2] + yOffset, lineArr[i][i] + xOffset, lineArr[i][i + 1] + yOffset);
//                System.out.println("x2: " + lineArr[i + 1][i + 1] + " " + "y2: " + lineArr[i + 1][i + 2] + " " + "x1: " + lineArr[i][i] + " " + "y1: " + lineArr[i][i + 1]);
            }
        }
//        System.out.println(desCoordX + " " + desCoordY + " " + orCoordX + " " + orCoordY);
    }

    //This method finds the coordinate for each and every airport and puts it in a matrix
    //For use with the drawLine methoid in paint.
    int[][] coordinateArray(int[] vec, int size) {
        int[][] coords = new int[size + 1][size + 1];
        int i, j;
        i = j = 0;
        while (i < size) {
            switch (vec[i]) {
                case 0:
                    coords[i][i] = NY.xCoord;
                    coords[i][i + 1] = NY.yCoord;
                    System.out.println(coords[i][i] + " " + coords[i][i + 1]);
                    break;
                case 1:
                    coords[i][i] = FR.xCoord;
                    coords[i][i + 1] = FR.yCoord;
                    System.out.println(coords[i][i] + " " + coords[i][i + 1]);

                    break;
                case 2:
                    coords[i][i] = AF.xCoord;
                    coords[i][i + 1] = AF.yCoord;
                    System.out.println(coords[i][i] + " " + coords[i][i + 1]);

                    break;
                case 3:
                    coords[i][i] = AMS.xCoord;
                    coords[i][i + 1] = AMS.yCoord;
                    System.out.println(coords[i][i] + " " + coords[i][i + 1]);
                    break;
                case 4:
                    coords[i][i] = CHL.xCoord;
                    coords[i][i + 1] = CHL.yCoord;
                    System.out.println(coords[i][i] + " " + coords[i][i + 1]);
                    break;
                case 5:
                    coords[i][i] = RU.xCoord;
                    coords[i][i + 1] = RU.yCoord;
                    System.out.println(coords[i][i] + " " + coords[i][i + 1]);
                    break;
                case 6:
                    coords[i][i] = CHI.xCoord;
                    coords[i][i + 1] = CHI.yCoord;
                    System.out.println(coords[i][i] + " " + coords[i][i + 1]);
                    break;
                case 7:
                    coords[i][i] = MAR.xCoord;
                    coords[i][i + 1] = MAR.yCoord;
                    System.out.println(coords[i][i] + " " + coords[i][i + 1]);
                    break;
                case 8:
                    coords[i][i] = MX.xCoord;
                    coords[i][i + 1] = MX.yCoord;
                    System.out.println(coords[i][i] + " " + coords[i][i + 1]);
                    break;
                case 9:
                    coords[i][i] = HAW.xCoord;
                    coords[i][i + 1] = HAW.yCoord;
                    System.out.println(coords[i][i] + " " + coords[i][i + 1]);
                    break;
                case 10:
                    coords[i][i] = EA.xCoord;
                    coords[i][i + 1] = EA.yCoord;
                    System.out.println(coords[i][i] + " " + coords[i][i + 1]);
                    break;
                case 11:
                    coords[i][i] = JP.xCoord;
                    coords[i][i + 1] = JP.yCoord;
                    System.out.println(coords[i][i] + " " + coords[i][i + 1]);
                    break;
                case 12:
                    coords[i][i] = TAI.xCoord;
                    coords[i][i + 1] = TAI.yCoord;
                    System.out.println(coords[i][i] + " " + coords[i][i + 1]);
                    break;
                case 13:
                    coords[i][i] = AUS.xCoord;
                    coords[i][i + 1] = AUS.yCoord;
                    System.out.println(coords[i][i] + " " + coords[i][i + 1]);
                    break;
                case 14:
                    coords[i][j] = IR.xCoord;
                    coords[i][i + 1] = IR.yCoord;
                    System.out.println(coords[i][i] + " " + coords[i][i + 1]);
                    break;
                default:
                    System.out.println("whoops");
                    break;
            }
            i++;
        }
        return coords;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

}
