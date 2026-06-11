package edu.csc214.m3a2.justprime;

/**
 * Represents the result of asking the user for integer input.
 *
 * <p>The result contains both the action requested by the user and, when
 * appropriate, the integer value the user entered.</p>
 */

// I know this is overkill.  I'm just trying to exercise skills in the space.
// v 1:  Originally I used 0 placeholder in the exit and random cases, but that 
//       felt a little hacky and I don't care for magic numbers. So, I switched 
//       to Integer instead of int so I could use a null for the value in those 
//       cases and then added checks in the getValue method to throw an exception 
//       if the value is requested when it isn't available.  

public class UserInputResult {
    private final UserInputAction action;
    // Used Integer instead of int so that we can use null.
    private final Integer value;

    /**
     * Creates a user input result.
     *
     * @param action the type of input action
     * @param value the integer value entered by the user, or null if no number was entered
     */
    private UserInputResult(UserInputAction action, Integer value) {
        this.action = action;
        this.value = value;
    }

    /**
     * Creates a result for a valid integer entry.
     *
     * @param value the integer entered by the user
     * @return a result containing the entered number
     */
    public static UserInputResult numberEntered(int value) {
        return new UserInputResult(UserInputAction.NUMBER_ENTERED, value);
    }

    /**
     * Creates a result for a random-number request.
     *
     * @return a result indicating that the user requested a random number
     */
    public static UserInputResult randomRequested() {
        return new UserInputResult(UserInputAction.RANDOM_REQUESTED, null);
    }

    /**
     * Creates a result for an exit request.
     *
     * @return a result indicating that the user requested to exit
     */
    public static UserInputResult exitRequested() {
        return new UserInputResult(UserInputAction.EXIT_REQUESTED, null);
    }

    /**
     * Returns the action requested by the user.
     *
     * @return the user input action
     */
    public UserInputAction getAction() {
        return action;
    }

    /**
     * Returns the integer entered by the user.
     *
     * <p>This method should only be called when the action is
     * {@link UserInputAction#NUMBER_ENTERED}. If no number was entered, this
     * method throws an exception.</p>
     *
     * @return the integer entered by the user
     */
    public int getValue() {
        if (!isNumberEntered()) {
            throw new IllegalStateException("No integer value is available for this input result.");
        }

        return value;
    }

    /**
     * Determines whether the user entered a number.
     *
     * @return true if the user entered a valid integer; otherwise false
     */
    public boolean isNumberEntered() {
        return action == UserInputAction.NUMBER_ENTERED;
    }

    /**
     * Determines whether the user requested a random number.
     *
     * @return true if the user requested a random number; otherwise false
     */
    public boolean isRandomRequested() {
        return action == UserInputAction.RANDOM_REQUESTED;
    }

    /**
     * Determines whether the user requested to exit.
     *
     * @return true if the user requested to exit; otherwise false
     */
    public boolean isExitRequested() {
        return action == UserInputAction.EXIT_REQUESTED;
    }
}
