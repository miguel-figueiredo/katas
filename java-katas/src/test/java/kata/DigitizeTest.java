package kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DigitizeTest {

    public static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(0, new int[]{0}),
                Arguments.of(10, new int[]{1, 0}),
                Arguments.of(11, new int[]{1, 1}),
                Arguments.of(19, new int[]{1, 9}),
                Arguments.of(20, new int[]{2, 0}),
                Arguments.of(100, new int[]{1, 0, 0}),
                Arguments.of(123, new int[]{1, 2, 3}),
                Arguments.of(132, new int[]{1, 3, 2}),
                Arguments.of(210, new int[]{2, 1, 0}),
                Arguments.of(1000, new int[]{1, 0, 0, 0}),
                Arguments.of(1234, new int[]{1, 2, 3, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void name(int input, int[] expected) {
        assertArrayEquals(expected, Digitize.digitize(input));
    }
}