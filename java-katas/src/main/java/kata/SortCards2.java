package kata;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

/**
 * https://www.codewars.com/kata/56f399b59821793533000683
 */
public class SortCards {

    static Map<String, Integer> cardMap = Map.ofEntries(
            entryOf("A", 1),
            entryOf("2", 2),
            entryOf("3", 3),
            entryOf("4", 4),
            entryOf("5", 5),
            entryOf("6", 6),
            entryOf("7", 7),
            entryOf("8", 8),
            entryOf("9", 9),
            entryOf("T", 10),
            entryOf("J", 11),
            entryOf("Q", 12),
            entryOf("K", 13)
    );

    static Entry<String, Integer> entryOf(String key, Integer value) {
        return new SimpleEntry<>(key, value);
    }

    public static String[] sortCards(String[] cards) {
        return Arrays.stream(cards).map(card -> entryOf(card, cardMap.get(card)))
                .sorted(Entry.comparingByValue())
                .map(Entry::getKey)
                .toArray(String[]::new);
    }
}
