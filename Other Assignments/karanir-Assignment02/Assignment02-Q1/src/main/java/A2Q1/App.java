package A2Q1;
import java.util.*;
/**
 * takes a decimal number as input and returns an octal number as output
 */
public class App {
    public static void main(String[] args) {
        Scanner inp = new Scanner (System.in);
        System.out.print("Enter a decimal number between -1000 and 1000: ");
        int deci_num = inp.nextInt();
        if (deci_num>=-1000 && deci_num<=1000){
            int octa_num = decimalToOctal(deci_num);

            System.out.println("The octal number is: "+ octa_num);
        }
        else{
            System.err.println("Error! Please enter a number between -1000 and 1000");
        }

        inp.close();
    }
    private static int decimalToOctal(int deci_num){
        
        int octa_num = 0;                  //variable innitialized to 0 - will store the final octal number
        int place_val = 1;                 //variable for storing the current place value - useful to calculate the octal value.
        int deci_abs = Math.abs(deci_num); //absolute value of the deci_num variable for calculations.
       
        while (deci_abs>0) {         //loop while the absolute value of the decimal number is more than 0
            int remainder = deci_abs%8;        // store the remainder of the decimal number when divided by 8
            octa_num += (remainder*place_val); //add the remainder to the 'end' of the octal number (since we start with a place value of 1)
            place_val *= 10;                   //increase the place value to the next place (1 to 10 to 100...)
            deci_abs /= 8;                     //the decimal number is divided by 8 and the process is repeated till deci_num>0
        }

        if (deci_num >= 0){        //the octa_num variable is positive
            return octa_num;       //so we return -octanum if its the original decimal number was negative
        }
        else{
            return -octa_num;
        }
        
    }

    
}
