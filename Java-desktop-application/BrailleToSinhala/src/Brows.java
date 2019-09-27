/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//import static blind.Brows.calibration;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Sewwandi
 *
 */
public class Brows {

    public int calibration_x = 0, calibration_y = 0, x, y;

// int q = 0;   
    /**
     * @param args the command line arguments
     */
    public int getDecimalFromBinary(int binary) {

        int decimal = 0;
        int power = 0;
        while (true) {
            if (binary == 0) {
                break;
            } else {
                int tmp = binary % 10;
                decimal += tmp * Math.pow(2, power);
                binary = binary / 10;
                power++;
            }
        }
        return decimal;
    }

    public void calibration() throws FileNotFoundException, IOException {

        int p = 0;
        int q = 0;
        try {
            File input = new File("108.png");

            BufferedImage image = ImageIO.read(input);
            Raster raster = image.getData();
            int w = image.getWidth();
            int h = image.getHeight();
          
            int dataBuffInt;
            for (int x = 0; x < w; x++) {
                for (int y = 0; y < h; y++) {
                    dataBuffInt = raster.getSample(x, y, 0);
                    if (dataBuffInt < 15) {
                        
                                                
                        int af = raster.getSample(x, y-2, 0);
                        int bf = raster.getSample(x + 1, y-2, 0);
                        int cf = raster.getSample(x + 2, y-2, 0);
                        int df = raster.getSample(x + 3, y-2, 0);
                        int ef = raster.getSample(x + 4, y-2, 0);
                          
                        int an = raster.getSample(x, y-1, 0);
                        int bn = raster.getSample(x + 1, y-1, 0);
                        int cn = raster.getSample(x + 2, y-1, 0);
                        int dn = raster.getSample(x + 3, y-1, 0);
                        int en = raster.getSample(x + 4, y-1, 0);
                        
                        int a = raster.getSample(x, y, 0);
                        int b = raster.getSample(x + 1, y, 0);
                        int c = raster.getSample(x + 2, y, 0);
                        int d = raster.getSample(x + 3, y, 0);
                        int eo = raster.getSample(x + 4, y, 0);

                        int e = raster.getSample(x, y + 1, 0);
                        int f = raster.getSample(x + 1, y + 1, 0);
                        int h1 = raster.getSample(x + 2, y + 1, 0);
                        int i = raster.getSample(x + 3, y + 1, 0);
                        int kl = raster.getSample(x + 4, y+1, 0);
                        
                        int eh = raster.getSample(x, y + 2, 0);
                        int fh = raster.getSample(x + 1, y + 2, 0);
                        int h1h = raster.getSample(x + 2, y + 2, 0);
                        int ih = raster.getSample(x + 3, y + 2, 0);
                        int nn = raster.getSample(x + 4, y+2, 0);
                        

                        if ((a < 15) || (c < 15) || (b < 15) || (d < 15) || (e < 15) || (f < 15) || (h1 < 15) || (i < 15)||(af < 15) || (cf < 15) || (bf < 15) || (df < 15) || (ef < 15) || (an < 15) || (bn < 15) || (cn < 15)) 
{
                            calibration_x = x;
                            calibration_y = y;
                            x = w;
                            y = h;
                        }
                    }
                }
              
            }
        } catch (Exception er) {
            System.out.println(er.toString());
           
            
           
           
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic her
        try {
            int a4 = 0, b4 = 0, c4 = 0, d4 = 0, e4 = 0, f4 = 0;

            Brows bv = new Brows();
            bv.calibration();
            //cmt
            //System.out.println(bv.calibration_x + "  " + bv.calibration_y);
  
            
            for (int z = 0; z < 319; z++) {
                String name = Integer.toString(z) + ".png";

                File input = new File(name);

                BufferedImage image = ImageIO.read(input);
                Raster raster = image.getData();
                int w = image.getWidth();
                int h = image.getHeight();

                //  Raster raster = image.getData();
                int dataBuffInt = 0;

                int a62z = raster.getSample(bv.calibration_x, bv.calibration_y-2, 0);
                int b62z = raster.getSample(bv.calibration_x + 1, bv.calibration_y-2, 0);
                int c62z = raster.getSample(bv.calibration_x + 2, bv.calibration_y-2, 0);
                int d62z = raster.getSample(bv.calibration_x + 3, bv.calibration_y-2, 0);
                int e62z = raster.getSample(bv.calibration_x + 4, bv.calibration_y-2, 0);
                  
                int a62z1 = raster.getSample(bv.calibration_x, bv.calibration_y-1, 0);
                int b62z1 = raster.getSample(bv.calibration_x + 1, bv.calibration_y-1, 0);
                int c62z1 = raster.getSample(bv.calibration_x + 2, bv.calibration_y-1, 0);
                int d62z1 = raster.getSample(bv.calibration_x + 3, bv.calibration_y-1, 0);
                int e62z1 = raster.getSample(bv.calibration_x + 4, bv.calibration_y-1, 0);
                    
                int a62 = raster.getSample(bv.calibration_x, bv.calibration_y, 0);
                int b62 = raster.getSample(bv.calibration_x + 1, bv.calibration_y, 0);
                int c62 = raster.getSample(bv.calibration_x + 2, bv.calibration_y, 0);
                int d62 = raster.getSample(bv.calibration_x + 3, bv.calibration_y, 0);
                int e162 = raster.getSample(bv.calibration_x + 4, bv.calibration_y, 0);  
                
                int e62 = raster.getSample(bv.calibration_x, bv.calibration_y + 1, 0);
                int f62 = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 1, 0);
                int h162 = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 1, 0);
                int i62 = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 1, 0);
                int j62 = raster.getSample(bv.calibration_x + 4, bv.calibration_y + 1, 0);
                
                int e621 = raster.getSample(bv.calibration_x, bv.calibration_y + 2, 0);
                int f621 = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 2, 0);
                int h1621 = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 2, 0);
                int i621 = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 2, 0);
                int j621 = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 2, 0);


                if ((a62 < 15) || (c62 < 15) || (b62 < 15) || (d62 < 15) || (e162 < 15)|| (e62 < 15) || (f62 < 15) || (h162 < 15) || (i62 < 15)||(j62 < 15) || (e621 < 15) || (f621 < 15) || (h1621 < 15) || (i621 < 15) || (j621 < 15) || (a62z < 15) || (b62z < 15) || (c62z < 15) || (d62z < 15) || (e62z < 15) || (a62z1 < 15)|| (b62z1 < 15) || (c62z1 < 15) || (d62z1 < 15) || (e62z1 < 15)) 
{
                    a4 = 1;
                    // System.out.println(a4 + " " + "first");
                } else {
                    a4 = 0;
                    //  System.out.println(a4 + " " + "first");
                }
