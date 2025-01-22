package A3Q1;

/*
 * Rushil Karani
 * 10/10/2024
 * A program that calculates the roots of a quadratic equation.
*/

//import util for Scanner.
import java.util.*; 

public class App {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in); //create a new scanner object to take input

        //takes input for a,b,c as double values
        System.out.println("To solve the equation a*x^2+b*x+c=0...");
        System.out.print("Enter 'a' value: ");
        double a = inp.nextDouble();
        System.out.print("Enter 'b' value: ");
        double b = inp.nextDouble();
        System.out.print("Enter 'c' value: ");
        double c = inp.nextDouble();
        
        inp.close(); //close Scanner object

        //if a,b,c is in the range [-100, 100] then call method, else print error message.
        if (a<=100 && b<=100 && c<=100 && a>=-100 && b>=-100 && c>=-100){
            //call calcQuadratic with a b c as parameters and print the return value.
            String return_val = calcQuadratic(a,b,c);
            System.out.println(return_val);
        }
        else{
            System.err.println("Enter valid input");
        }
    }



    private static String calcQuadratic(double a, double b, double c){
        //calculate the discrimininat
        double discriminant = (b*b)-(4*a*c);
        
        //if discrimminant is negative then there are no real roots, 
        //if positive then there are 2 real roots and if =0 then there is one real root
        if (discriminant < 0){
            //no real roots
            return "The equation has no real roots.";
        }
        else if (discriminant > 0){
            //2 real roots - returns formated string of roots with 2 decimal places.
            double root1 = (-b+Math.sqrt(discriminant))/(2*a);
            double root2 = (-b-Math.sqrt(discriminant))/(2*a);
            return String.format("For a = %.2f, b = %.2f, c = %.2f, the roots are %.2f and %.2f", a, b, c, root1, root2);
        }
        else {
            //1 real root - returns formated string of a root with 2 decimal places.
            double root = -b/(2*a);
            return String.format("For a = %.2f, b = %.2f, c = %.2f, the equation has one real root: %.2f", a, b, c, root);
        }
    }
}
