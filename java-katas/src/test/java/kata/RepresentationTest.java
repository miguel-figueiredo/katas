package kata;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RepresentationTest {

    public static Stream<Arguments> values() {
        return Stream.of(
                Arguments.of(new int[0][0], 0),
                Arguments.of(new int[][]{}, 0),
                Arguments.of(new int[][]{{1,1}}, 1),
                Arguments.of(new int[][]{{1,2}, {2,3}}, 3),
                Arguments.of(new int[][]{{1,2}, {1,3}}, 3),
                Arguments.of(new int[][]{{1,2}}, 2),
                Arguments.of(new int[][]{{1,2}, {3,4}}, 4),
                Arguments.of(new int[][]{{10,15},{25,35}}, 17),
                Arguments.of(new int[][]{{2,8},{220,229},{10,16}}, 24)
        );
    }

    @ParameterizedTest
    @MethodSource("values")
    void test(int[][] trips, int expected) {
        assertEquals(expected, Representation.daysRepresented(trips));
    }

}