///-----------------------------------------------------------------------------------------------------------
                              int a2111 = raster.getSample(bv.calibration_x, bv.calibration_y +17, 0);
                int b2111 = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 17, 0);
                int c2111 = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 17, 0);
                int d2111 = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 17, 0);
                int e2111 = raster.getSample(bv.calibration_x + 4, bv.calibration_y + 17, 0);
                
                int a211 = raster.getSample(bv.calibration_x, bv.calibration_y + 18, 0);
                int b211 = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 18, 0);
                int c211 = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 18, 0);
                int d211 = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 18, 0);
                int e211 = raster.getSample(bv.calibration_x + 4, bv.calibration_y + 18, 0);
                
                int a2 = raster.getSample(bv.calibration_x, bv.calibration_y + 19, 0);
                int b2 = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 19, 0);
                int c2 = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 19, 0);
                int d2 = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 19, 0);
                int e2 = raster.getSample(bv.calibration_x + 4, bv.calibration_y + 19, 0);

                int a3 = raster.getSample(bv.calibration_x, bv.calibration_y + 20, 0);
                int b3 = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 20, 0);
                int c3 = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 20, 0);
                int d3 = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 20, 0);
                int e3 = raster.getSample(bv.calibration_x + 4, bv.calibration_y + 20, 0);
                
                int a2112 = raster.getSample(bv.calibration_x, bv.calibration_y + 21, 0);
                int b2112 = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 21, 0);
                int c2112 = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 21, 0);
                int d2112 = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 21, 0);
                int e2112 = raster.getSample(bv.calibration_x + 4, bv.calibration_y + 21, 0);

                if ((a2 < 15) || (c2 < 15) || (b2 < 15) || (d2 < 15)|| (e2 < 15) || (a3 < 15) || (b3 < 15) || (c3 < 15) || (d3 < 15)|| (e3 < 15)|| (a2112 < 15) || (b2112 < 15) || (c2112 < 15) || (d2112 < 15)|| (e2112 < 15)|| (a2111 < 15) || (b2112 < 15) || (c2111 < 15) || (d2111 < 15)|| (e2111 < 15)|| (a211 < 15) || (b211 < 15) || (c211 < 15) || (d211 < 15)|| (e211 < 15)) 
 {
                    b4 = 1;
                    //  System.out.println(b4 + " " + "second");
                } else {
                    b4 = 0;
                    //   System.out.println(b4 + " " + "second");
                }
