/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author Sewwandi
 */
public class November5if {

    public int calibration_x = 0, calibration_y = 0, x, y;
    boolean isa_vowel = false;
    boolean isa_constance = false;
    boolean need_to_join = false;
    
    boolean  dot4 = false;
    boolean others = false;
    boolean g = false;
    
    
    char letter = ' ';
    String vowelChar = "", constChar = "", combinChar = "", numChar = "", punchChar = "";

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

                        int af0 = raster.getSample(x, y - 4, 0);
                        int bf0 = raster.getSample(x + 1, y - 4, 0);
                        int cf0 = raster.getSample(x + 2, y - 4, 0);
                        int df0 = raster.getSample(x + 3, y - 4, 0);
                        int ef0 = raster.getSample(x + 4, y - 4, 0);

                        int an01 = raster.getSample(x, y - 3, 0);
                        int bn01 = raster.getSample(x + 1, y - 3, 0);
                        int cn01 = raster.getSample(x + 2, y - 3, 0);
                        int dn01 = raster.getSample(x + 3, y - 3, 0);
                        int en01 = raster.getSample(x + 4, y - 3, 0);

                        int af = raster.getSample(x, y - 2, 0);
                        int bf = raster.getSample(x + 1, y - 2, 0);
                        int cf = raster.getSample(x + 2, y - 2, 0);
                        int df = raster.getSample(x + 3, y - 2, 0);
                        int ef = raster.getSample(x + 4, y - 2, 0);

                        int an = raster.getSample(x, y - 1, 0);
                        int bn = raster.getSample(x + 1, y - 1, 0);
                        int cn = raster.getSample(x + 2, y - 1, 0);
                        int dn = raster.getSample(x + 3, y - 1, 0);
                        int en = raster.getSample(x + 4, y - 1, 0);

                        int a = raster.getSample(x, y, 0);
                        int b = raster.getSample(x + 1, y, 0);
                        int c = raster.getSample(x + 2, y, 0);
                        int d = raster.getSample(x + 3, y, 0);
                        int eo = raster.getSample(x + 4, y, 0);

                        int e = raster.getSample(x, y + 1, 0);
                        int f = raster.getSample(x + 1, y + 1, 0);
                        int h1 = raster.getSample(x + 2, y + 1, 0);
                        int i = raster.getSample(x + 3, y + 1, 0);
                        int kl = raster.getSample(x + 4, y + 1, 0);

                        int eh = raster.getSample(x, y + 2, 0);
                        int fh = raster.getSample(x + 1, y + 2, 0);
                        int h1h = raster.getSample(x + 2, y + 2, 0);
                        int ih = raster.getSample(x + 3, y + 2, 0);
                        int nn = raster.getSample(x + 4, y + 2, 0);

                        int e0 = raster.getSample(x, y + 3, 0);
                        int f0 = raster.getSample(x + 1, y + 3, 0);
                        int h10 = raster.getSample(x + 2, y + 3, 0);
                        int i0 = raster.getSample(x + 3, y + 3, 0);
                        int kl0 = raster.getSample(x + 4, y + 3, 0);

                        int eh01 = raster.getSample(x, y + 4, 0);
                        int fh01 = raster.getSample(x + 1, y + 4, 0);
                        int h1h01 = raster.getSample(x + 2, y + 4, 0);
                        int ih01 = raster.getSample(x + 3, y + 4, 0);
                        int nn01 = raster.getSample(x + 4, y + 4, 0);

                        //------
                        int a5 = raster.getSample(x, y, 0);
                        int b5 = raster.getSample(x - 1, y, 0);
                        int c5 = raster.getSample(x - 2, y, 0);
                        int d5 = raster.getSample(x - 3, y, 0);
                        int eo5 = raster.getSample(x - 4, y, 0);

                        int e5 = raster.getSample(x, y + 1, 0);
                        int f5 = raster.getSample(x - 1, y + 1, 0);
                        int h15 = raster.getSample(x - 2, y + 1, 0);
                        int i5 = raster.getSample(x - 3, y + 1, 0);
                        int kl5 = raster.getSample(x - 4, y + 1, 0);

