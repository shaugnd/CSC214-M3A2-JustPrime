package edu.csc214.m3a2.justprime;

import java.util.ArrayList;
import java.util.Random;

/**
 * Generates goofy messages for random-number prime factor requests.
 */

// Just having a bit of fun here and exploring working with classes again.
public class CosmicMessageGenerator {
    private final ArrayList<String> messageTemplates;
    private final Random random;

    /**
     * Creates a cosmic message generator with a default list of messages.
     */
    public CosmicMessageGenerator() {
        messageTemplates = new ArrayList<>();
        random = new Random();

        loadDefaultMessages();
    }

    /**
     * Generates a random cosmic message for the provided number.
     *
     * @param number the random number selected by the driver program
     * @return a goofy message containing the selected number
     */
    public String generate(int number) {
        int messageIndex = random.nextInt(messageTemplates.size());
        String template = messageTemplates.get(messageIndex);

        return String.format(template, number);
    }

    /**
     * Adds another message template to the generator.
     *
     * <p>The message should include %d where the selected number should appear.</p>
     *
     * @param messageTemplate the message template to add
     */
    public void addMessage(String messageTemplate) {
        messageTemplates.add(messageTemplate);
    }

    /**
     * Loads the default goofy message templates.
     */
    // Note, the messages below were generated with the help of ChatGPT. I asked it to generate 
    // 50 goofy messages for a random number generator that would be used in a prime factorization program. 
    // I then edited the results to make them more suitable and to ensure they all included the 
    // %d placeholder for the number.
    
    private void loadDefaultMessages() {
        messageTemplates.add("You have asked the cosmos for a sign, and the sign is %d! Your lucky prime factors are: ");
        messageTemplates.add("The universe checked its pockets and found %d. Its prime factors are: ");
        messageTemplates.add("A mysterious raccoon has selected %d. The prime factors are: ");
        messageTemplates.add("The ancient spreadsheet has spoken. It chose %d. The prime factors are: ");
        messageTemplates.add("The algorithmic oracle points dramatically at %d. The prime factors are: ");
        messageTemplates.add("A tiny wizard living in the CPU chose %d. The prime factors are: ");
        messageTemplates.add("The probability goblin rolled %d. The prime factors are: ");
        messageTemplates.add("A cosmic vending machine dispensed %d. The prime factors are: ");
        messageTemplates.add("The math spirits whispered %d through the vents. The prime factors are: ");
        messageTemplates.add("Your keyboard briefly achieved enlightenment and selected %d. The prime factors are: ");
        messageTemplates.add("The prime-factor fairy dropped %d on your desk. The prime factors are: ");
        messageTemplates.add("A committee of confused integers voted for %d. The prime factors are: ");
        messageTemplates.add("The universe sneezed and produced %d. The prime factors are: ");
        messageTemplates.add("A fortune cookie printed %d instead of wisdom. The prime factors are: ");
        messageTemplates.add("The random-number hamster has sprinted to %d. The prime factors are: ");
        messageTemplates.add("The moon, probably bored, selected %d. The prime factors are: ");
        messageTemplates.add("The cosmic help desk assigned ticket number %d. The prime factors are: ");
        messageTemplates.add("A bored calculator dreamed of %d. The prime factors are: ");
        messageTemplates.add("The sacred abacus landed on %d. The prime factors are: ");
        messageTemplates.add("Somewhere, a math teacher just sensed %d. The prime factors are: ");
        messageTemplates.add("The integers held a talent show, and %d won. The prime factors are: ");
        messageTemplates.add("The silicon gremlins recommend %d. The prime factors are: ");
        messageTemplates.add("The ghost in the machine says %d. The prime factors are: ");
        messageTemplates.add("The stars aligned badly but produced %d anyway. The prime factors are: ");
        messageTemplates.add("A rubber duck debugged the universe and found %d. The prime factors are: ");
        messageTemplates.add("The randomizer has chosen %d with suspicious confidence. The prime factors are: ");
        messageTemplates.add("The number goblin coughed up %d. The prime factors are: ");
        messageTemplates.add("A wandering bit flipped into %d. The prime factors are: ");
        messageTemplates.add("The cosmic lottery machine spat out %d. The prime factors are: ");
        messageTemplates.add("The prime minister of Prime Factors nominates %d. The prime factors are: ");
        messageTemplates.add("A committee of hamsters in lab coats selected %d. The prime factors are: ");
        messageTemplates.add("The database of destiny returned %d. The prime factors are: ");
        messageTemplates.add("A suspiciously confident AI picked %d. The prime factors are: ");
        messageTemplates.add("The universe found %d under the couch cushions. The prime factors are: ");
        messageTemplates.add("A dragon with a calculator chose %d. The prime factors are: ");
        messageTemplates.add("The command line mumbled %d in its sleep. The prime factors are: ");
        messageTemplates.add("The cosmic IT department rebooted and landed on %d. The prime factors are: ");
        messageTemplates.add("The enchanted whiteboard has written %d. The prime factors are: ");
        messageTemplates.add("A passing cloud looked like %d. The prime factors are: ");
        messageTemplates.add("The math goblin accepts your offering and returns %d. The prime factors are: ");
        messageTemplates.add("The random number wheel made a weird noise and stopped at %d. The prime factors are: ");
        messageTemplates.add("A stack trace from another dimension points to %d. The prime factors are: ");
        messageTemplates.add("The cosmic compiler emitted warning %d. The prime factors are: ");
        messageTemplates.add("The sacred coffee mug has revealed %d. The prime factors are: ");
        messageTemplates.add("A flock of binary pigeons arranged themselves into %d. The prime factors are: ");
        messageTemplates.add("The universe has placed %d in your cart. The prime factors are: ");
        messageTemplates.add("A number wizard wearing Crocs selected %d. The prime factors are: ");
        messageTemplates.add("The randomizer coughed, apologized, and handed over %d. The prime factors are: ");
        messageTemplates.add("The cosmos says %d. Now go get a lottery ticket. If you win, I could use some more RAM. That stuff is really expensive these days. Your lucky prime factors are: ");
        messageTemplates.add("The celestial help menu recommends %d. Press any key to contemplate its prime factors: ");
    }
}
