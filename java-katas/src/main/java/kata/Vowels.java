package kata;

import java.util.Arrays;

public class Vowels {

    public static long getCount(String str) {
        return Arrays.stream(str.split(""))
                .filter(Vowels::isVowel)
                .count();
    }

    private static boolean isVowel(String s) {
        return switch (s) {
            case "a" -> true;
            case "e" -> true;
            case "i" -> true;
            case "o" -> true;
            case "u" -> true;
            default -> false;
        };
    }
}
