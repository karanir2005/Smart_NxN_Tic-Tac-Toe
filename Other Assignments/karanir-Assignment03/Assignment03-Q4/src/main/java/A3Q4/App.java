package A3Q4;

/*
 * Guess the number game!
 * Rushil Karani
 * 11/10/2024
*/

import java.util.*; //import java.util for Scanner and Random
public class App {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in); //create new scanner object

        //inform user the rules of the game
        System.out.println("Guess the number, between -100 and 100, I'm thinking of! You get 10 tries!");
        boolean guessed = false; //innitialize the boolean to false - signifying that the user has not guessed the number yet
        int counter = 0; //signifies the number of guesses
        
        //calls the number generator method
        int gen_num = genNum();

        //loops while the user has not reached 10 tries and has not guessed the number
        while (!guessed && counter<10){
            //prompts the user to guess
            System.out.print("Enter your guess: ");
            int usr_guess = inp.nextInt();

            //error handling checks if user guess is between -100 and 100, else prints an error message.
            if (usr_guess<=100 && usr_guess>=-100){
                int val = checkGuess(usr_guess, gen_num); //calls the checkNum mathod with arguments of user guess and generated number.
                
                counter ++; //increase counter after guess is checked
                
                //if the user guess is less then generated number and the counter is less than 10, print following message
                if (val==-1 && counter < 10) { 
                    System.out.println("The number is higher than x.");
                }
                //if the user guess is more then generated number and the counter is less than 10, print following message
                else if (val==1 && counter < 10) {
                    System.out.println("The number is lower than x.");
                }
                //if the user guess is equal to generated number, print following message
                else if (val==0){
                    System.out.println("You successfully guessed the number!");
                    guessed = true;
                }
                
                //if counter is 10 and user has not guessed value then print "exausted" message.
                if (counter == 10 && !guessed) System.out.println("You have exhausted your trials");
            }
            else{
                System.err.println("Please enter a valid integer between -100 and 100"); //bad values wont increase counter.
            }
            
        }

        inp.close(); //close Scanner

    }

    private static int checkGuess(int guess, int gen_num){

        //checks if the guessed number is less, more or equal to generated number
        //return -1 is gen_num is higher, 1 if gen_num is lower and 0 if guess is correct. 
        if (guess==gen_num) return 0;
        else if (guess < gen_num) return -1;
        else return 1;
    }
    
    private static int genNum(){
        //generate random number
        Random rand = new Random();
        int ran_num = rand.nextInt(201) - 100; //generates random number between -100 and 100 (0 to 200 and subtract 100)
        return ran_num;
    }
}