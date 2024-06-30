// Program written by [Your Name]

import java.util.Scanner;
import java.io.*;

public class InventoryManager {
    public static void main(String[] args) {
        try {
            // Create a Scanner object for user input
            Scanner sc = new Scanner(System.in);

            // Assign a file name and declare the file objects
            String myFile = "C:\\Temp\\data.txt";
            FileWriter file = new FileWriter(myFile);
            PrintWriter outfile = new PrintWriter(file);

            // Declare local variables for the number of records and the columns of the inventory data table
            int numRecords = 0;
            String strName = "";
            double dblCost = 0;
            int intQuantity = 0;
            char chrLocation = '\0';

            // Input the number of records to be processed
            System.out.println("How many records are for processing?");
            numRecords = sc.nextInt();

            // Process the records in the data table using a for() loop
            for (int i = 1; i <= numRecords; i++) {
                // Obtain user input
                System.out.println("Item description:");
                strName = sc.next();
                System.out.println("Item cost:");
                dblCost = sc.nextDouble();
                System.out.println("Item quantity:");
                intQuantity = sc.nextInt();
                System.out.println("Item location:");
                chrLocation = sc.next().charAt(0);

                // Write the data to the file
                outfile.print(strName + ",");
                outfile.print(dblCost + ",");
                outfile.print(intQuantity + ",");
                outfile.println(chrLocation);
            }

            // Close the Scanner and PrintWriter objects
            sc.close();
            outfile.close();

            // Reading data back from the file
            BufferedReader infile = new BufferedReader(new FileReader(myFile));
            String line;
            System.out.println("Inventory data:");
            while ((line = infile.readLine()) != null) {
                System.out.println(line);
            }
            infile.close();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
