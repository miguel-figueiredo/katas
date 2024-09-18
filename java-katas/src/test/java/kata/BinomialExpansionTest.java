package kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BinomialExpansionTest {

    @ParameterizedTest(name = "{0}")
    @MethodSource("source")
    void test(String expression, String result) {
        assertEquals(result, BinomialExpansion.expand(expression));
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of("(x+1)^0", "1"),
                Arguments.of("(x-1)^0", "1"),
                Arguments.of("(x+1)^1", "x+1"),
                Arguments.of("(x-1)^1", "x-1"),
                Arguments.of("(x+0)^1", "x"),
                Arguments.of("(-x+0)^1", "-x"),
                Arguments.of("(0x+1)^1", "1"),
                Arguments.of("(0x+0)^1", "0"),
                Arguments.of("(-0x+0)^1", "0"),
                Arguments.of("(-x+1)^1", "-x+1"),
                Arguments.of("(-1x+1)^1", "-x+1"),
                Arguments.of("(x+1)^2", "x^2+2x+1"));
    }

    //@Test
    void testBPositive() {
        assertEquals("x^2+2x+1", BinomialExpansion.expand("(x+1)^2"));
    }

    //@Test
    void testBNegative() {
        assertEquals("x-1", BinomialExpansion.expand("(x-1)^1"));
        assertEquals("x^2-2x+1", BinomialExpansion.expand("(x-1)^2"));
    }

    //@Test
    void testAPositive() {
        assertEquals("625m^4+1500m^3+1350m^2+540m+81", BinomialExpansion.expand("(5m+3)^4"));
        assertEquals("8x^3-36x^2+54x-27", BinomialExpansion.expand("(2x-3)^3"));
        assertEquals("1", BinomialExpansion.expand("(7x-7)^0"));
    }

    //@Test
    void testANegative() {
        assertEquals("625m^4-1500m^3+1350m^2-540m+81", BinomialExpansion.expand("(-5m+3)^4"));
        assertEquals("-8k^3-36k^2-54k-27", BinomialExpansion.expand("(-2k-3)^3"));
        assertEquals("1", BinomialExpansion.expand("(-7x-7)^0"));
    }
}