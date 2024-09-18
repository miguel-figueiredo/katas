package kata;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ListFilteringTest {

    @ParameterizedTest
    @MethodSource("listSource")
    void test(List<Object> input, List<Object> expected) {
        assertEquals(expected, ListFiltering.filterList(input));
    }

    public static Stream<Arguments> listSource() {
        return Stream.of(
                Arguments.of(List.of(), List.of()),
                Arguments.of(List.of(1, 2), List.of(1, 2)),
                Arguments.of(List.of("a", "b"), List.of()),
                Arguments.of(List.of(1, 2, "a", "b"), List.of(1, 2))
        );
    }
}