                        if ((a5 < 15) || (c5 < 15) || (b5 < 15) || (d5 < 15) || (e5 < 15) || (eo5 < 15) || (f5 < 15) || (h15 < 15) || (i5 < 15) || (kl5 < 15) || (nn01 < 15) || (ih01 < 15) || (h1h01 < 15) || (fh01 < 15) || (eh01 < 15) || (kl0 < 15) || (i0 < 15) || (h10 < 15) || (f0 < 15) || (e0 < 15) || (nn < 15) || (ih < 15) || (h1h < 15) || (fh < 15) || (eh < 15) || (a < 15) || (c < 15) || (b < 15) || (d < 15) || (e < 15) || (eo < 15) || (f < 15) || (h1 < 15) || (i < 15) || (af < 15) || (cf < 15) || (bf < 15) || (df < 15) || (ef < 15) || (an < 15) || (bn < 15) || (cn < 15) || (af0 < 15) || (cf0 < 15) || (bf0 < 15) || (df0 < 15) || (ef0 < 15) || (an01 < 15) || (kl < 15) || (bn01 < 15) || (cn01 < 15) || (dn < 15) || (en < 15) || (dn01 < 15) || (en01 < 15)) {
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

    public void printCharacter(int value) {

        
        
        switch (value) {
       
            
            case 32:
                vowelChar = "අ"; 
                isa_vowel = true;
                break;
            case 14: 
                vowelChar = "ආ";
                isa_vowel = true;
                break;
            case 59:
                vowelChar = "ඇ";
                isa_vowel = true;
                break;
            case 55:
                vowelChar = "ඈ";
                isa_vowel = true;
                break;
            case 20:
                vowelChar = "ඉ";
                isa_vowel = true;
                break;
            case 10:
                vowelChar = "ඊ";
                isa_vowel = true;
                break;
            case 41:
                vowelChar = "උ ";
                isa_vowel = true;
                break;
            case 51:
                vowelChar = "ඌ";
                isa_vowel = true;
                break;
            case 34:
                vowelChar = "එ";
                isa_vowel = true;
                break;
            case 17:
                vowelChar = "ඒ";
                isa_vowel = true;
                break;
            case 12:
                vowelChar = "ඓ";
                isa_vowel = true;
                break;
            case 45:
                vowelChar = "ඔ";
                isa_vowel = true;
                break;
            case 42:
                vowelChar = "ඕ";
                isa_vowel = true;
                break;
            case 21:
                vowelChar = "ඖ";
                isa_vowel = true;
                break;

            case 4:
                vowelChar   = "්";
                isa_vowel= true;
                break;
                
                
            //=============================
                
                   
                
            case 40:
                constChar = "ක";
                isa_constance = true;
                break;
            case 5:
                constChar = "ඛ";
                isa_constance = true;
                break;

            case 54:
                constChar = "ග";
                isa_constance = true;
                break;
            case 49:
                constChar = "ඝ";
                isa_constance = true;
                break;
            case 13:
                constChar = "ඞ";
                isa_constance = true;
                break;

            case 36:
                constChar = "ච";
                isa_constance = true;
                break;
            case 33:
                constChar = "ඡ";
                isa_constance = true;
                break;
            case 22:
                constChar = "ජ";
                isa_constance = true;
                break;
            case 11:
                constChar = "ඣ";
                isa_constance = true;
                break;
            case 18:
                constChar = "ඤ";
                isa_constance = true;
                break;

            case 31:
                constChar = "ට";
                isa_constance = true;
                break;
            case 23:
                constChar = "ඨ";
                isa_constance = true;
                break;

            case 53:
                constChar = "ඩ";
                isa_constance = true;
                break;
            case 63:
                constChar = "ඪ";
                isa_constance = true;
                break;
            case 43:
                constChar = "ණ";
                isa_constance = true;
                break;

            case 30:
                constChar = "ත";
                isa_constance = true;
                break;
            case 39:
                constChar = "ථ";
                isa_constance = true;
                break;
            case 38:
                constChar = "ද";
                isa_constance = true;
                break;
            case 29:
                constChar = "ධ";
                isa_constance = true;
                break;
            case 46:
                constChar = "න";
                isa_constance = true;
                break;
            case 60:
                constChar = "ප";
                isa_constance = true;
                break;
            case 35:
                constChar = "ඵ";
                isa_constance = true;
                break;
            case 48:
                constChar = "බ";
                isa_constance = true;
                break;
            case 6:
                constChar = "භ";
                isa_constance = true;
                break;
            case 44:
                constChar = "ම";
                isa_constance = true;
                break;
            case 47:
                constChar = "ය";
                isa_constance = true;
                break;
            case 58:
                constChar = "ර";
                isa_constance = true;
                break;
            case 56:
                constChar = "ල";
                isa_constance = true;
                break;
            case 7:
                constChar = "ළ";
                isa_constance = true;
                break;
            case 57:
                constChar = "ව";
                isa_constance = true;
                break;
            case 61:
                constChar = "ශ";
                isa_constance = true;
                break;
            case 37:
                constChar = "ෂ";
                isa_constance = true;
                break;
            case 28:
                constChar = "ස";
                isa_constance = true;
                break;
            case 50:
                constChar = "හ";
                isa_constance = true;
                break;

            case 62:
                constChar = "ඥ";
                isa_constance = true;
                break;
            case 52:
                constChar = "ෆ";
                isa_constance = true;
                break;
           
            case 8:
                constChar = "ං";
                isa_constance = true;
                break;
            // case 8:  constChar = "අඃ";
            // break;
            case 0:
                constChar = " ";
                isa_constance = true;
                break;
            case 15:
                constChar = "#";
                isa_constance = true;
                break;
            case 19:
                constChar = ".";
                isa_constance = true;
                break;
            case 25:
                constChar = "?";
                isa_constance = true;
                break;
            case 26:
                constChar = "!";
                isa_constance = true;
                break;

            //  case 8:  monthString = " ` ";
            //  break;
            case 27:
                constChar = "( )";
                isa_constance = true;
                break;
                
                 
                
            // case 57:  monthString = " " ";
            //break;
            // case 15:  monthString = " " ";
            // break;
//            case 16:
//                constChar = " ’ ";
//                isa_constance = true;
//                break;
//            case 3:
//                constChar = "g";
//                isa_constance = true;
//                break;

        }
        
        if(dot4 = true){
            
            
            others=  false;
        }
        
      
        if (isa_vowel ) {
        
            
            if (need_to_join) {

                switch (value) {

        ///   case 32:
                    //   vowelChar = "අ";
                    //   isa_vowel = true;
                    //    break;
                    case 14:
                        vowelChar = "ා";
                        isa_vowel = true;
                        break;
                    case 59:
                        vowelChar = "ැ";
                        isa_vowel = true;
                        break;
                    case 55:
                        vowelChar = "ෑ";
                        isa_vowel = true;
                        break;
                    case 20:
                        vowelChar = "ි";
                        isa_vowel = true;
                        break;
                    case 10:
                        vowelChar = "ී";
                        isa_vowel = true;
                        break;
                    case 41:
                        vowelChar = "ු";
                        isa_vowel = true;
                        break;
                    case 51:
                        vowelChar = "ූ";
                        isa_vowel = true;
                        break;
                    case 34:
                        vowelChar = "ෙ";
                        isa_vowel = true;
                        break;
                    case 17:
                        vowelChar = "ේ";
                        isa_vowel = true;
                        break;
                    case 12:
                        vowelChar = " ෛ";
                        isa_vowel = true;
                        break;
                    case 45:
                        vowelChar = "ො";
                        isa_vowel = true;
                        break;
                    case 42:
                        vowelChar = "ෝ";
                        isa_vowel = true;
                        break;
                    case 21:
                        vowelChar = "ෟ";
                        isa_vowel = true;
                        break;

                        
                        
      //numbers=======================      
//                 case 22:
//                constChar = "0";
//                isa_constance = true;
//                break;
//                
//                case 32:
//                constChar = "1";
//                isa_constance = true;
//                break;
//               
//                case 48:
//                constChar = "2";
//                isa_constance = true;
//                break;
//                    
//                case 36:
//                constChar = "3";
//                isa_constance = true;
//                break;
//            
//               case 38:
//                constChar = "4";
//                isa_constance = true;
//                break;
//                case 34:
//                constChar = "5";
//                isa_constance = true;
//                break;
               //  case 52:
//                constChar = "6";
//                isa_constance = true;
//                break;
                   //  case 54:
//                constChar = "7";
//                isa_constance = true;
//                break;
     //                case 50:
//                constChar = "8";
//                isa_constance = true;
//                break;
                   //     case 20:
//                constChar = "9";
//                isa_constance = true;
//                break;
          
                        
                        
                }
                
                System.out.print(vowelChar);
                 //     isa_vowel=true;
                // cout<<letter;
      
                need_to_join = false;
  
            } else {
              System.out.print(vowelChar);

                // cout<<letter;
            }
            isa_vowel = false;
            
        } else if (isa_constance) {
            System.out.print(constChar);
          
                         
            
//   cout<<letter;
            need_to_join = true;
            isa_constance = false;
      

                    
        
  
        }
    }
    
    
     public void printSpecialCharacter(int value) {
         
         
         
     }

         //   System.out.println(vowelChar);
    //  isa_vowel = false;
    //    } 
    //   else
    //    {
    //      System.out.println(constChar);
    //      isa_constance = false;
    // }
 //   }
    /*  public void printCharacter(int value) {

     if (!isa_constance) {
     switch (value) {
     case 32:
     vowelChar = "අ";
     isa_vowel = true;
     break;
     case 14:
     vowelChar = "ආ";
     isa_vowel = true;
     break;
     case 59:
     vowelChar = "ඇ";
     isa_vowel = true;
     break;
     case 55:
     vowelChar = "ඈ";
     isa_vowel = true;
     break;
     case 20:
     vowelChar = "ඉ";
     isa_vowel = true;
     break;
     case 10:
     vowelChar = "ඊ";
     isa_vowel = true;
     break;
     case 41:
     vowelChar = "උ ";
     isa_vowel = true;
     break;
     case 51:
     vowelChar = "ඌ";
     isa_vowel = true;
     break;
     case 34:
     vowelChar = "එ";
     isa_vowel = true;
     break;
     case 17:
     vowelChar = "ඒ";
     isa_vowel = true;
     break;
     case 12:
     vowelChar = " ඓ ";
     isa_vowel = true;
     break;
     case 45:
     vowelChar = "ඔ";
     isa_vowel = true;
     break;
     case 42:
     vowelChar = "ඕ";
     isa_vowel = true;
     break;
     case 21:
     vowelChar = "ඖ ";
     isa_vowel = true;
     break;
     }

     isa_constance = false;
     System.out.println(vowelChar);
     }
     else 
     {
     switch (value) {
     case 14:
     vowelChar = "ා";
     isa_vowel = true;
     break;
     case 1400:
     vowelChar = "්";
     isa_vowel = true;
     break;
     case 5900:
     vowelChar = "ැ";
     isa_vowel = true;
     break;
     case 5500:
     vowelChar = "ෑ";
     isa_vowel = true;
     break;
     case 2000:
     vowelChar = "ි";
     isa_vowel = true;
     break;
     case 1000:
     vowelChar = "ී";
     isa_vowel = true;
     break;
     case 4100:
     vowelChar = "ු ";
     isa_vowel = true;
     break;
     case 5100:
     vowelChar = "ූ";
     isa_vowel = true;
     break;
     case 3400:
     vowelChar = "ෘ";
     isa_vowel = true;
     break;
     case 1700:
     vowelChar = "ෙ";
     isa_vowel = true;
     break;
     case 1200:
     vowelChar = " ේ ";
     isa_vowel = true;
     break;
     case 4500:
     vowelChar = "ෛ";
     isa_vowel = true;
     break;
     case 4200:
     vowelChar = "ො";
     isa_vowel = true;
     break;
     case 2100:
     vowelChar = "ෝ ";
     isa_vowel = true;
     break;
     }

     isa_constance = false;
     System.out.println(vowelChar);
     }

     //==============================
     if (!isa_vowel) {

     switch (value) {
     case 40:
     constChar = "ක";
     isa_constance = true;
     break;
     case 5:
     constChar = "ඛ";
     isa_constance = true;
     break;

     case 54:
     constChar = "ග ";
     isa_constance = true;
     break;
     case 49:
     constChar = "ඝ";
     isa_constance = true;
     break;
     case 13:
     constChar = "ඞ";
     isa_constance = true;
     break;

     case 36:
     constChar = "ච";
     isa_constance = true;
     break;
     case 33:
     constChar = "ඡ";
     isa_constance = true;
     break;
     case 22:
     constChar = "ජ";
     isa_constance = true;
     break;
     case 11:
     constChar = "ඣ";
     isa_constance = true;
     break;
     case 18:
     constChar = "ඤ";
     isa_constance = true;
     break;

     case 31:
     constChar = "ට";
     isa_constance = true;
     break;
     case 23:
     constChar = "ඨ";
     isa_constance = true;
     break;

     case 53:
     constChar = "ඩ";
     isa_constance = true;
     break;
     case 63:
     constChar = "ඪ";
     isa_constance = true;
     break;
     case 43:
     constChar = "ණ";
     isa_constance = true;
     break;

     case 30:
     constChar = "ත";
     isa_constance = true;
     break;
     case 39:
     constChar = "ථ";
     isa_constance = true;
     break;
     case 38:
     constChar = "ද";
     isa_constance = true;
     break;
     case 29:
     constChar = "ධ";
     isa_constance = true;
     break;
     case 46:
     constChar = "න";
     isa_constance = true;
     break;
     case 60:
     constChar = "ප";
     isa_constance = true;
     break;
     case 35:
     constChar = " ඵ";
     isa_constance = true;
     break;
     case 48:
     constChar = " බ";
     isa_constance = true;
     break;
     case 6:
     constChar = "භ";
     isa_constance = true;
     break;
     case 44:
     constChar = "ම";
     isa_constance = true;
     break;
     case 47:
     constChar = "ය";
     isa_constance = true;
     break;
     case 58:
     constChar = "ර";
     isa_constance = true;
     break;
     case 56:
     constChar = "ල";
     isa_constance = true;
     break;
     case 7:
     constChar = "ළ";
     isa_constance = true;
     break;
     case 57:
     constChar = "ව";
     isa_constance = true;
     break;
     case 61:
     constChar = "ශ";
     isa_constance = true;
     break;
     case 37:
     constChar = "ෂ";
     isa_constance = true;
     break;
     case 28:
     constChar = "ස";
     isa_constance = true;
     break;
     case 50:
     constChar = "හ";
     isa_constance = true;
     break;

     case 62:
     constChar = "ඥ";
     isa_constance = true;
     break;
     case 52:
     constChar = "ෆ";
     isa_constance = true;
     break;
     case 4:
     constChar = " ' ";
     isa_constance = true;
     break;
     case 8:
     constChar = "අං";
     isa_constance = true;
     break;
     // case 8:  constChar = "අඃ";
     // break;
     case 0:
     constChar = " ";
     isa_constance = true;
     break;
     case 15:
     constChar = "#";
     isa_constance = true;
     break;
     case 19:
     constChar = ".";
     isa_constance = true;
     break;
     case 25:
     constChar = "?";
     isa_constance = true;
     break;
     case 26:
     constChar = "!";
     isa_constance = true;
     break;

     //  case 8:  monthString = " ` ";
     //  break;
     case 27:
     constChar = "( )";
     isa_constance = true;
     break;
     // case 57:  monthString = " " ";
     //break;
     // case 15:  monthString = " " ";
     // break;
     case 16:
     constChar = " ’ ";
     isa_constance = true;
     break;
     case 3:
     constChar = " g";
     isa_constance = true;
     break;

           
     }

     isa_vowel = false;
     System.out.println(constChar);
     }
     }
     */
    public static void main(String[] args) {

        try {
            int a4 = 0, b4 = 0, c4 = 0, d4 = 0, e4 = 0, f4 = 0;

            Brows bv = new Brows();
            bv.calibration();

            November5if tst = new November5if();
            // System.out.println(bv.calibration_x + "  " + bv.calibration_y);

            int bv1 = 0;

            for (int z = 0; z < 319; z++) {
                String name = Integer.toString(z) + ".png";

                File input = new File(name);

                BufferedImage image = ImageIO.read(input);
                Raster raster = image.getData();
                int w = image.getWidth();
                int h = image.getHeight();

                //  Raster raster = image.getData();
                int dataBuffInt;

                int a62z01 = raster.getSample(bv.calibration_x, bv.calibration_y - 4, 0);
                int b62z01 = raster.getSample(bv.calibration_x + 1, bv.calibration_y - 4, 0);
                int c62z01 = raster.getSample(bv.calibration_x + 2, bv.calibration_y - 4, 0);
                int d62z01 = raster.getSample(bv.calibration_x + 3, bv.calibration_y - 4, 0);
                int e62z01 = raster.getSample(bv.calibration_x + 4, bv.calibration_y - 4, 0);

                int a62z0 = raster.getSample(bv.calibration_x, bv.calibration_y - 3, 0);
                int b62z0 = raster.getSample(bv.calibration_x + 1, bv.calibration_y - 3, 0);
                int c62z0 = raster.getSample(bv.calibration_x + 2, bv.calibration_y - 3, 0);
                int d62z0 = raster.getSample(bv.calibration_x + 3, bv.calibration_y - 3, 0);
                int e62z0 = raster.getSample(bv.calibration_x + 4, bv.calibration_y - 3, 0);

                int a62z = raster.getSample(bv.calibration_x, bv.calibration_y - 2, 0);
                int b62z = raster.getSample(bv.calibration_x + 1, bv.calibration_y - 2, 0);
                int c62z = raster.getSample(bv.calibration_x + 2, bv.calibration_y - 2, 0);
                int d62z = raster.getSample(bv.calibration_x + 3, bv.calibration_y - 2, 0);
                int e62z = raster.getSample(bv.calibration_x + 4, bv.calibration_y - 2, 0);

                int a62z1 = raster.getSample(bv.calibration_x, bv.calibration_y - 1, 0);
                int b62z1 = raster.getSample(bv.calibration_x + 1, bv.calibration_y - 1, 0);
                int c62z1 = raster.getSample(bv.calibration_x + 2, bv.calibration_y - 1, 0);
                int d62z1 = raster.getSample(bv.calibration_x + 3, bv.calibration_y - 1, 0);
                int e62z1 = raster.getSample(bv.calibration_x + 4, bv.calibration_y - 1, 0);

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

                int e620 = raster.getSample(bv.calibration_x, bv.calibration_y + 3, 0);
                int f620 = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 3, 0);
                int h1620 = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 3, 0);
                int i620 = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 3, 0);
                int j620 = raster.getSample(bv.calibration_x + 4, bv.calibration_y + 3, 0);

                int e62101 = raster.getSample(bv.calibration_x, bv.calibration_y + 4, 0);
                int f62101 = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 4, 0);
                int h162101 = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 4, 0);
                int i62101 = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 4, 0);
                int j62101 = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 4, 0);

                //--------------
                int a625 = raster.getSample(bv.calibration_x, bv.calibration_y, 0);
                int b625 = raster.getSample(bv.calibration_x - 1, bv.calibration_y, 0);
                int c625 = raster.getSample(bv.calibration_x - 2, bv.calibration_y, 0);
                int d625 = raster.getSample(bv.calibration_x - 3, bv.calibration_y, 0);
                int e1625 = raster.getSample(bv.calibration_x - 4, bv.calibration_y, 0);

                int e625 = raster.getSample(bv.calibration_x, bv.calibration_y + 1, 0);
                int f625 = raster.getSample(bv.calibration_x - 1, bv.calibration_y + 1, 0);
                int h1625 = raster.getSample(bv.calibration_x - 2, bv.calibration_y + 1, 0);
                int i625 = raster.getSample(bv.calibration_x - 3, bv.calibration_y + 1, 0);
                int j625 = raster.getSample(bv.calibration_x - 4, bv.calibration_y + 1, 0);

                if ((e1625 < 15) || (d625 < 15) || (c625 < 15) || (b625 < 15) || (a625 < 15) || (a625 < 15) || (c625 < 15) || (b625 < 15) || (d625 < 15) || (e1625 < 15) || (e625 < 15) || (f625 < 15) || (h1625 < 15) || (i625 < 15) || (j625 < 15) || (j62101 < 15) || (i62101 < 15) || (h162101 < 15) || (f62101 < 15) || (e62101 < 15) || (j620 < 15) || (i620 < 15) || (h1620 < 15) || (f620 < 15) || (e620 < 15) || (j621 < 15) || (e162 < 15) || (d62 < 15) || (c62 < 15) || (b62 < 15) || (a62 < 15) || (e62z0 < 15) || (d62z0 < 15) || (c62z0 < 15) || (b62z0 < 15) || (a62z0 < 15) || (e62z01 < 15) || (d62z01 < 15) || (c62z01 < 15) || (b62z01 < 15) || (a62z01 < 15) || (a62 < 15) || (c62 < 15) || (b62 < 15) || (d62 < 15) || (e162 < 15) || (e62 < 15) || (f62 < 15) || (h162 < 15) || (i62 < 15) || (j62 < 15) || (e621 < 15) || (f621 < 15) || (h1621 < 15) || (i621 < 15) || (j621 < 15) || (a62z < 15) || (b62z < 15) || (c62z < 15) || (d62z < 15) || (e62z < 15) || (a62z1 < 15) || (b62z1 < 15) || (c62z1 < 15) || (d62z1 < 15) || (e62z1 < 15)) {
                    a4 = 1;
                    // System.out.println(a4 + " " + "first");
                } else {
                    a4 = 0;
                    //  System.out.println(a4 + " " + "first");
                }
