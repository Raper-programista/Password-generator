package main;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertTrue;
import org.testng.annotations.Test;


class GeneratorTest {@Test
public void testPasswordLength() {
    Generator generator = new Generator();
    int[] counters = {3, 4, 5};
    int passwordLength = generator.generatePassword(counters).length();
    assertEquals(12, passwordLength);
}

    @Test
    public void testPasswordContainsSpecialCharacters() {
        Generator generator = new Generator();
        int[] counters = {0, 0, 5};
        String password = generator.generatePassword(counters);
        assertTrue(password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*"));
    }

    @Test
    public void testPasswordContainsNumbers() {
        Generator generator = new Generator();
        int[] counters = {0, 5, 0};
        String password = generator.generatePassword(counters);
        assertTrue(password.matches(".*\\d.*"));
    }

}