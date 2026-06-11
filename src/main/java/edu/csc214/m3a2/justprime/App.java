package edu.csc214.m3a2.justprime;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Driver application for the Just Prime assignment.
 *
 * <p>This class demonstrates the {@link Factorizer} class by allowing the user
 * to enter a number, request a random number, or exit the program.</p>
 */

// Heads up.  I took some liberties here and added some extra classes and functionality 
// that weren't strictly required by the assignment but I wanted to explore a bit.  I have 
// endeavored to wall off the googiness in separate classes so that the core functionality 
// is still clear, testable and most importantly, easily gradeable..

public class App {
    private static final int MINIMUM_INPUT = 0;
    // We don't want to be churning all day, so I'm putting a cap on the input.  
    // This also allows us to generate random numbers within the same range.
    private static final int MAXIMUM_INPUT = 10000;
    private static final int RANDOM_UPPER_BOUND = 10000;
    // A banner because, well, why not?
    private static final String BANNER =
        "     ___  __   __  _______  _______    _______  ______    ___   __   __  _______  __  %n"
      + "    |   ||  | |  ||       ||       |  |       ||    _ |  |   | |  |_|  ||       ||  | %n"
      + "    |   ||  | |  ||  _____||_     _|  |    _  ||   | ||  |   | |       ||    ___||  | %n"
      + "    |   ||  |_|  || |_____   |   |    |   |_| ||   |_||_ |   | |       ||   |___ |  | %n"
      + " ___|   ||       ||_____  |  |   |    |    ___||    __  ||   | |       ||    ___||__| %n"
      + "|       ||       | _____| |  |   |    |   |    |   |  | ||   | | ||_|| ||   |___  __  %n"
      + "|_______||_______||_______|  |___|    |___|    |___|  |_||___| |_|   |_||_______||__| %n";

    /**
     * Starts the application.
     *
     * @param args command-line arguments passed to the program
     */
    public static void main(String[] args) {
        // Create the Scanner in one place and manage its lifecycle in this class. 
        // This way we can pass it to the UserInput class and ensure it gets closed when we're done.
        Scanner scanner = new Scanner(System.in);
        UserInput userInput = new UserInput(scanner);
        Factorizer factorizer = new Factorizer();
        CosmicMessageGenerator messageGenerator = new CosmicMessageGenerator();
        Random random = new Random();
        
        // Yep.  A banner.
        System.out.println("Welcome to");
        System.out.println();
        System.out.printf(BANNER);
        System.out.println();
        System.out.println("Enter a number to see its prime factors or . . .");
        System.out.println("just press enter if you are feeling lucky.");
        System.out.println("Type exit to quit.");
        System.out.println();


        // Going old school with the boolean flag for the loop control.  
        // We could also use a break statement, but I prefer this approach for readability in this case.
        // I think break statements are mostly lazy logic development and implementation.
        boolean keepRunning = true;

        while (keepRunning) {
            UserInputResult inputResult = userInput.getInt(
                    MINIMUM_INPUT,
                    MAXIMUM_INPUT,
                    "Enter an integer, press Enter for luck, or type exit: ",
                    "Oops! Please enter a whole number from 0 through 10000, press Enter, or type exit.");

            if (inputResult.isExitRequested()) {
                keepRunning = false;
            } else {
                int numberToFactor;
                String responseMessage;

                if (inputResult.isRandomRequested()) {
                    numberToFactor = random.nextInt(RANDOM_UPPER_BOUND + 1);
                    responseMessage = messageGenerator.generate(numberToFactor);
                } else {
                    numberToFactor = inputResult.getValue();
                    responseMessage = "You entered " + numberToFactor + ". The prime factors are: ";
                }

                ArrayList<Integer> primeFactors = factorizer.primeFactors(numberToFactor);

                System.out.println(responseMessage + primeFactors);
                System.out.println();
            }
        }

        System.out.println("Goodbye. May your factors be prime and your stack traces be short.");

        scanner.close();
    }
}
