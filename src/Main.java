import javax.swing.*;
import java.awt.*;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {

        final int DIMENSIONS = 200; // Editar para cambiar tamaño
        final int TIME_STEP = 25; // EN MILISEGUNDOS cuanto espera cada bucle.

        int[][] a = new int[DIMENSIONS][DIMENSIONS];
//        a[2][2] = 1;
//        a[3][3] = 1;
//        a[4][1] = 1;
//        a[4][2] = 1;
//        a[4][3] = 1;
        //a[4][1] = 1;
        //a[4][2] = 1;
        //a[4][3] = 1;

//        a[1+10][2+10] = 1;
//        a[1+10][3+10] = 1;
//        a[2+10][1+10] = 1;
//        a[2+10][2+10] = 1;
//        a[3+10][2+10] = 1;
//
//        a[1+50][2+50] = 1;
//        a[1+50][3+50] = 1;
//        a[2+50][1+50] = 1;
//        a[2+50][2+50] = 1;
//        a[3+50][2+50] = 1;
        for (int j=1;j<a.length-1;j++) {
            for (int i=1;i<a.length-1;i++) {

                a[j][i] = (int) (Math.random()+0.1234f);
            }
        }

        MyFrame frame = new MyFrame(a);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocation(300,0);
        frame.getContentPane().setBackground(Color.BLACK);


        while (true) {
            frame.repaint();
            try {
                sleep(TIME_STEP);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //System.out.println(n);
        }
    }
}