///-----------------------------------------------------------------------------------------------------------

                int a21112 = raster.getSample(bv.calibration_x, bv.calibration_y + 15, 0);
                int b21112 = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 15, 0);
                int c21112 = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 15, 0);
                int d21112 = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 15, 0);
                int e21112 = raster.getSample(bv.calibration_x + 4, bv.calibration_y + 15, 0);

                int a21110 = raster.getSample(bv.calibration_x, bv.calibration_y + 16, 0);
                int b21110 = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 16, 0);
                int c21110 = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 16, 0);
                int d21110 = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 16, 0);
                int e21110 = raster.getSample(bv.calibration_x + 4, bv.calibration_y + 16, 0);

                int a2111 = raster.getSample(bv.calibration_x, bv.calibration_y + 17, 0);
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

                int a21113 = raster.getSample(bv.calibration_x, bv.calibration_y + 22, 0);
                int b21113 = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 22, 0);
                int c21113 = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 22, 0);
                int d21113 = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 22, 0);
                int e21113 = raster.getSample(bv.calibration_x + 4, bv.calibration_y + 22, 0);

                int a21114 = raster.getSample(bv.calibration_x, bv.calibration_y + 23, 0);
                int b21114 = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 23, 0);
                int c21114 = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 23, 0);
                int d21114 = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 23, 0);
                int e21114 = raster.getSample(bv.calibration_x + 4, bv.calibration_y + 23, 0);

                //--------------
                if ((a2 < 15) || (c2 < 15) || (b2 < 15) || (d2 < 15) || (e2 < 15) || (a3 < 15) || (b3 < 15) || (c3 < 15) || (d3 < 15) || (e3 < 15) || (a2112 < 15) || (b2112 < 15) || (c2112 < 15) || (d2112 < 15) || (e2112 < 15) || (a2111 < 15) || (b2111 < 15) || (b2112 < 15) || (c2111 < 15) || (d2111 < 15) || (e2111 < 15) || (a211 < 15) || (b211 < 15) || (c211 < 15) || (d211 < 15) || (e211 < 15) || (a21110 < 15) || (b21110 < 15) || (c21110 < 15) || (d21110 < 15) || (e21110 < 15) || (a21112 < 15) || (b21112 < 15) || (c21112 < 15) || (d21112 < 15) || (e21112 < 15) || (a21113 < 15) || (b21113 < 15) || (c21113 < 15) || (d21113 < 15) || (e21113 < 15) || (a21114 < 15) || (b21114 < 15) || (c21114 < 15) || (d21114 < 15) || (e21114 < 15)) {
                    b4 = 1;
                    //  System.out.println(b4 + " " + "second");
                } else {
                    b4 = 0;
                    //   System.out.println(b4 + " " + "second");
                }
