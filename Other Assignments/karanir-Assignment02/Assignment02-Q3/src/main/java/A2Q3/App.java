package A2Q3;

import java.util.Scanner;

/**
 * Takes number input and returns an output of a right angle triangle. The number of rows of the triangle
 * equals the input number n
 */
public class App {
    public static void main(String[] args) {
        Scanner inp = new Scanner (System.in);
        System.out.println("Enter a number between 1 and 200");              //takes input *n* of number between 1 and 200
        int n = inp.nextInt();                                                 
        if (n<=200 && n>=1){
            num_triangle(n);                        //if number is between 1 and 200 then calls num_triangle method with argument n 
        }
        else{
            System.err.println("Error! Enter a number between 1 and 200");  //else prints error message
        }
        inp.close();
    }
    private static void num_triangle(int n){
        for (int i=1; i<=n; i++){                 //for loop that loops from 1 to n - same as the number of rows
            for (int j=1; j<=i; j++){             //for loop that loops from 1 to i - same as the number of numbers in row i
                System.out.print(j);              //prints j, therefore prints numbers from 1 to i one at a time on the same line
            }
            System.out.println();                 //sends the cursor to the next line for the next row
        } 
    }
}
