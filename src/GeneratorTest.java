import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class GeneratorTest {

    @Test
    public void testCreateTable() {
        char[] letters = Generator.createTable(65, 122, 'l');
        char[] numbers = Generator.createTable(48, 57, 'n');
        char[] specials = Generator.createTable(33, 125, 's');

        assertNotNull(letters);
        assertNotNull(numbers);
        assertNotNull(specials);

        assertTrue(letters.length > 0);
        assertTrue(numbers.length > 0);
        assertTrue(specials.length > 0);
    }
    @Test
    public void testCreateTable() {
        char[] letters = Generator.createTable(65, 122, 'l');
        char[] numbers = Generator.createTable(48, 57, 'n');
        char[] specials = Generator.createTable(33, 125, 's');

        assertNotNull(letters);
        assertNotNull(numbers);
        assertNotNull(specials);

        assertTrue(letters.length > 0);
        assertTrue(numbers.length > 0);
        assertTrue(specials.length > 0);
    }
    @Test
    public void testPasswordLength() {
        Generator generator = new Generator();
        String password = generator.generatePassword();
        int lettersCount = 3;
        int numbersCount = 2;
        int specialsCount = 4;
        int expectedLength = lettersCount + numbersCount + specialsCount;
        int actualLength = password.length();
        assertTrue(expectedLength == actualLength);
    }

    @Test
    public void testPasswordContent() {
        Generator generator = new Generator();
        String password = generator.generatePassword();
        int lettersCount = 3;
        int numbersCount = 2;
        int specialsCount = 4;
        int expectedLetters = 0;
        int expectedNumbers = 0;
        int expectedSpecials = 0;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isLetter(c)) {
                expectedLetters++;
            } else if (Character.isDigit(c)) {
                expectedNumbers++;
            } else {
                expectedSpecials++;
            }
        }
        assertTrue(expectedLetters == lettersCount);
        assertTrue(expectedNumbers == numbersCount);
        assertTrue(expectedSpecials == specialsCount);
    }
}