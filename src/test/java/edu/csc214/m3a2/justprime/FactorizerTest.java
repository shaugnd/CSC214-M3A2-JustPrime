package edu.csc214.m3a2.justprime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Tests the {@link Factorizer} class.
 */
public class FactorizerTest {
    /**
     * Tests that zero has no prime factors.
     */
    @Test
    public void zeroHasNoPrimeFactors() {
        Factorizer factorizer = new Factorizer();

        assertEquals(List.of(), factorizer.primeFactors(0));
    }

    /**
     * Tests that one has no prime factors.
     */
    @Test
    public void oneHasNoPrimeFactors() {
        Factorizer factorizer = new Factorizer();

        assertEquals(List.of(), factorizer.primeFactors(1));
    }

    /**
     * Tests that a prime number returns itself as its only prime factor.
     */
    @Test
    public void primeNumberReturnsItself() {
        Factorizer factorizer = new Factorizer();

        assertEquals(List.of(13), factorizer.primeFactors(13));
    }

    /**
     * Tests that a composite number returns repeated prime factors.
     */
    @Test
    public void compositeNumberReturnsPrimeFactors() {
        Factorizer factorizer = new Factorizer();

        assertEquals(List.of(2, 2, 3), factorizer.primeFactors(12));
    }

    /**
     * Tests that an odd composite number returns repeated odd prime factors.
     */
    @Test
    public void oddCompositeNumberReturnsPrimeFactors() {
        Factorizer factorizer = new Factorizer();

        assertEquals(List.of(3, 3), factorizer.primeFactors(9));
    }

    /**
     * Tests a larger composite number with several prime factors.
     */
    @Test
    public void largerCompositeNumberReturnsPrimeFactors() {
        Factorizer factorizer = new Factorizer();

        assertEquals(List.of(2, 3, 5, 7), factorizer.primeFactors(210));
    }

    /**
     * Tests that a prime number is identified as prime.
     */
    @Test
    public void primeNumberIsPrime() {
        Factorizer factorizer = new Factorizer();

        assertTrue(factorizer.isPrime(17));
    }

    /**
     * Tests that a composite number is not identified as prime.
     */
    @Test
    public void compositeNumberIsNotPrime() {
        Factorizer factorizer = new Factorizer();

        assertFalse(factorizer.isPrime(21));
    }

    /**
     * Tests that one is not identified as prime.
     */
    @Test
    public void oneIsNotPrime() {
        Factorizer factorizer = new Factorizer();

        assertFalse(factorizer.isPrime(1));
    }

    /**
     * Tests that a composite number is identified as composite.
     */
    @Test
    public void compositeNumberIsComposite() {
        Factorizer factorizer = new Factorizer();

        assertTrue(factorizer.isComposite(21));
    }

    /**
     * Tests that a prime number is not identified as composite.
     */
    @Test
    public void primeNumberIsNotComposite() {
        Factorizer factorizer = new Factorizer();

        assertFalse(factorizer.isComposite(17));
    }

    /**
     * Tests that one is not identified as composite.
     */
    @Test
    public void oneIsNotComposite() {
        Factorizer factorizer = new Factorizer();

        assertFalse(factorizer.isComposite(1));
    }
}