///-----------------------------------------------------------------------------------------------------------

                int e122x1 = raster.getSample(bv.calibration_x, bv.calibration_y + 34, 0);
                int e242x1 = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 34, 0);
                int e112x1 = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 34, 0);
                int e342x1 = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 34, 0);
                int e342qx1 = raster.getSample(bv.calibration_x + 4, bv.calibration_y + 34, 0);

                int e122x = raster.getSample(bv.calibration_x, bv.calibration_y + 35, 0);
                int e242x = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 35, 0);
                int e112x = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 35, 0);
                int e342x = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 35, 0);
                int e342qx = raster.getSample(bv.calibration_x + 4, bv.calibration_y + 35, 0);

                int e12d = raster.getSample(bv.calibration_x, bv.calibration_y + 36, 0);
                int e24d = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 36, 0);
                int e11d = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 36, 0);
                int e34d = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 36, 0);
                int e34dq = raster.getSample(bv.calibration_x + 4, bv.calibration_y + 36, 0);

                int e122 = raster.getSample(bv.calibration_x, bv.calibration_y + 37, 0);
                int e242 = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 37, 0);
                int e112 = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 37, 0);
                int e342 = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 37, 0);
                int e342q = raster.getSample(bv.calibration_x + 4, bv.calibration_y + 37, 0);

                int e12 = raster.getSample(bv.calibration_x, bv.calibration_y + 38, 0);
                int e24 = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 38, 0);
                int e11 = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 38, 0);
                int e34 = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 38, 0);
                int e34q = raster.getSample(bv.calibration_x + 4, bv.calibration_y + 38, 0); //System.out.println((x+20)+" "+y);

                int e123 = raster.getSample(bv.calibration_x, bv.calibration_y + 39, 0);
                int e43 = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 39, 0);
                int e13 = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 39, 0);
                int e5 = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 39, 0);
                int e5q = raster.getSample(bv.calibration_x + 4, bv.calibration_y + 39, 0);

                int e1234 = raster.getSample(bv.calibration_x, bv.calibration_y + 40, 0);
                int e434 = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 40, 0);
                int e134 = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 40, 0);
                int e54 = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 40, 0);
                int e54q = raster.getSample(bv.calibration_x + 4, bv.calibration_y + 40, 0);

                int e1234x = raster.getSample(bv.calibration_x, bv.calibration_y + 41, 0);
                int e434x = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 41, 0);
                int e134x = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 41, 0);
                int e54x = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 41, 0);
                int e54qx = raster.getSample(bv.calibration_x + 4, bv.calibration_y + 41, 0);

                int e1234q = raster.getSample(bv.calibration_x, bv.calibration_y + 42, 0);
                int e434q = raster.getSample(bv.calibration_x + 1, bv.calibration_y + 42, 0);
                int e134q = raster.getSample(bv.calibration_x + 2, bv.calibration_y + 42, 0);
                int e54q1 = raster.getSample(bv.calibration_x + 3, bv.calibration_y + 42, 0);
                int e54qq = raster.getSample(bv.calibration_x + 4, bv.calibration_y + 42, 0);

                //-------------
                if ((e122x1 < 15) || (e242x1 < 15) || (e112x1 < 15) || (e342x1 < 15) || (e342qx1 < 15) || (e122x < 15) || (e242x < 15) || (e112x < 15) || (e342x < 15) || (e342qx < 15) || (e1234x < 15) || (e434x < 15) || (e134x < 15) || (e54x < 15) || (e1234q < 15) || (e434q < 15) || (e134q < 15) || (e54q1 < 15) || (e54qq < 15) || (e54qx < 15) || (e54q < 15) || (e5q < 15) || (e34q < 15) || (e342q < 15) || (e34dq < 15) || (e12 < 15) || (e24 < 15) || (e11 < 15) || (e34 < 15) || (e123 < 15) || (e43 < 15) || (e13 < 15) || (e5 < 15) || (e1234 < 15) || (e434 < 15) || (e134 < 15) || (e54 < 15) || (e122 < 15) || (e242 < 15) || (e112 < 15) || (e342 < 15) || (e12d < 15) || (e24d < 15) || (e11d < 15) || (e34d < 15)) {

                    c4 = 1;
                    //   System.out.println(c4 + " " + "third");

                } else {
                    c4 = 0;
                    //  System.out.println(c4 + " " + "third");

                }
