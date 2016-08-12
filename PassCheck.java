/**
 * Created by adam on 8/10/16.
 */
import java.io.*;
import java.util.Scanner;

public class PassCheck {
    public static boolean validatePassword(String inputPassword) {
        boolean running = true;
        boolean validPassword = true;

            int upperCaseCount = countUpperCase(inputPassword);
            int lowerCaseCount = countLowerCase(inputPassword);
            int numbersCount = countNumbers(inputPassword);
            System.out.println("there are " + upperCaseCount + " upper case letters, " + lowerCaseCount + " lower case letters and " + numbersCount + " numbers.");


            System.out.println("There are " + countSpecialCharacter(inputPassword) + " special characters");

            String strippedPass = removeSpecialCharacters(inputPassword.toLowerCase());

            String curWord = null;
            Scanner dictionary = null;
            BufferedWriter bw = null;

            try {
                dictionary = new Scanner(new File("dictionary.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while (dictionary.hasNextLine()) {
                curWord = dictionary.nextLine();
                try {
                    bw = new BufferedWriter(new FileWriter(".passwords.txt",true));
                    bw.write(String.valueOf(inputPassword));
                    bw.newLine();
                    bw.flush();
                    break;
                } catch (IOException ioe) {
                    ioe.printStackTrace();

                }




                if ((strippedPass.contains(curWord) && curWord.length() > 4) || strippedPass.equals(curWord)) {
                 //   System.out.println("pass: " + strippedPass  + "\tThe dictionary word used is: " + curWord);
                    System.out.println("Your password has a dictionary word in it. Please choose another password");
                    validPassword = false;

                    break;
                }
            }




            if (validPassword && inputPassword.length() > 6) {
                System.out.println("Your password is strong enough.");

            }



        return validPassword;


    }


    public static String removeSpecialCharacters(String pass) {
        StringBuilder newPass = new StringBuilder();
        for (int i = 0; i < pass.length(); i++) {
            char x = pass.charAt(i);
            if (!isSpecialCharacter(x) && !isNumber(x) ) {
                newPass.append(x);
            }

        }
        return newPass.toString();
    }

    public static boolean isUpperCase(char x){
        return x >= 65 && x <= 90;
    }
    public static int countUpperCase(String pass) {
        int count = 0;

        for (int i = 0; i < pass.length(); i ++) {
           if (isUpperCase(pass.charAt(i))) {
               count++;
           }
        }

        return count;
    }

    public static boolean isLowerCase(char x) {
        return x >= 97 && x <= 122;
    }

    public static int countLowerCase (String pass) {
        int count = 0;
        for (int i = 0; i < pass.length(); i ++){
            if (isLowerCase(pass.charAt(i))) {
                count++;
            }
        }


        return count;

    }

    public static int countSpecialCharacter(String pass) {
        int count = 0;
        for (int i = 0; i < pass.length(); i ++)
            if (isSpecialCharacter(pass.charAt(i))) {
                count++;
            }


        return count;
    }
   /* public static int popularWords(String pass){
        int count = 0;
        for (int i = 0; i < pass.length(); i ++)
            if

    }*/




    public static boolean isSpecialCharacter(char x) {
        return !isNumber(x) && !isUpperCase(x) && !isLowerCase(x);
    }

    public static boolean isNumber(char x){
        return x >= 48 && x <= 57;
    }

    public static int countNumbers(String pass) {
        int count = 0;
        for (int i = 0; i < pass.length(); i ++){
            if (isNumber(pass.charAt(i))){
                count++;
            }

        }



        return count;

    }



}
