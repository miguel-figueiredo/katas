package kata;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Partlist {
    
    public static String[][] partlist(String[] arr) {
        return IntStream.range(0, arr.length - 1)
                .mapToObj(i -> splitAt(arr, i)).toArray(String[][]::new);
    }

    public static String[] splitAt(String[] arr, int index) {
        String first = String.join(" ", Arrays.copyOfRange(arr, 0, index + 1));
        String second = String.join(" ", Arrays.copyOfRange(arr, index + 1, arr.length));
        return new String[]{first, second};
    }
}