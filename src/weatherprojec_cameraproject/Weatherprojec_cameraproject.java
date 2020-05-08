package weatherprojec_cameraproject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/**
 *
 * @author oladele
 */
public class Weatherprojec_cameraproject {

    public static void main(String[] args) {
        // TODO code application logic here
        //DECLARE FILE READER STREAM 

        FileReader frs = null;          //READ FROM A FILE

        //DECLARE FILE WRITTER STREAM
        FileWriter fws = null;          //WRITE TO A FILE 

        //DECLARE STREAMTOKENIZER 
        StreamTokenizer in = null;

        //DECLARE PRINTER STREAM
        PrintWriter out = null;

        //DECLARE STRING VARAIBLE DATA TYPE TO STORE CAMERA BRAND
        String Brand = "";

        //DECLARE STRING VARAIBLE DATA TYPE TO STORE CAMERA MODEL
        String Model = "";

        //DECLARE STRING VARAIBLE DATA TYPE TO STORE CAMERA COLOUR
        String Colour = "";

        //DECLARE INTEGER VARAIBLE DATA TYPE TO STORE CAMERA MEGAPIXEL
        int MegaPixel = 0;

        //DECLARE DOUBLE VARAIBLE DATA TYPE TO STORE CAMERA OLD PROCE
        double OldPrice = 0;

        //DECLARE DOUBLE VARAIBLE DATA TYPE TO STORE CAMERA NEW PRICE
        double NewPrice = 0;

        try {

            //CREATE FILE INPUT AND OUTPUT STREAM 
            frs = new FileReader("stock.dat");          //INPUT

            fws = new FileWriter("newstock.dat");       //OUTPUT

            //STREAM TOKENIZER WRAPPING FILE INPUT STREAM
            in = new StreamTokenizer(frs);

            //PRINT WRITER WRAPPING FILE OUTPUT STREAM
            out = new PrintWriter(fws);

            // WRITE NEW HEADINGS TO THE NEW STOCK DAT FILE
            out.println("Brand  \t \t Model \t \tColour \t \tMegaPixel \t \tOldPrice \t \tNewPrice");

            // READ THE FIVE COLUMN HEADINGS
            for (int i = 0; i < 5; i++) {
                in.nextToken();
            }

            //READ THE FIRST TOKEN OF THE FIRST ROW- CAMERA BRAND
            in.nextToken();

            // PROCESS A RECORD
            while (in.ttype != StreamTokenizer.TT_EOF) {

                // CAMERA BRAND INPUT
                if (in.ttype == StreamTokenizer.TT_WORD) {
                    Brand = in.sval;
                } else {
                    System.out.println("Invalid file structure");
                }

                in.nextToken();

                // CAMERA MODEL INPUT
                if (in.ttype == StreamTokenizer.TT_WORD) {
                    Model = in.sval;
                } else {
                    System.out.println("Invalid file structure");
                }
                in.nextToken();

                // CAMERA COLOUR INPUT
                if (in.ttype == StreamTokenizer.TT_WORD) {
                    Colour = in.sval;
                } else {
                    System.out.println("Invalid file structure");
                }
                in.nextToken();

                // CAMERA MEGAPIXEL INPUT
                if (in.ttype == StreamTokenizer.TT_NUMBER) {
                    MegaPixel = (int) in.nval;
                } else {
                    System.out.println("Invalid file structure");
                }

                in.nextToken();

                // CAMERA OLD PRICE INPUT
                if (in.ttype == StreamTokenizer.TT_NUMBER) {
                    OldPrice = (int) in.nval;
                } else {
                    System.out.println("Invalid file structure");
                }
                if (Model.equalsIgnoreCase(Model)) {
                    if (OldPrice > 450) {
                        NewPrice = OldPrice / 100 * (100 - 15);
                    } else if (OldPrice >= 300 && OldPrice <= 449) {
                        NewPrice = OldPrice / 100 * (100 - 12);
                    } else if (OldPrice >= 200 && OldPrice <= 299) {
                        NewPrice = OldPrice / 100 * (100 - 10);
                    } else if (OldPrice >= 100 && OldPrice <= 199) {
                        NewPrice = OldPrice / 100 * (100 - 8);
                    } else if (OldPrice < 99) {
                        NewPrice = OldPrice / 100 * (100 - 5);
                    }
                }

                in.nextToken();

                // WRITE TO THE SECOND FILE - newstock.dat
                out.println(Brand + "\t\t " + Model + "\t\t " + Colour + "\t\t " + MegaPixel + "\t\t " + OldPrice + "\t\t " + NewPrice);

            }
            out.print(" successful ");

            System.out.println("Parsing file completed  - check  for newstock.dat for summary information");

        } catch (FileNotFoundException ex) {
            System.out.println("File not found: stock.dat");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (frs != null) {
                    frs.close();
                }
                if (fws != null) {
                    fws.close();
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

}
