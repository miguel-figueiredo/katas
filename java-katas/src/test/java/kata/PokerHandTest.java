package kata;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PokerHandTest {

    @Test
    void isStraight() {
        assertTrue(PokerHand.isStraight(new ArrayList<>(List.of(2, 3, 4, 5, 6))));
        assertFalse(PokerHand.isStraight(new ArrayList<>(List.of(2, 3, 3, 5, 6))));
        assertFalse(PokerHand.isStraight(new ArrayList<>(List.of(2, 3, 4, 5, 7))));
        assertTrue(PokerHand.isStraight(new ArrayList<>(List.of(2, 3, 3, 4, 5, 6))));
        assertTrue(PokerHand.isStraight(new ArrayList<>(List.of(2, 5, 6, 7, 8, 9))));
        assertTrue(PokerHand.isStraight(new ArrayList<>(List.of(14, 5, 4, 2, 3))));
        assertFalse(PokerHand.isStraight(new ArrayList<>(List.of(7, 7, 12, 11, 3, 4, 14))));
        assertFalse(PokerHand.isStraight(new ArrayList<>(List.of(7, 3, 2, 4, 14))));
        assertTrue(PokerHand.isStraight(new ArrayList<>(List.of(3, 14, 10, 4, 13, 2, 5))));
    }

}