package kata;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

/**
 * https://www.codewars.com/kata/588a3c3ef0fbc9c8e1000095
 */
public class MaxDiff {

    public static int maxDiff(int[] lst) {
        if (lst.length == 0) {
            return 0;
        } else {
            final IntSummaryStatistics stats = Arrays.stream(lst).summaryStatistics();
            return stats.getMax() - stats.getMin();
        }
    }
}