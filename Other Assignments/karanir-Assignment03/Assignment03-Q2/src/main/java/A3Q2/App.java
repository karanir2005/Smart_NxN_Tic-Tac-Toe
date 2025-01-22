package A3Q2;

/*
 * Code that translates alphanumeric phone numbers to fully numeric ones
 * 10/11/2024
 * Rushil Karani
*/

import java.util.*; //import util for Scanner input

public class App {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        
        //ask user for 10 digit alphanumeric number and save it in a variable
        System.out.print("Enter a 10-character phone number in the format XXX-XXX-XXXX: ");
        String ph_num = inp.nextLine();

        String regex = "^[a-zA-Z0-9]{3}-[a-zA-Z0-9]{3}-[a-zA-Z0-9]{4}$"; //regex format for the correct input

        //if phone number is entred in the correct format then call the translateNum method, else print error message.
        if (ph_num.matches(regex)){
            String translated_num = translateNum(ph_num.toUpperCase());
            System.out.println("The phone number for "+ph_num+" is "+translated_num);
        }
        else{
            System.err.println("Error! Please format like XXX-XXX-XXXX"); 
        }

        inp.close(); //close Scanner 
    }

    private static String translateNum(String ph_num){

        //create empty string to store return value ie. translated number.
        String rtrn_num = "";

        //loops through every character in the string
        for (int i = 0; i < ph_num.length(); i++) {
            char ch = ph_num.charAt(i);

            //checks if the character is an alphabet then converts the alphabet to its coresponding number
            //the coresponding number is appended to the rtrn_num string.
            
            //else if its a '-' or number digit then the character is added as it is.
            
            if (ch >= 'A' && ch <= 'C') rtrn_num = rtrn_num+"2";
            else if (ch >= 'D' && ch <= 'F') rtrn_num = rtrn_num+"3";
            else if (ch >= 'G' && ch <= 'I') rtrn_num = rtrn_num+"4";
            else if (ch >= 'J' && ch <= 'L') rtrn_num = rtrn_num+"5";
            else if (ch >= 'M' && ch <= 'O') rtrn_num = rtrn_num+"6";
            else if (ch >= 'P' && ch <= 'S') rtrn_num = rtrn_num+"7";
            else if (ch >= 'T' && ch <= 'V') rtrn_num = rtrn_num+"8";
            else if (ch >= 'W' && ch <= 'Z') rtrn_num = rtrn_num+"9";
            else rtrn_num = rtrn_num+ch;
        }
        return rtrn_num; //return final string when everything is translated.
    }
}
