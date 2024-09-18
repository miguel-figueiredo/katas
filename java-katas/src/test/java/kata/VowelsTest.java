package kata;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VowelsTest {

    @ParameterizedTest
    @MethodSource("source")
    void test(String input, int expected) {
        assertEquals(expected, Vowels.getCount(input));
    }

    static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of("xyz", 0),
                Arguments.of("a", 1),
                Arguments.of("aeiou", 5),
                Arguments.of("xayeziqowus", 5)
        );
    }


}