package kata;

import java.util.stream.IntStream;

public class DouleEveryOther {

    public static int[] doubleEveryOther(int[] a) {
        return IntStream.range(0, a.length).map(i -> i % 2 == 0 ? a[i] : a[i] * 2).toArray();
    }
}