///-----------------------------------------------------------------------------------------------------------

                int a51d = raster.getSample(bv.calibration_x + 19, bv.calibration_y - 4, 0);
                int b51d = raster.getSample(bv.calibration_x + 20, bv.calibration_y - 4, 0);
                int c51d = raster.getSample(bv.calibration_x + 21, bv.calibration_y - 4, 0);
                int d51d = raster.getSample(bv.calibration_x + 22, bv.calibration_y - 4, 0);
                int d51qd = raster.getSample(bv.calibration_x + 23, bv.calibration_y - 4, 0);

                int a51c = raster.getSample(bv.calibration_x + 19, bv.calibration_y - 3, 0);
                int b51c = raster.getSample(bv.calibration_x + 20, bv.calibration_y - 3, 0);
                int c51c = raster.getSample(bv.calibration_x + 21, bv.calibration_y - 3, 0);
                int d51c = raster.getSample(bv.calibration_x + 22, bv.calibration_y - 3, 0);
                int d51qc = raster.getSample(bv.calibration_x + 23, bv.calibration_y - 3, 0);

                int a51 = raster.getSample(bv.calibration_x + 19, bv.calibration_y - 1, 0);
                int b51 = raster.getSample(bv.calibration_x + 20, bv.calibration_y - 1, 0);
                int c51 = raster.getSample(bv.calibration_x + 21, bv.calibration_y - 1, 0);
                int d51 = raster.getSample(bv.calibration_x + 22, bv.calibration_y - 1, 0);
                int d51q = raster.getSample(bv.calibration_x + 23, bv.calibration_y - 1, 0);

                int a41 = raster.getSample(bv.calibration_x + 19, bv.calibration_y - 2, 0);
                int b41 = raster.getSample(bv.calibration_x + 20, bv.calibration_y - 2, 0);
                int c41 = raster.getSample(bv.calibration_x + 21, bv.calibration_y - 2, 0);
                int d41 = raster.getSample(bv.calibration_x + 22, bv.calibration_y - 2, 0);
                int d41q = raster.getSample(bv.calibration_x + 23, bv.calibration_y - 2, 0);

                int a1 = raster.getSample(bv.calibration_x + 19, bv.calibration_y, 0);
                int b1 = raster.getSample(bv.calibration_x + 20, bv.calibration_y, 0);
                int c1 = raster.getSample(bv.calibration_x + 21, bv.calibration_y, 0);
                int d1 = raster.getSample(bv.calibration_x + 22, bv.calibration_y, 0);
                int d1q = raster.getSample(bv.calibration_x + 23, bv.calibration_y, 0);

                int e1 = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 1, 0);
                int f1 = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 1, 0);
                int h11 = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 1, 0);
                int i1 = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 1, 0);
                int i1q = raster.getSample(bv.calibration_x + 23, bv.calibration_y + 1, 0);

                int a1g = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 2, 0);
                int b1g = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 2, 0);
                int c1g = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 2, 0);
                int d1g = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 2, 0);
                int d1gq = raster.getSample(bv.calibration_x + 23, bv.calibration_y + 2, 0);

                int e1z = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 3, 0);
                int f1z = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 3, 0);
                int h11z = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 3, 0);
                int i1z = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 3, 0);
                int i1qz = raster.getSample(bv.calibration_x + 23, bv.calibration_y + 3, 0);

                int a1gzz = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 4, 0);
                int b1gzz = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 4, 0);
                int c1gzz = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 4, 0);
                int d1gzz = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 4, 0);
                int d1gqzz = raster.getSample(bv.calibration_x + 23, bv.calibration_y + 4, 0);

                 //---------------------
                if ((e1z < 15) || (f1z < 15) || (h11z < 15) || (i1z < 15) || (i1qz < 15) || (a1gzz < 15) || (b1gzz < 15) || (c1gzz < 15) || (d1gzz < 15) || (d1gqzz < 15) || (d1gq < 15) || (i1q < 15) || (d1q < 15) || (d41q < 15) || (d51q < 15) || (a1 < 15) || (c1 < 15) || (b1 < 15) || (d1 < 15) || (e1 < 15) || (f1 < 15) || (h11 < 15) || (i1 < 15) || (a1g < 15) || (c1g < 15) || (b1g < 15) || (d1g < 15) || (a51 < 15) || (c51 < 15) || (b51 < 15) || (d51 < 15) || (a41 < 15) || (c41 < 15) || (b41 < 15) || (d41 < 15) || (a51c < 15) || (c51c < 15) || (b51c < 15) || (d51c < 15) || (d51qc < 15) || (a51d < 15) || (c51d < 15) || (b51d < 15) || (d51d < 15) || (d51qd < 15)) {

                    d4 = 1;
                    //   System.out.println(d4 + " " + "fourth");

                } else {
                    d4 = 0;
                    //   System.out.println(d4 + " " + "fourth");

                }
