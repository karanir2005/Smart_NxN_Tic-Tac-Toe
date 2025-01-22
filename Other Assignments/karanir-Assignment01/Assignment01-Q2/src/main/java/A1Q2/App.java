package A1Q2;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        
        System.out.println("Enter a raduis(r) 0.0<r<=10.0");
        double radius=in.nextDouble();
        if(radius <= 10 && radius>0){
        double area=Math.round((Math.PI)*(radius*radius)*100.0)/100.0;
        double perimeter = Math.round(2*(Math.PI)*radius*100.0)/100.0;
        System.out.printf("Area: %.2f%n",area);
        System.out.printf("Perimeter: %.2f%n",perimeter);
        }
        else{System.out.println("Error, please type a valid raduis(r) 0.0<r<=10.0");}
        in.close();
    }
}