///-----------------------------------------------------------------------------------------------------------
                int e122 = raster.getSample(bv.calibration_x, bv.calibration_y + 37, 0);
                int e242 = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 37, 0);
                int e112 = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 37, 0);
                int e342 = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 37, 0);
               
                 int e12d = raster.getSample(bv.calibration_x, bv.calibration_y + 36, 0);
                int e24d = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 36, 0);
                int e11d = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 36, 0);
                int e34d = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 36, 0);
                
                int e12 = raster.getSample(bv.calibration_x, bv.calibration_y + 38, 0);
                int e24 = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 38, 0);
                int e11 = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 38, 0);
                int e34 = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 38, 0);                //System.out.println((x+20)+" "+y);

                int e123 = raster.getSample(bv.calibration_x, bv.calibration_y + 39, 0);
                int e43 = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 39, 0);
                int e13 = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 39, 0);
                int e5 = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 39, 0);
                
                int e1234 = raster.getSample(bv.calibration_x, bv.calibration_y + 40, 0);
                int e434 = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 40, 0);
                int e134 = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 40, 0);
                int e54 = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 40, 0);

                if ((e12 < 15) || (e24 < 15) || (e11 < 15) || (e34 < 15) || (e123 < 15) || (e43 < 15) || (e13 < 15) || (e5 < 15) || (e1234 < 15) || (e434 < 15) || (e134 < 15) || (e54 < 15) || (e122 < 15) || (e242 < 15) || ( e112 < 15) || ( e342 < 15) || (e12d < 15) || (e24d < 15) || (e11d < 15) || (e34d < 15))
{

                    c4 = 1;
                    //   System.out.println(c4 + " " + "third");

                } else {
                    c4 = 0;
                    //  System.out.println(c4 + " " + "third");

                }
///-----------------------------------------------------------------------------------------------------------
                int a51 = raster.getSample(bv.calibration_x + 19, bv.calibration_y-1, 0);
                int b51 = raster.getSample(bv.calibration_x + 20, bv.calibration_y-1, 0);
                int c51 = raster.getSample(bv.calibration_x + 21, bv.calibration_y-1, 0);
                int d51 = raster.getSample(bv.calibration_x + 22, bv.calibration_y-1, 0);
                
                 int a41 = raster.getSample(bv.calibration_x + 19, bv.calibration_y-2, 0);
                int b41 = raster.getSample(bv.calibration_x + 20, bv.calibration_y-2, 0);
                int c41 = raster.getSample(bv.calibration_x + 21, bv.calibration_y-2, 0);
                int d41 = raster.getSample(bv.calibration_x + 22, bv.calibration_y-2, 0);
                
                int a1 = raster.getSample(bv.calibration_x + 19, bv.calibration_y, 0);
                int b1 = raster.getSample(bv.calibration_x + 20, bv.calibration_y, 0);
                int c1 = raster.getSample(bv.calibration_x + 21, bv.calibration_y, 0);
                int d1 = raster.getSample(bv.calibration_x + 22, bv.calibration_y, 0);

                int e1 = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 1, 0);
                int f1 = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 1, 0);
                int h11 = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 1, 0);
                int i1 = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 1, 0);
                
                 int a1g = raster.getSample(bv.calibration_x + 19, bv.calibration_y+2, 0);
                int b1g = raster.getSample(bv.calibration_x + 20, bv.calibration_y+2, 0);
                int c1g = raster.getSample(bv.calibration_x + 21, bv.calibration_y+2, 0);
                int d1g = raster.getSample(bv.calibration_x + 22, bv.calibration_y+2, 0);

                if ((a1 < 15) || (c1 < 15) || (b1 < 15) || (d1 < 15) || (e1 < 15) || (f1 < 15) || (h11 < 15) || (i1 < 15)|| (a1g < 15) || (c1g < 15) || (b1g < 15) || (d1g < 15)||(a51 < 15) || (c51 < 15) || (b51 < 15) || (d51 < 15)||(a41 < 15) || (c41 < 15) || (b41 < 15) || (d41 < 15)) 
 {

                    d4 = 1;
                    //   System.out.println(d4 + " " + "fourth");

                } else {
                    d4 = 0;
                    //   System.out.println(d4 + " " + "fourth");

                }
