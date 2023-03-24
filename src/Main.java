import java.awt.Graphics;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        int[][] a = new int[10][10];
        //a[1][3] = 1;
        //a[2][2] = 1;
        //a[2][3] = 1;
        //a[3][2] = 1;
        //a[3][3] = 1;
        a[4][4] = 1;
        a[4][5] = 1;
        a[4][6] = 1;

        Interface face = new Interface(30,a);

        for (int n = 0;n<1;n++) {
            face.next();
        }
    }
}