package kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HighestAndLowestTest {

    @Test
    public void test1() {
        assertEquals("42 -9", HighestAndLowest.executeWithSort("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }
    @Test
    public void test2() {
        assertEquals("3 1", HighestAndLowest.executeWithSort("1 2 3"));
    }

    @Test
    public void test3() {
        assertEquals("42 -9", HighestAndLowest.executeSummary("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }
    @Test
    public void test4() {
        assertEquals("3 1", HighestAndLowest.executeSummary("1 2 3"));
    }

}