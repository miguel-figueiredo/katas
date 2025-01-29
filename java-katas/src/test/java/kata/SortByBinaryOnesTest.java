package kata;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortByBinaryOnesTest {
    public static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(new Integer[]{1, 2}, new Integer[]{1, 2}),
                Arguments.of(new Integer[]{2, 1}, new Integer[]{1, 2}),
                Arguments.of(new Integer[]{3, 1}, new Integer[]{3, 1}),
                Arguments.of(new Integer[]{1, 3}, new Integer[]{3, 1}),
                Arguments.of(new Integer[]{1, 2, 3, 4}, new Integer[]{3, 1, 2, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    public void testSort(Integer[] list, Integer[] expected) {
        SortByBinaryOnes sortByBinary = new SortByBinaryOnes();
        final Integer[] result = sortByBinary.sort(list);
        assertArrayEquals(expected, result);

    }
}