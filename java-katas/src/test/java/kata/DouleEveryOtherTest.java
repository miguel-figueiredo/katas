package kata;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DouleEveryOtherTest {

    @ParameterizedTest
    @MethodSource("source")
    void test(int[] input, int[] expected) {
        final int[] result = DouleEveryOther.doubleEveryOther(input);

        assertArrayEquals(expected, result);
    }

    static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(new int[0], new int[0]),
            Arguments.of(new int[]{1}, new int[]{1}),
            Arguments.of(new int[]{1, 2}, new int[]{1, 4}),
            Arguments.of(new int[]{1, 2, 3, 4}, new int[]{1, 4, 3, 8}),
            Arguments.of(new int[]{1, 19, 6, 2, 12, -3}, new int[]{1, 38, 6, 4, 12, -6}),
            Arguments.of(new int[]{-1000, 1653, 210, 0, 1}, new int[]{-1000, 3306, 210, 0, 1})


        );
    }
}