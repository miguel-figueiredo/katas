package kata;

import java.util.stream.IntStream;

class RowSumOddNumbers {
    public static int rowSumOddNumbers(int n) {
        int offset = n * (n - 1) + 1;
        return IntStream.iterate(offset, x -> x + 2).limit(n).sum();
    }
}