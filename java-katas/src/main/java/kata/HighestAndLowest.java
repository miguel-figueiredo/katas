package kata;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class HighestAndLowest {
    public static String executeWithSort(final String s) {
        final List<Integer> integers = Arrays.stream(s.split(" "))
                .map(Integer::valueOf).sorted().toList();

        return integers.get(integers.size() - 1) + " " + integers.get(0);
    }

    public static String executeSummary(final String s) {
        final IntSummaryStatistics statistics = Arrays.stream(s.split(" "))
                .mapToInt(Integer::valueOf).summaryStatistics();

        return statistics.getMax() + " " + statistics.getMin();
    }
}
