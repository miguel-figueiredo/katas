package kata;

import java.util.Arrays;

/**
 * https://www.codewars.com/kata/56f399b59821793533000683
 */
public class SortCards2 {

    public static String[] sortCards(String[] cards) {
        return Arrays.stream(cards)
                .sorted(SortCards2::compareCards)
                .toArray(String[]::new);
    }

    private static int compareCards(String a, String b) {
        return toOrder(a).compareTo(toOrder(b));
    }

    private static Integer toOrder(String card) {
        return switch (card) {
            case "A" -> 1;
            case "T" -> 10;
            case "J" -> 11;
            case "Q" -> 12;
            case "K" -> 13;
            default -> Integer.parseInt(card);
        };
    }
}
