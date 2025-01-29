package kata;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.codewars.com/kata/582afcadac2d9baa0900054c
 */
public final class PokerHand {
    public static boolean isStraight(ArrayList<Integer> cards) {
        if(cards.contains(14)) {
            cards.add(1);
        }
        final List<Integer> sorted = cards.stream().sorted().distinct().toList();

        for (int i = 0; i < 4 && i < sorted.size() - 1; i++) {
            final List<Integer> candidate = sorted.stream().skip(i).limit(5).toList();
            if(candidate.size() == 5 && candidate.get(4) - candidate.get(0) == 4) {
                return true;
            }
        }

        return false;
    }
}