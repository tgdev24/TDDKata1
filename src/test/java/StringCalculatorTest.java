import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.example.StringCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    void setup(){
        stringCalculator = new StringCalculator();
    }

    @Test
    void testAddEmptyString() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void testAddOneNum() {
        assertEquals(5, stringCalculator.add("5"));
    }

    @Test
    void testAddTwoNums() {
        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    void testAddMultipleNums() {
        assertEquals(6, stringCalculator.add("1,2,3"));
    }

    @Test
    void testAddMultipleNumsMultipleDigits() {
        assertEquals(356, stringCalculator.add("1,22,333"));
    }

    @Test
    void testAddNewLineOptions() {
        assertEquals(6, stringCalculator.add("1\n2,3"));
    }

    @Test
    void testAddCustomDelimiter() {
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }

    @Test
    void testAddCustomDelimiter2() {
        assertEquals(10, stringCalculator.add("//Hello\n1Hello2\n3,4"));
    }

    @Test
    void testAddANegativeNumbers() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("//Hello\n-1Hello2\n3,-4"));
        assertEquals("Negatives not allowed: -1, -4", exception.getMessage());
    }
}