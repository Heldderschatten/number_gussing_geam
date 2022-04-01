import java.util.Scanner;

/**
 * number_gussingGeam
 */
public class number_gussingGeam {
    //The Random number (intance variabale)
    private static int randomNumber;
    public static void main(String[] args) {
        System.out.println("Hallo, heute spielen wir ein kleines Zahlenraten spiel.");
        playerVsPc();
    }
    //The player vs pc method
    private static void playerVsPc(){
        Scanner scanner = new Scanner(System.in);
        int max = userSetUp();
        int counter = 0;
        randomNumber(max);
        System.out.println("I have my random number. You have to guess it.");
        System.out.println("I have set the range from 1 to " + max);
        boolean isGuessed = false;
        while(!isGuessed){
            counter++;
            System.out.println("Next guess:");
            int guess = scanner.nextInt();
            isGuessed =  checkNumber(guess);
        }
        System.out.println("You have guessed " + counter + " times.");
    }
    //The userSetUp method
    public static int userSetUp(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("I choose now my number, please enter a high level number!");
        int max = scanner.nextInt();
        return max;
    }
    //craet a pc vs player method
    private static void pcVsPlayer(){
        Scanner scanner = new Scanner(System.in);
        int max = 30;
        int min = 0;
        int counter = 0;
        int think;
        System.out.println("please think to a number between " + min + " and " + max); 
        randomNumber = sc.nextInt();
        System.out.println("I have my random number. You have to guess it.");
        System.out.println("I have set the range from 1 to " + max);
        boolean isGuessed = false;
    
        while(!isGuessed){
            counter++;
            System.out.println("Next guess:");
            int guess = guessNumber(max, min);   //todo: crate an algorithm to guess the number
            think =  checkNumber(guess);
            if(think == 1 ){
                isGuessed = true;
            }else if(think == 2){
                max = guess;
            }else if(think == 3){
                min = guess;
            }else{
                System.out.println("Something went wrong");
            }
        }
        System.out.println("You have guessed " + counter + " times.");
    }
    //the algorithm to guess the number
    private static int guessNumber(int max, int min){
        int spock = (max + min) / 2;
        int guess = min + spock;
        return guess;
    }
    //create a random number
    public static int randomNumber(int max){
        randomNumber = (int) (Math.random() * (max-1)) + 1;
        System.out.println(randomNumber);
        return randomNumber;
    }
    //crating a method to check if the input is the number is correct number
    public static int checkNumber(int guess){
        if(guess == randomNumber){
            System.out.println("You won!");
            return 1;
        }
        else if(guess > randomNumber){
            System.out.println("Your number is too high!");
            return 2;
        }
        else if(guess < randomNumber){
            System.out.println("Your number is too low!");
            return 3;
        }
        else{
            System.out.println("You have entered an invalid number!");
            return 4;
        }
    }
}