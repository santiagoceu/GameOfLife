import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.Arrays;

public class Interface extends JComponent{

    private int DIMENSION = 30;
    private int[][] currentScreen = new int[DIMENSION][DIMENSION];
    private int[][] nextScreen;



    //private final int[][] relative_coords = {{-1,-1},{0,-1},{1,-1},{-1,0},{1,0},{-1,1},{0,1},{1,1}};
    public Interface(int[][] start) {
        this.DIMENSION = start.length;
        this.currentScreen = start;
        this.nextScreen = new int[DIMENSION][DIMENSION];



    }

    public void next() {

        //System.out.println(Arrays.deepToString(nextScreen));
        printScreen();
        this.calculateNextScreen();

    }



    private void calculateNextScreen() {
        //for (int i=1;i<DIMENSION-1;i++) {
        //    Arrays.fill(nextScreen[i],0);
        //}
        for (int y = 1;y<DIMENSION-1; y++) {
            for (int x = 1;x<DIMENSION-1;x++) {
                nextScreen[y][x] = checkNeighbors(x,y,currentScreen[y][x]);
            }
        }
        currentScreen = nextScreen;
        nextScreen = new int[DIMENSION][DIMENSION];
    }

    private int checkNeighbors(int x, int y, int state) {
        int count = 0;
//        for (int[] rel:relative_coords) {
//            count += (currentScreen[y+rel[1]][x+rel[0]]==1) ? 1 : 0;
//        }
        for (int j=-1;j<=1;j++) {
            for (int i=-1;i<=1;i++) {
                count += (currentScreen[y+j][x+i]==1) ? 1 : 0;
            }
        }

        if (state == 1 && (count==3 || count==4)) return 1; // el del centro no cuenta
        else if (count==3) return 1; //sabemos que centro es 0
        else return 0;
    }



    public void printScreen() {
        for (int i=1;i<DIMENSION-1;i++) {
            for (int j=1;j<DIMENSION-1;j++) {
                System.out.print(currentScreen[i][j]+" ");
            }
            System.out.print("\n");
        }
        System.out.print("====================\n");
    }

    // SWING


    private static final int DEFAULT_WIDTH = 1000;
    private static final int DEFAULT_HEIGHT = 1000;


    public Dimension getPreferredSize() {return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);}



    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setBackground(Color.BLACK);
        g2.setPaint(Color.WHITE);

        for (int j=1;j<DIMENSION-1;j++) {
            for (int i=1;i<DIMENSION-1;i++) {
                if (currentScreen[j][i]==1) {
                    g2.fillRect(i * 1000/DIMENSION, j * 1000/DIMENSION, 1000/DIMENSION, 1000/DIMENSION);}
            }
        }
        calculateNextScreen();

    }
}

class MyFrame extends JFrame {
    public MyFrame(int[][] a) {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setSize(screenWidth/2,screenHeight/2);
        setLocationByPlatform(true);

        Interface game = new Interface(a);
        add(game);
        pack();

    }
}