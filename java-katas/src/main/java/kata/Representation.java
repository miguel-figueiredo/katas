package kata;

import java.util.Arrays;
import java.util.BitSet;
import java.util.stream.IntStream;

/**
 * https://www.codewars.com/kata/58e93b4706db4d24ee000096
 */
public class Representation {
    public static int daysRepresented(int[][] trips) {
        return (int)Arrays.stream(trips)
                .flatMapToInt(trip -> IntStream.rangeClosed(trip[0], trip[1]))
                .distinct()
                .count();
    }

    // I really liked the bitset solution:
    public static int daysRepresentedBitSet (int[][] trips) {
        BitSet days = new BitSet(366);
        for (int[] trip : trips)
            days.set(trip[0], trip[1] + 1);
        return days.cardinality();
    }
}