///-----------------------------------------------------------------------------------------------------------
                int a2u1 = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 17, 0);
                int b2u1 = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 17, 0);
                int c2u1 = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 17, 0);
                int d2u1 = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 17, 0);
                
                  int a2b1 = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 18, 0);
                int b2b1 = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 18, 0);
                int c2b1 = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 18, 0);
                int d2b1 = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 18, 0);
                
                
                int a21 = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 19, 0);
                int b21 = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 19, 0);
                int c21 = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 19, 0);
                int d21 = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 19, 0);

                int e41 = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 20, 0);
                int f41 = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 20, 0);
                int h41 = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 20, 0);
                int i41 = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 20, 0);
                
                int a21v = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 21, 0);
                int b21v = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 21, 0);
                int c21v = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 21, 0);
                int d21v = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 21, 0);

                if ((a21 < 15) || (c21 < 15) || (b21 < 15) || (d21 < 15) || (e41 < 15) || (f41 < 15) || (h41 < 15) || (i41 < 15)||(a21v < 15) || (c21v < 15) || (b21v < 15) || (d21v < 15)||(a2u1 < 15) || (c2u1 < 15) || (b2u1 < 15) || (d2u1 < 15)||(a2b1 < 15) || (c2b1 < 15) || (b2b1 < 15) || (d2b1 < 15))
{

                    e4 = 1;
                    //  System.out.println(e4 + " " + "fifth");

                } else {
                    e4 = 0;
                    //  System.out.println(e4 + " " + "fifth");

                }
///-----------------------------------------------------------------------------------------------------------
                int f11v = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 36, 0);
                int f2v = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 36, 0);
                int f3v = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 36, 0);
                int f413v = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 36, 0);
                
                int f11u = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 37, 0);
                int f2u = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 37, 0);
                int f3u = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 37, 0);
                int f413u = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 37, 0);
                
                int f11 = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 38, 0);
                int f2 = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 38, 0);
                int f3 = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 38, 0);
                int f413 = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 38, 0);

                int f5 = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 39, 0);
                int f6 = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 39, 0);
                int f7 = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 39, 0);
                int f8 = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 39, 0);
                
                int f11f = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 40, 0);
                int f2f = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 40, 0);
                int f3f= raster.getSample(bv.calibration_x + 21, bv.calibration_y + 40, 0);
                int f413f = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 40, 0);
                
                // System.out.println((x+23)+" "+(y+1));

                if ((f11 < 15) || (f2 < 15) || (f3 < 15) || (f413 < 15) || (f5 < 15) || (f6 < 15) || (f7 < 15) || (f8 < 15)||(f11f < 15) || (f2f < 15) || (f3f < 15) || (f413f < 15)||( f11v<15)||( f2v<15)||( f3v<15)||( f413v<15)||( f11u<15)||( f2u<15)||( f3u<15)||( f413u<15))
 {

                    f4 = 1;
                } else {
                    f4 = 0;
                    //  System.out.println(f4 + " " + "sisth");
                }

