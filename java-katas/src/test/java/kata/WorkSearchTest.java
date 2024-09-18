package kata;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class WorkSearchTest {

    public static Stream<Arguments> wordSearchSource() {
        return Stream.of(
                Arguments.of(new String[0], "", new String[]{"Empty"}),
                Arguments.of(new String[0], "word", new String[]{"Empty"}),
                Arguments.of(new String[]{"no_match"}, "word", new String[]{"Empty"}),
                Arguments.of(new String[]{"home", "milk", "Mercury"}, "me", new String[]{"home", "Mercury"}),
                Arguments.of(new String[]{"lemonade", "limeade", "Yoo-Hoo", "root beer", "grapeade ", "water", "Mr. Pibb"}, "ade", new String[]{"lemonade", "limeade", "grapeade "})
        );
    }

    @ParameterizedTest
    @MethodSource("wordSearchSource")
    void wordSearch(String[] input, String word, String[] expected) {
        final String[] result = WordSearch.findWord(word, input);

        assertArrayEquals(expected, result);
    }
}