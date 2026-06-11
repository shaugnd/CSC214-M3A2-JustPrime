package edu.csc214.m3a2.justprime;

/**
 * Represents the type of input action requested by the user.
 */
// I know this is overkill.  I'm just trying to exercise skills in the space.
public enum UserInputAction {
    /**
     * The user entered a valid integer.
     */
    NUMBER_ENTERED,

    /**
     * The user pressed Enter without typing a number.
     */
    RANDOM_REQUESTED,

    /**
     * The user requested to exit the program.
     */
    EXIT_REQUESTED
}
