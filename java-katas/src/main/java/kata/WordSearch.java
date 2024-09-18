package kata;

import java.util.Arrays;

/**
 * https://www.codewars.com/kata/54b81566cd7f51408300022d
 */
public class WordSearch {
    static String[] findWord(String needle, String[] haystack){
        var result = Arrays.stream(haystack)
                .filter(s -> containsIgnoreCase(needle, s))
                .toArray(String[]::new);

        return result.length == 0 ? new String[]{"Empty"} : result;
    }

    static boolean containsIgnoreCase(String needle, String haystack){
        return haystack.toLowerCase().contains(needle.toLowerCase());
    }
}
