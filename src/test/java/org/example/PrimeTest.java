package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83})
    void checkPrime(int num) {
        assertTrue(Prime.check(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27, 28, 30, 32, 33, 34, 35})
    void checkComposite(int num) {
        assertFalse(Prime.check(num));
    }

    @Test
    void checkThrows() {
        assertThrows(IllegalArgumentException.class, () -> Prime.check(1));
    }

    @Test
    void generate() {
        List<Integer> expected = List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47);
        List<Integer> actual = Prime.generate(50);
        List<Integer> actualFast = Prime.generateFast(50);
        List<Integer> actualWithCache = Prime.generateWithCache(50);
        List<Integer> actualPrimes = Prime.generatePrimes(50);

        assertEquals(expected, actual);
        assertEquals(expected, actualFast);
        assertEquals(expected, actualWithCache);
        assertEquals(expected, actualPrimes);
    }
}