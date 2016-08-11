/**
 * Created by adam on 8/11/16.
 */
import java.util.Scanner;
import java.io.Console;


public class passwordDriver {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Console cnsl = null;
        String alpha = null;

        boolean checkPass = true;
        // creates a console object
        cnsl = System.console();

        if (cnsl != null) {
            /** // read line from the user input
            alpha = cnsl.readLine("Name: ");

            // prints
            //System.out.println("Name is: " + alpha);
         */
        }


        while (checkPass) {


            try{


                // if console is not null
                if (cnsl != null) {

                    //tell the user what the app does
                    System.out.println("Type your password and check how strong it is!");


                    // read password into the char array
                    char[] pwd = cnsl.readPassword("Password: ");



                    if (PassCheck.validatePassword(String.valueOf(pwd))) {
                        checkPass = false;
                    }
                    else {
                        System.out.println("Your password is invalid. ");
                    }
                }
            }catch(Exception ex){

                // if any error occurs
                ex.printStackTrace();
            }




        }


    }
}
