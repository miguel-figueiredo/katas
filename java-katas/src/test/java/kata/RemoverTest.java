package kata;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RemoverTest {

    @ParameterizedTest
    @MethodSource("removerSource")
    void test(int[] input, int[] expected) {
        final int[] result = Remover.removeSmallest(input);

        assertArrayEquals(expected, result);
    }

    public static Stream<Arguments> removerSource() {
        return Stream.of(
                Arguments.of(new int[0], new int[0]),
                Arguments.of(new int[]{1}, new int[0]),
                Arguments.of(new int[]{1, 1}, new int[]{1}),
                Arguments.of(new int[]{1, 2}, new int[]{2}),
                Arguments.of(new int[]{1, 2, 1}, new int[]{2, 1}),
                Arguments.of(new int[]{2, 2, 1, 2, 1}, new int[]{2, 2, 2, 1})
        );
    }
}