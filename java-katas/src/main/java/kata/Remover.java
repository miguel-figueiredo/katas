package kata;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

/**
 * https://www.codewars.com/kata/563cf89eb4747c5fb100001b
 */
public class Remover {

    public static int[] removeSmallest(int[] numbers) {
        final IntSummaryStatistics statistics = Arrays.stream(numbers).summaryStatistics();
        final FilterFirst filterFirst = new FilterFirst(statistics.getMin());
        return Arrays.stream(numbers).filter(filterFirst::filter).toArray();
    }

    static class FilterFirst {
        private final int min;
        private boolean filtered;

        public FilterFirst(int min) {
            this.min = min;
        }

        boolean filter(int value) {
            var result = value > min || filtered;
            if (!result) {
                filtered = true;
            }
            return result;
        }
    }
}