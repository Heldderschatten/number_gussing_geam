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
    //create a random number
    public static int randomNumber(int max){
        randomNumber = (int) (Math.random() * (max-1)) + 1;
        System.out.println(randomNumber);
        return randomNumber;
    }
    //crating a method to check if the input is the number is correct number
    public static boolean checkNumber(int guess){
        if(guess == randomNumber){
            System.out.println("You won!");
            return true;
        }
        else if(guess > randomNumber){
            System.out.println("Your number is too high!");
            return false;
        }
        else if(guess < randomNumber){
            System.out.println("Your number is too low!");
            return false;
        }
        else{
            System.out.println("You have entered an invalid number!");
            return false;
        }
    }


}