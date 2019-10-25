/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.connections;

/**
 *
 * @author
 */
public class Maat {

    int maat[][];
    int route[], Royalroute[];
    int i, Royalprice = 500000, RoyalR = 0;
    boolean found;

    Maat() {
        maat = new int[15][15];
        found = false;
        route = new int[15];
        Royalroute = new int[15];

    }

    void Fill() {
        int j;
        for (i = 0; i < 15; i++) {
            for (j = 0; j < 15; j++) {
                maat[i][j] = 0;
            }
            route[i] = 0;
            Royalroute[i] = 0;
        }
        //Primer renglón
        maat[0][1] = maat[1][0] = 800;
        maat[0][3] = maat[3][0] = 500;
        maat[0][4] = maat[4][0] = 200;
        maat[0][5] = maat[5][0] = 400;
        maat[0][6] = maat[6][0] = 850;
        maat[0][8] = maat[8][0] = 100;
        maat[0][9] = maat[9][0] = 60;
        maat[0][14] = maat[14][0] = 470;

        //Segundo renglón      
        maat[1][2] = maat[2][1] = 125;
        maat[1][3] = maat[3][1] = 80;

        //Tercer renglón
        maat[2][7] = maat[7][2] = 200;
        maat[2][10] = maat[10][2] = 75;

        //Cuarto renglón
        maat[3][14] = maat[14][3] = 50;

        //Quinto renglón
        maat[4][8] = maat[8][4] = 70;

        //Sexto renglón
        maat[5][7] = maat[7][5] = 150;
        maat[5][10] = maat[10][5] = 240;
        maat[5][14] = maat[14][5] = 150;

        //Séptimo renglón
        maat[6][10] = maat[10][6] = 300;
        maat[6][11] = maat[11][6] = 90;
        maat[6][12] = maat[12][6] = 60;
        maat[6][13] = maat[13][6] = 350;

        //Octavo renglón
        maat[7][14] = maat[14][7] = 100;

        //Noveno renglón        
        //Décimo renglón        
        //Onceavo renglón
        //Doceavo renglón
        maat[11][12] = maat[12][11] = 70;
        maat[11][13] = maat[13][11] = 250;

        //Treceavo renglón        
        //Catorceavo renglón                
        //Quinceavo renglón                    
    }

    void pRINT() {
        int j;
        for (i = 0; i < 15; i++) {
            for (j = 0; j < 15; j++) {
                System.out.printf("%4d\t", maat[i][j]);
            }
            System.out.println();
        }
    }

    int BuscarD(int here, int there) {
        int j;
        j = 0;
        int price=0;
        if (maat[here][there] != 0) {
            price = maat[here][there];
        } 
        return price;
    }

    void FindNemo(int here, int there, int r) {
        route[r] = here;
        i++;
        r++;
        boolean rep = false;
        int price = 0;
        for (int k = 0; k < r - 1; k++) {
            if (here == route[k]) {
                rep = true;
            }
        }
        if (rep != true) {
            for (int j = 0; j < 15; j++) {
                if (maat[here][j] != 0) {
                    route[r] = j;
                    if (j != there) {
                        FindNemo(j, there, r);
                    } else {
                        for (int e = 0; e < r; e++) {
                            price = price + maat[route[e]][route[e + 1]];
                        }
                        System.out.println(price);
                        if (price < Royalprice) {
                            Royalprice = price;
                            RoyalR = r + 1;
                            for (int e = 0; e <= r; e++) {
                                Royalroute[e] = route[e];
                            }
                        }
                    }
                }
            }
        }
    }
}


