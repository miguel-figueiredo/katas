package kata;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Last {
    public static <T> T last(final List<T> list) {
        return last(list.stream());
    }
    public static char last(final String string) {
        return (char)last(string.chars().boxed()).intValue();
    }
    public static <T> T last(final T... list) {
        return last(Arrays.stream(list));
    }

    private static <T> T last(final Stream<T> stream) {
        return stream.reduce((a, b) -> b).orElseThrow();
    }
}