///-----------------------------------------------------------------------------------------------------------

                int a2u1o = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 15, 0);
                int b2u1o = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 15, 0);
                int c2u1o = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 15, 0);
                int d2u1o = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 15, 0);
                int e2u1o = raster.getSample(bv.calibration_x + 23, bv.calibration_y + 15, 0);

                int a2u1l = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 16, 0);
                int b2u1l = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 16, 0);
                int c2u1l = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 16, 0);
                int d2u1l = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 16, 0);
                int e2u1l = raster.getSample(bv.calibration_x + 23, bv.calibration_y + 16, 0);

                int a2u1 = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 17, 0);
                int b2u1 = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 17, 0);
                int c2u1 = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 17, 0);
                int d2u1 = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 17, 0);
                int e2u1 = raster.getSample(bv.calibration_x + 23, bv.calibration_y + 17, 0);

                int a2b1 = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 18, 0);
                int b2b1 = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 18, 0);
                int c2b1 = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 18, 0);
                int d2b1 = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 18, 0);
                int e2b1 = raster.getSample(bv.calibration_x + 23, bv.calibration_y + 18, 0);

                int a21 = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 19, 0);
                int b21 = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 19, 0);
                int c21 = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 19, 0);
                int d21 = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 19, 0);
                int e21 = raster.getSample(bv.calibration_x + 23, bv.calibration_y + 19, 0);

                int e41 = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 20, 0);
                int f41 = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 20, 0);
                int h41 = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 20, 0);
                int i41 = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 20, 0);
                int ii41 = raster.getSample(bv.calibration_x + 23, bv.calibration_y + 20, 0);

                int a21v = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 21, 0);
                int b21v = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 21, 0);
                int c21v = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 21, 0);
                int d21v = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 21, 0);
                int e21v = raster.getSample(bv.calibration_x + 23, bv.calibration_y + 21, 0);

                int a21v6 = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 22, 0);
                int b21v6 = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 22, 0);
                int c21v6 = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 22, 0);
                int d21v6 = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 22, 0);
                int e21v6 = raster.getSample(bv.calibration_x + 23, bv.calibration_y + 22, 0);

                int a21v7 = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 23, 0);
                int b21v7 = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 23, 0);
                int c21v7 = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 23, 0);
                int d21v7 = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 23, 0);
                int e21v7 = raster.getSample(bv.calibration_x + 23, bv.calibration_y + 23, 0);

                //---------------------------------
                if ((a2u1o < 15) || (b2u1o < 15) || (c2u1o < 15) || (d2u1o < 15) || (e2u1o < 15) || (a2u1l < 15) || (b2u1l < 15) || (c2u1l < 15) || (d2u1l < 15) || (e2u1l < 15) || (a2u1 < 15) || (b2u1 < 15) || (c2u1 < 15) || (d2u1 < 15) || (a2b1 < 15) || (b2b1 < 15) || (c2b1 < 15) || (d2b1 < 15) || (e2u1 < 15) || (e2b1 < 15) || (e21 < 15) || (ii41 < 15) || (e21v < 15) || (a21 < 15) || (c21 < 15) || (b21 < 15) || (d21 < 15) || (e41 < 15) || (f41 < 15) || (h41 < 15) || (i41 < 15) || (a21v < 15) || (c21v < 15) || (b21v < 15) || (d21v < 15) || (a2u1 < 15) || (c2u1 < 15) || (b2u1 < 15) || (d2u1 < 15) || (a2b1 < 15) || (c2b1 < 15) || (b2b1 < 15) || (d2b1 < 15) || (a21v6 < 15) || (c21v6 < 15) || (b21v6 < 15) || (d21v6 < 15) || (e21v6 < 15) || (a21v7 < 15) || (c21v7 < 15) || (b21v7 < 15) || (d21v7 < 15) || (e21v7 < 15)) {

                    e4 = 1;
                    //  System.out.println(e4 + " " + "fifth");

                } else {
                    e4 = 0;
                    //  System.out.println(e4 + " " + "fifth");

                }
