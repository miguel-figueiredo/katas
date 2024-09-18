package kata;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PartlistTest {

    static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(
                        new String[] {"a", "b"},
                        new String[][] {{"a", "b"}}),
                Arguments.of(
                        new String[] {"cdIw", "tzIy", "xDu", "rThG"},
                        new String[][] {{"cdIw", "tzIy xDu rThG"}, {"cdIw tzIy", "xDu rThG"}, {"cdIw tzIy xDu", "rThG"}}),
                Arguments.of(
                        new String[] {"I", "wish", "I", "hadn't", "come"},
                        new String[][]{{"I", "wish I hadn't come"}, {"I wish", "I hadn't come"}, {"I wish I", "hadn't come"}, {"I wish I hadn't", "come"}}),
                Arguments.of(
                        new String[] {"vJQ", "anj", "mQDq", "sOZ"},
                        new String[][] {{"vJQ", "anj mQDq sOZ"}, {"vJQ anj", "mQDq sOZ"}, {"vJQ anj mQDq", "sOZ"}})
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(String[] input, String[][] expected) {
        assertArrayEquals(expected, Partlist.partlist(input));
    }
}