///-----------------------------------------------------------------------------------------------------------
                String strI = Integer.toString(a4);
                String r = Integer.toString(b4);
                String cd = Integer.toString(c4);
                String I = Integer.toString(d4);
                String st = Integer.toString(e4);
                String rI = Integer.toString(f4);
                String s = strI + r + cd  + I + st + rI;
               System.out.print(s + "=");
                int foo = Integer.valueOf(s);

                int bv1 = bv.getDecimalFromBinary(foo);

                String monthString;
                switch (bv1) {

                    case 32:
                        monthString = "අ";
                        break;
                    case 14:
                        monthString = "ආ";
                        break;
                    case 59:
                        monthString = "ඇ";
                        break;
                    case 55:
                        monthString = "ඈ";
                        break;
                    case 20:
                        monthString = "ඉ";
                        break;
                    case 10:
                        monthString = "ඊ";
                        break;
                    case 41:
                        monthString = "උ";
                        break;
                    case 51:
                        monthString = "ඌ";
                        break;
                    case 34:
                        monthString = "එ";
                        break;
                    case 17:
                        monthString = "ඒ";
                        break;
                    case 12:
                        monthString = "ඓ";
                        break;

                    case 45:
                        monthString = "ඔ";
                        break;
                    case 42:
                        monthString = "ඕ";
                        break;
                    case 21:
                        monthString = "ඖ";
                        break;
                    case 40:
                        monthString = "ක";
                        break;
                    case 5:
                        monthString = "ඛ";
                        break;

                    case 54:
                        monthString = "ග";
                        break;
                    case 49:
                        monthString = "ඝ";
                        break;
                    case 13:
                        monthString = "ඞ";
                        break;

                    case 36:
                        monthString = "ච";
                        break;
                    case 33:
                        monthString = "ඡ";
                        break;
                    case 22:
                        monthString = "ජ";
                        break;
                    case 11:
                        monthString = "ඣ";
                        break;
                    case 18:
                        monthString = "ඤ";
                        break;

                    case 31:
                        monthString = "ට";
                        break;
                    case 23:
                        monthString = "ඨ";
                        break;

                    case 53:
                        monthString = "ඩ";
                        break;
                    case 63:
                        monthString = "ඪ";
                        break;
                    case 43:
                        monthString = "ණ";
                        break;

                    case 30:
                        monthString = "ත";
                        break;
                    case 39:
                        monthString = "ථ";
                        break;
                    case 38:
                        monthString = "ද";
                        break;
                    case 29:
                        monthString = "ධ";
                        break;
                    case 46:
                        monthString = "න";
                        break;
                    case 60:
                        monthString = "ප";
                        break;
                    case 35:
                        monthString = "ඵ";
                        break;
                    case 48:
                        monthString = "බ";
                        break;
                    case 6:
                        monthString = "භ";
                        break;
                    case 44:
                        monthString = "ම";
                        break;
                    case 47:
                        monthString = "ය";
                        break;
                    case 58:
                        monthString = "ර";
                        break;
                    case 56:
                        monthString = "ල";
                        break;
                    case 7:
                        monthString = "ළ";
                        break;
                    case 57:
                        monthString = "ව";
                        break;
                    case 61:
                        monthString = "ශ";
                        break;
                    case 37:
                        monthString = "ෂ";
                        break;
                    case 28:
                        monthString = "ස";
                        break;
                    case 50:
                        monthString = "හ";
                        break;

                    case 62:
                        monthString = "ඥ";
                        break;
                    case 52:
                        monthString = "ෆ";
                        break;
                    case 4:
                        monthString = "'";
                        break;
                    case 8:
                        monthString = "අං";
                        break;
                    // case 8:  monthString = "අඃ";
                    //   break;
                    case 0:
                        monthString = " ";
                        break;
                    case 15:
                        monthString = "#";
                        break;
                    case 19:
                        monthString = ".";
                        break;
                    case 25:
                        monthString = "?";
                        break;
                    case 26:
                        monthString = "!";
                        break;

                    //  case 8:  monthString = " ` ";
                    //  break;
                    case 27:
                        monthString = "( )";
                        break;
                    // case 57:  monthString = " " ";
                    //break;
                    // case 15:  monthString = " " ";
                    // break;
                    case 16:
                        monthString = "’";
                        break;
                    case 3:
                        monthString = "g";
                        break;

                    default:
                        monthString = "Invalid month";
                        break;
                }
                System.out.println(monthString);
                
                
                
               //  char[] myChar = monthString.toCharArray();
                 
            }
        } catch (Exception er) {
            System.out.println(er.toString());
            
        }
    }
}
