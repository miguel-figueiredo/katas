package kata;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LastTest {

    @Test
    void testList() {
        final List<Integer> list = Arrays.asList(1, 2 ,3 ,4 ,5);
        final int last = Last.last(list);
        assertEquals(5, last);
    }
    @Test
    void testString() {
        final String string = "abcde";
        final char last = Last.last(string);
        assertEquals('e', last);
    }
    @Test
    void testArgs() {
        final int last = Last.last(1, 2 ,3 ,4 ,5);
        assertEquals(5, last);
    }
    @Test
    void testArray() {
        final Integer[] array = {1, 2 ,3 ,4 ,5};
        final int last = Last.last(array);
        assertEquals(5, last);
    }

}