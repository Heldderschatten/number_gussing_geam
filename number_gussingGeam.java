import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * number_gussingGeam
 */
public class number_gussingGeam {
    // The Random number (intance variabale)
    private static int randomNumber;

    public static void main(String[] args) {
        System.out.println("Hallo, heute spielen wir ein kleines Zahlenraten spiel.");
        Scanner scanner = new Scanner(System.in);
        boolean play = true;
        while (play){
            play = userInput(scanner) ;
        } 
        scanner.close();
    }


    private static boolean userInput(Scanner scanner){
        int typeOfPLay = -1;
        boolean endGeam;
        System.out.println("(1) pc Vs.Player\n(2) Player Vs.pc\n(3) pc Vs.pc\n(4) Exit");
        try {
            typeOfPLay = scanner.nextInt();
        } catch (InputMismatchException e) {
            typeOfPLay = -1;
        }
        switch (typeOfPLay) {
            case 1:
                pcVsPlayer();
                endGeam = true;
                break;
            case 2:
                playerVsPc(scanner);
                endGeam =  true;
                break;
            case 3:
                //System.out.println("not finsihed");
                pcVsPc();
                endGeam = true;
                break;
            case 4:
                //play = false;
                System.out.println("Bye");
                endGeam = false;
                break;
            default:
                System.out.println("invalid input");
                endGeam = true;
                break;
        }
        return endGeam;
    }

    // The player vs pc method
    private static void playerVsPc(Scanner scanner) {
        boolean play = true;
        //Scanner scanner = new Scanner(System.in);
        while (play) {

            System.out.println("please enter a high Level");
            int max = userSetUp(scanner);
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
            System.out.println("Do you want to play again? (y/n)");
            String answer = scanner.next();
            if (answer.equals("y")) {
                play = true;
            } else if (answer.equals("n")) {
                play = false;
            } else {
                System.out.println("invalid input we do not play agian");
            }
        }
        // scanner.close();
    }

    // The userSetUp method
    public static int userSetUp(Scanner scanner) {
        
        int max;
        try {
            max = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("invalid input");
            max = userSetUp(scanner);
        }
        // scanner.close();
        return max;
    }

    // craet a pc vs player method
    private static void pcVsPlayer() {
        boolean play = true;
        while (play) {
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
                System.out.println("type 1 if the guss is the number\ntype 2 if the guss is higher\ntype 3 if the guss is lower");
                int guess = (max - min) / 2 + min;
                System.out.println("I think to " + guess);
                try {
                    think = scanner.nextInt();
                } catch (InputMismatchException e) {
                    think = -1;
                    scanner = new Scanner(System.in);
                }
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
            play = playAgian(scanner);
        }
    }
    
    private static boolean playAgian(Scanner scanner){
        System.out.println("Do you want to play again? (y/n)");
        String answer = scanner.next();
        if (answer.equals("y")) {
            return true;
        } else if (answer.equals("n")) {
            return  false;
        } else {
            System.out.println("invalid input we do not play agian");
            return false;
            
        }
    }

    // create a pc vs pc method
    private static void pcVsPc() {
        int max = (int) Math.floor(Math.random() * (10 - 1) + 1) * 10;
        int min = 0;
        int counter = 0;
        int think;
        randomNumber(max);
        System.out.println("please think to a number between " + min + " and " + max);
        System.out.println("I have my random number. You have to guess it.");
        System.out.println("I have set the range from 1 to " + max);
        boolean isGuessed = false;

        while (!isGuessed) {
            counter++;
            wait(400);
            int guess = (max - min) / 2 + min; // todo: crate an algorithm to guess the number
            System.out.println("I think to " + guess);
            wait(300);
            think = chechNumber(guess, true);
            if (think == 1) {
                isGuessed = true;
            } else if (think == 2) {
                min = guess;
            } else if (think == 3) {
                max = guess;
            } else {
                wait(50);
                System.out.println("Something went wrong");
            }
        }
        System.out.println("The PC gussed the number in: " + counter + " times.");
    }

    private static int chechNumber(int guess, boolean isPC) {
        if (guess == randomNumber) {
            System.out.println("You won!");
            return 1;
        } else if (guess > randomNumber) {
            System.out.println("Your number is too high!");
            return 3;
        } else if (guess < randomNumber) {
            System.out.println("Your number is too low!");
            return 2;
        } else {
            System.out.println("You have entered an invalid number!");
            return 4;
        }
    }

    // Create a method to wait for a time
    private static void wait(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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