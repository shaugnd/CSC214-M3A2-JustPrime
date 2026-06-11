package edu.csc214.m3a2.justprime;

import java.util.Scanner;

/**
 * Handles reusable integer input for the driver program.
 *
 * <p>This class asks the user for an integer, allows a blank entry to request
 * a random number, allows the user to type exit to quit, and keeps retrying
 * after invalid input.</p>
 */

// Leveraging code from the last assignment, but I made some changes
// to align it better with the requirements of this assignment and to make it more robust and testable. 

public class UserInput {
    private static final String EXIT_COMMAND = "exit";

    private final Scanner scanner;

    /**
     * Creates a user input helper.
     *
     * @param scanner the Scanner used to read user input
     */
    public UserInput(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Gets an integer input result from the user.
     *
     * <p>If the user presses Enter without typing anything, the method returns
     * a random-number request. If the user types exit, the method returns an
     * exit request. If the user types a valid integer within the allowed range,
     * the method returns that number.</p>
     *
     * @param lowerBound the smallest valid integer
     * @param upperBound the largest valid integer
     * @param prompt the message shown to the user
     * @param errorMessage the message shown after invalid input
     * @return a UserInputResult describing the user's input action
     */
    public UserInputResult getInt(
            int lowerBound,
            int upperBound,
            String prompt,
            String errorMessage) {
        validateBounds(lowerBound, upperBound);

        while (true) {
            System.out.print(prompt);
            String rawInput = scanner.nextLine().trim();

            if (rawInput.isEmpty()) {
                return UserInputResult.randomRequested();
            }

            if (rawInput.equalsIgnoreCase(EXIT_COMMAND)) {
                return UserInputResult.exitRequested();
            }

            try {
                int value = Integer.parseInt(rawInput);

                if (value >= lowerBound && value <= upperBound) {
                    return UserInputResult.numberEntered(value);
                }

                System.out.println(errorMessage);
            } catch (NumberFormatException exception) {
                System.out.println(errorMessage);
            }
        }
    }

    /**
     * Validates that the lower bound is not greater than the upper bound.
     *
     * @param lowerBound the smallest valid integer
     * @param upperBound the largest valid integer
     */
    private void validateBounds(int lowerBound, int upperBound) {
        if (lowerBound > upperBound) {
            throw new IllegalArgumentException("Lower bound cannot be greater than upper bound.");
        }
    }
}
