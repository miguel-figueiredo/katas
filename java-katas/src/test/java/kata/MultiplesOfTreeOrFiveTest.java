package kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MultiplesOfTreeOrFiveTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void noMultiples(int value) {
        final long result = MultiplesOfTreeOrFive.calculate(value);

        assertEquals(0, result);
    }

    @Test
    void onlyMultiplesOfThree() {
        final long result = MultiplesOfTreeOrFive.calculate(4);

        assertEquals(3, result);
    }

    @Test
    void multipleOfThreeOrFive() {
        final long result = MultiplesOfTreeOrFive.calculate(10);

        assertEquals(23, result);
    }

    @Test
    void multipleOfThreeAndFive() {
        final long result = MultiplesOfTreeOrFive.calculate(16);

        assertEquals(60, result);
    }
}