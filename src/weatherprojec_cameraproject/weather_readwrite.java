package weatherprojec_cameraproject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/**
 *
 * @author Oladele
 */
public class weather_readwrite {

    //MAIN METHOD
    public static void main(String[] args) {

        //DECLARE FILE READER STREAM 
        FileReader frs = null;      //READ FROM A FILE

        //DECLARE FILE WRITTER STREAM 
        FileWriter fws = null;      //WRITE TO A FILE 

        //DECLARE STREAMTOKENIZER 
        StreamTokenizer in = null;

        //DECLARE PRINTER STREAM
        PrintWriter out = null;

        // STRING VARIABLE TO STORE COUNTY
        String County = "";

        // STRING VARIABLE TO STORE WEATHER CONDITION
        String FreezeRisk = "";

        // INTEGER VARIABLE TO STORE MAXIMUM WEATHER TEMPERTURE
        int Max = 0;

        // INTEGER VARIABLE TO STORE MINIMUM WEATHER TEMPERTURE
        int Min = 0;

        // DOUBLE VARIABLE DATA TYPE TO STORE THE AVERVAGE OF THE WEATHER CONDITION
        double Avg = 0;

        try {

            //CREATE FILE INPUT AND OUTPUT STREAM 
            frs = new FileReader("weather.dat");             //INPUT

            fws = new FileWriter("averagetemps.dat");        //OUTPUT

            //STREAM TOKENIZER WRAPPING FILE INPUT STREAM
            in = new StreamTokenizer(frs);

            //PRINT WRITER WRAPPING FILE OUTPUT STREAM
            out = new PrintWriter(fws);

            out.println("County  \t \t Average Daily Temp \t Freeze Risk");

            // READ THE FOUR COLUMN HEADINGS 
            for (int i = 0; i < 4; i++) {
                in.nextToken();
            }

            //READ THE FIRST TOKEN OF FIRST ROW - COUNTY
            in.nextToken();

            // PROCESS A RECORD
            while (in.ttype != StreamTokenizer.TT_EOF) {

                //GET THE COUNTY NAMES    
                if (in.ttype == StreamTokenizer.TT_WORD) {
                    County = in.sval;
                } else {
                    System.out.println("Invalid file structure");
                }

                //GET SECOND TOKEN FOR MAXIMUM TEMPERATURE
                in.nextToken();

                if (in.ttype == StreamTokenizer.TT_NUMBER) {
                    Max = (int) in.nval;
                } else {
                    System.out.println("Invalid file structure");
                }

                //GET THIRD TOKEN FOR MINIMUM TEMPERATURE
                in.nextToken();

                if (in.ttype == StreamTokenizer.TT_NUMBER) {
                    Min = (int) in.nval;
                } else {
                    System.out.println("Invalid file structure");
                }

                // CALCULATE AVERAGE TEMPERATURE AND STORE ON AVG
                if (County.equalsIgnoreCase(County)) {
                    Avg = (double) (Max + Min) / 2;

                    // CHECK IF AVERAGE TEMPERATURE IS LESS OR GREATER ZERO
                    if (Avg <= 0) {
                        FreezeRisk = "YES";
                    } else {
                        FreezeRisk = "NO";
                    }
                }

                //READ THE FOURTH TOKEN TO STORE THE WEATHER CONDITION
                in.nextToken();

                //READ NEXT TOKEN OF THE NEXT LINE IN THE PRINT FILE 
                in.nextToken();

                out.println(County + " \t \t " + "   " + Avg + "  \t \t    " + FreezeRisk);

            }
            out.print("Successful ");

            System.out.println("Parsing file complete  - check averagetemps.dat for summary information");

        } catch (FileNotFoundException ex) {
            System.out.println("File not found: weather.dat");
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
