package kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SortCardsTest {

    public static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(
                        new String[]{},
                        new String[]{}),
                Arguments.of(
                        new String[]{"A"},
                        new String[]{"A"}),
                Arguments.of(
                        new String[]{"2", "A"},
                        new String[]{"A", "2"})
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(String[] input, String[] expected) {
        assertArrayEquals(expected, SortCards.sortCards(input));
    }
}