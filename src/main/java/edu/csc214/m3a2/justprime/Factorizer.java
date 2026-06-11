package edu.csc214.m3a2.justprime;

import java.util.ArrayList;

/**
 * Finds prime factors and checks whether numbers are prime or composite.
 *
 * <p>This class contains the core logic for the Just Prime assignment. It does
 * not handle user input or console output so that the factorization logic can
 * be tested independently.</p>
 */
public class Factorizer {
    /**
     * Returns the prime factors of a number.
     *
     * <p>If the number is less than or equal to 1, the method returns an empty
     * list because those values do not have prime factors.</p>
     *
     * @param number the number to factor
     * @return an ArrayList containing the prime factors of the number
     */
    public ArrayList<Integer> primeFactors(int number) {
        ArrayList<Integer> factors = new ArrayList<>();
        // Anything less than or equal to 1 does not have prime factors, 
        // so return an empty list, per the assignment parameters.
        if (number <= 1) {
            return factors;
        }

        // If it isn't less than or equal to 1 then we can work with it but 2 is the only
        // even prime so let's handle that first and then we can cut loop processing load
        // by only checking odd factors in the loop.

        int remainingNumber = number;

        while (remainingNumber % 2 == 0) {
            factors.add(2);
            remainingNumber = remainingNumber / 2;
        }

        // Okay, so we have dealt with 2, now we can skip all the even numbers and just check the 
        // odd numbers starting with 3.
        int possibleFactor = 3;

        // Use division in the loop condition to check for factors up to the square root of the 
        // remaining number so we avoid the possibility of integer overflow for large numbers..
        while (possibleFactor <= remainingNumber / possibleFactor) {
            while (remainingNumber % possibleFactor == 0) {
                factors.add(possibleFactor);
                remainingNumber = remainingNumber / possibleFactor;
            }
            // Increment to the next odd number.
            // This will cause us to end up checking non-prime odd numbers, but that's okay because 
            // they won't be factors and the loop will just skip over them.  Computationally speaking
            // this is still more efficient than checking every number and then checking for primality.
            // Unless we are dealing with really large numbers, this will be fine.  If the numbers are 
            // really large, we would want to implement a more efficient algorithm for finding the next 
            // prime factor, but that is beyond the scope of this assignment.  For this assignment, we
            // can artificially limit the input to a reasonable size so that this approach is efficient enough..


            possibleFactor = possibleFactor + 2;
        }

        if (remainingNumber > 1) {
            factors.add(remainingNumber);
        }

        return factors;
    }

    /**
     * Determines whether a number is prime.
     *
     * <p>A prime number has exactly one prime factor: itself.</p>
     *
     * @param number the number to check
     * @return true if the number is prime; otherwise false
     */
    public boolean isPrime(int number) {
        ArrayList<Integer> factors = primeFactors(number);

        return factors.size() == 1 && factors.get(0) == number;
    }

    /**
     * Determines whether a number is composite.
     *
     * <p>A composite number is greater than 1 and not prime.</p>
     *
     * @param number the number to check
     * @return true if the number is composite; otherwise false
     */
    public boolean isComposite(int number) {
        return number > 1 && !isPrime(number);
    }
}