///-----------------------------------------------------------------------------------------------------------

                int qqq1 = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 34, 0);
                int qqq2 = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 34, 0);
                int qqq3 = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 34, 0);
                int qqq4 = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 34, 0);
                int qqq5 = raster.getSample(bv.calibration_x + 23, bv.calibration_y + 34, 0);

                int qqq6 = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 35, 0);
                int qqq7 = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 35, 0);
                int qqq8 = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 35, 0);
                int qqq9 = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 35, 0);
                int qqq10 = raster.getSample(bv.calibration_x + 23, bv.calibration_y + 35, 0);

                int f11v = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 36, 0);
                int f2v = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 36, 0);
                int f3v = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 36, 0);
                int f413v = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 36, 0);
                int f413v1 = raster.getSample(bv.calibration_x + 23, bv.calibration_y + 36, 0);

                int f11u = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 37, 0);
                int f2u = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 37, 0);
                int f3u = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 37, 0);
                int f413u = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 37, 0);
                int f413u1 = raster.getSample(bv.calibration_x + 23, bv.calibration_y + 37, 0);

                int f11 = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 38, 0);
                int f2 = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 38, 0);
                int f3 = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 38, 0);
                int f413 = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 38, 0);
                int f4131 = raster.getSample(bv.calibration_x + 23, bv.calibration_y + 38, 0);

                int f5 = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 39, 0);
                int f6 = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 39, 0);
                int f7 = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 39, 0);
                int f8 = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 39, 0);
                int f9 = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 39, 0);

                int f11f = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 40, 0);
                int f2f = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 40, 0);
                int f3f = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 40, 0);
                int f413f = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 40, 0);
                int f413f2 = raster.getSample(bv.calibration_x + 23, bv.calibration_y + 40, 0);

                int fff1 = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 41, 0);
                int fff2 = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 41, 0);
                int fff3 = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 41, 0);
                int fff4 = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 41, 0);
                int fff5 = raster.getSample(bv.calibration_x + 23, bv.calibration_y + 41, 0);

                int fff6 = raster.getSample(bv.calibration_x + 19, bv.calibration_y + 42, 0);
                int fff7 = raster.getSample(bv.calibration_x + 20, bv.calibration_y + 42, 0);
                int fff8 = raster.getSample(bv.calibration_x + 21, bv.calibration_y + 42, 0);
                int fff9 = raster.getSample(bv.calibration_x + 22, bv.calibration_y + 42, 0);
                int fff10 = raster.getSample(bv.calibration_x + 23, bv.calibration_y + 42, 0);

                //------------
                // System.out.println((x+23)+" "+(y+1));
                if ((qqq1 < 15) || (qqq2 < 15) || (qqq3 < 15) || (qqq4 < 15) || (qqq5 < 15) || (qqq6 < 15) || (qqq7 < 15) || (qqq8 < 15) || (qqq9 < 15) || (qqq10 < 15) || (fff1 < 15) || (fff2 < 15) || (fff3 < 15) || (fff4 < 15) || (fff5 < 15) || (fff6 < 15) || (fff7 < 15) || (fff8 < 15) || (fff9 < 15) || (fff10 < 15) || (f413f2 < 15) || (f9 < 15) || (f4131 < 15) || (f413u1 < 15) || (f413v1 < 15) || (f11 < 15) || (f2 < 15) || (f3 < 15) || (f413 < 15) || (f5 < 15) || (f6 < 15) || (f7 < 15) || (f8 < 15) || (f11f < 15) || (f2f < 15) || (f3f < 15) || (f413f < 15) || (f11v < 15) || (f2v < 15) || (f3v < 15) || (f413v < 15) || (f11u < 15) || (f2u < 15) || (f3u < 15) || (f413u < 15)) {

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
                String s = strI + r + cd + I + st + rI;
                  //System.out.print(s + " = ");
                int foo = Integer.valueOf(s);

                bv1 = bv.getDecimalFromBinary(foo);
                tst.printCharacter(bv1);
            }
        } catch (Exception er) {
            System.out.println(er.toString());
        }
    }
}
