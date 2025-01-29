package kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxDiffTest {

    @Test
    void tests() {
        assertEquals(4, MaxDiff.maxDiff(new int[]{ 1, 2, 3, 4, 5, 5, 4 }));
        assertEquals(30, MaxDiff.maxDiff(new int[]{ -4, -5, -3, -1, -31 }));
        assertEquals(10, MaxDiff.maxDiff(new int[]{ 1, 2, 3, 4, -5, 5, 4 }));
        assertEquals(0, MaxDiff.maxDiff(new int[]{ 1000000 }));
        assertEquals(0, MaxDiff.maxDiff(new int[]{}));
    }

}