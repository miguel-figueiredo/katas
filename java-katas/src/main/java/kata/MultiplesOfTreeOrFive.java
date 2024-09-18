package kata;

import java.util.stream.IntStream;

public class MultiplesOfTreeOrFive {
    public static long calculate(final int value) {
        return IntStream.range(0, value)
                .filter(MultiplesOfTreeOrFive::isMultiple)
                .sum();
    }

    private static boolean isMultiple(int i) {
        return i % 3 == 0 || i % 5 == 0;
    }
}
