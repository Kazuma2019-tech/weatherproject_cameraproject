package weatherprojec_cameraproject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author Oladele
 */
public class stock_write {

    public static void main(String[] args) {

        //FILE LOCATION
        Path target = Paths.get("stock.dat");

        //SCANNER USED TO READ IN DATA
        Scanner scan = new Scanner(System.in);

        // STRING VARIABLE TO STORE BRAND 
        String Brand;

        // STRING VARIABLE TO STORE MODEL
        String Model;

        // STRING VARIABLE TO STORE COLOUR
        String Colour;

        // INTEGER VARIABLE TO STORE MEGAPIXEL
        int Megapixel;

        // INTEGER VARIABLE TO STORE PRICE
        int Price;

        // DECLARE TEXTFILE INPUT TEXT AS STRING
        String TextForFile = "";

        // DECLARE MORE INPUT TEXT AS STRING
        String More = "y";

        try {

            System.out.println("Please enter stock details");
            while (More.equals("y")) {

                // ALLOW USER TO ENTER CAMERA BRAND
                System.out.println("Please enter the  camera brand:");
                Brand = scan.next();

                // ALLOW USER TO ENTER CAMERA MODEL
                TextForFile += Brand + "\t";

                System.out.println("Please enter the camera model:");
                Model = scan.next();

                // ALLOW USER TO ENTER CAMERA COLOUR
                TextForFile += Model + "\t";

                System.out.println("Please enter the camera colour:");

                Colour = scan.next();

                // ALLOW USER TO ENTER CAMERA MEGAPIXEL
                TextForFile += Colour + "\t";

                System.out.println("Please enter the camera megapixel:");
                Megapixel = scan.nextInt();

                // ALLOW USER TO ENTER CAMERA PRICE
                TextForFile += Megapixel + "\t";

                System.out.println("Please enter the camera price:");
                Price = scan.nextInt();

                // SYSTEM ASK THE USER IF MORE DATA WILL BE ENTERED 
                TextForFile += Price + "\n";

                scan.nextLine();

                System.out.println("Would you like to enter more data? (y/n)");
                More = scan.nextLine();

                // TO CONVERT VARIOUS CASES TO LOWER CASE
                More.toLowerCase();
            }
            Files.write(target, TextForFile.getBytes());
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

}
