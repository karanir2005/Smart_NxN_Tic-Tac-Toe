package A2Q2;

import java.util.Scanner;

/**
 * takes a number input and returns strings describing if the numbers between 1 and n (input number)
 * are divisible by 3, 5, or both
 */
public class App {
    public static void main(String[] args) {
        Scanner inp = new Scanner (System.in);
        System.out.println("Enter a number between 1 and 200"); 
        int n = inp.nextInt();                                    //takes input of an integer: n
        if (n<=200 && n>=1){                                      //if number is between 1 and 200 then
            String both = "Divided by 3 and 5 --> ";              
            String three = "Divided by 3 --> ";                   //innitialize strings for the output
            String five = "Divided by 5 --> ";                    
            int i=1;
            while(i<=n){
                int divisible_test = check_divisible(i);          //it loops from i=1 to i=n
                String temp_num = Integer.toString(i);            //the program calls check_divisible method for each value of i
                if (divisible_test == 8){                         //if i is divisible by both then edit the string both to add i to it
                    both=both.concat(i+" ");                      //add i to strings 'three' and 'five' as well
                    three=three.concat(i+" ");                    
                    five=five.concat(i+" ");    
                }
                else if (divisible_test == 3){
                    three=three.concat(i+" ");    
                }                                   //if i is divisible by 3 or 5 then edit 'three' or 'five' to add i to the end
                else if (divisible_test == 5){
                    five=five.concat(i+" ");    
                }
                i++;
            }
            System.out.println(three);
            System.out.println(five);                        //print the final expressions for all 3 strings
            System.out.println(both);

        }
        else{
            System.err.println("Enter a valid number.");
        }
        
        inp.close();
    }
    private static int check_divisible(int num){ //takes a number argument and check if its divisible by 3, 5, or both
        if (num%3==0 && num%5==0){
            return 8;                            //returns 8 if divisible by both, 5 if divisible by 5
        }                                        //3 if divisible by 3 and 0 if divisible by none 
        else if (num%3==0){
            return 3;
        }
        else if (num%5==0){
            return 5;
        }
        else{
            return 0;
        }
    }
}
