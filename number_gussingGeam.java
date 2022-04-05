import java.util.Scanner;

import javax.swing.SwingConstants;

/**
 * number_gussingGeam
 */
public class number_gussingGeam {
    // The Random number (intance variabale)
    private static int randomNumber;

    public static void main(String[] args) {
        System.out.println("Hallo, heute spielen wir ein kleines Zahlenraten spiel.");
        boolean play = true;
        Scanner scanner = new Scanner(System.in);
        int typeOfPLay = -1;
        while (play) {
            System.out.println("(1) pc Vs.Player\n(2) Player Vs.Player\n(3) pc Vs.pc\n(4) Exit");
            typeOfPLay = scanner.nextInt();
            switch (typeOfPLay) {
                case 1:
                    pcVsPlayer();
                    break;
                case 2:
                    playerVsPc();
                    break;
                case 3:
                    System.out.println("not yet");
                    // pcVsPc();
                    break;
                case 4:
                    play = false;
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("invalid input");
                    break;
            }
        }
    }

    // The player vs pc method
    private static void playerVsPc() {
        Scanner scanner = new Scanner(System.in);
        int max = userSetUp();
        int counter = 0;
        randomNumber(max);
        System.out.println("I have my random number. You have to guess it.");
        System.out.println("I have set the range from 1 to " + max);
        boolean isGuessed = false;
        while (!isGuessed) {
            counter++;
            System.out.println("Next guess:");
            int guess = scanner.nextInt();
            isGuessed = checkNumber(guess);
        }
        System.out.println("You have guessed " + counter + " times.");
    }

    // The userSetUp method
    public static int userSetUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("I choose now my number, please enter a high level number!");
        int max = scanner.nextInt();
        return max;
    }

    // craet a pc vs player method
    private static void pcVsPlayer() {
        Scanner scanner = new Scanner(System.in);
        int max = (int) Math.floor(Math.random() * (10 - 1) + 1) * 10;
        int min = 0;
        int counter = 0;
        int think;
        System.out.println("please think to a number between " + min + " and " + max);
        System.out.println("I have my random number. You have to guess it.");
        System.out.println("I have set the range from 1 to " + max);
        boolean isGuessed = false;

        while (!isGuessed) {
            counter++;
            System.out.println(
                    "type 1 if the guss is the number\ntype 2 if the guss is higher\ntype 3 if the guss is lower");
            int guess = (max - min) / 2 + min; // todo: crate an algorithm to guess the number
            System.out.println("I think to " + guess);
            think = scanner.nextInt();
            if (think == 1) {
                isGuessed = true;
            } else if (think == 2) {
                min = guess;
            } else if (think == 3) {
                max = guess;
            } else {
                System.out.println("Something went wrong");
            }
        }
        System.out.println("You have guessed " + counter + " times.");
    }

    // the algorithm to guess the number
    private static int guessNumber(int max, int min) {
        int spock = (max + min) / 2;
        int guess = min + spock;
        return guess;
    }

    // create a random number
    public static int randomNumber(int max) {
        randomNumber = (int) (Math.random() * (max - 1)) + 1;
        System.out.println(randomNumber);
        return randomNumber;
    }

    // crating a method to check if the input is the number is correct number
    public static boolean checkNumber(int guess) {
        if (guess == randomNumber) {
            System.out.println("You won!");
            return true;
        } else if (guess > randomNumber) {
            System.out.println("Your number is too high!");
            return false;
        } else if (guess < randomNumber) {
            System.out.println("Your number is too low!");
            return false;
        } else {
            System.out.println("You have entered an invalid number!");
            return false;
        }
    }
    // Creatin a method to check if the input is the number is correct number with
    // an input

}