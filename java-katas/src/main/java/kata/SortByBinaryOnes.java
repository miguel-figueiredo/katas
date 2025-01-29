package kata;

import java.util.*;

import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparing;

/**
 * https://www.codewars.com/kata/59eb28fb0a2bffafbb0000d6
 */
public class SortByBinaryOnes {
    public static Integer[] sort(Integer list[]) {
        return Arrays.stream(list)
                .map(Integer::toBinaryString)
                .sorted(SortByBinaryOnes::sort)
                .map(SortByBinaryOnes::toInt)
                .toList()
                .toArray(new Integer[0]);
    }

    private static int sort(final String s1, final String s2) {
        long count1 = count(s1);
        long count2 = count(s2);
        if (count1 == count2 && s1.length() == s2.length()) {
            return toInt(s1) - toInt(s2);
        } else if (count1 == count2) {
            return s1.length() - s2.length();
        } else {
            return (int) (count2 - count1);
        }
    }

    private static int toInt(final String s1) {
        return Integer.parseInt(s1, 2);
    }

    private static long count(String s) {
        return s.chars().filter(value -> value == '1').count();
    }

    // Pure java apis
    static Integer[] sortPureJava(final Integer[] list) {
        return Arrays.stream(list)
                .sorted(comparing(Integer::bitCount, reverseOrder())
                        .thenComparing(Integer::highestOneBit)
                        .thenComparing(Integer::compare))
                .toArray(Integer[]::new);
    }
}