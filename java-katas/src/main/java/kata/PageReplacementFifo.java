package kata;

import java.util.Arrays;

/**
 * https://www.codewars.com/kata/62d34faad32b8c002a17d6d9
 */
public class PageReplacementFifo {
    public static int[] fifo(int n, int[] referenceList) {
        int[] fifo = Arrays.stream(new int[n]).map(i -> -1).toArray();

        for (int i = 0, fifoIndex = 0; i < referenceList.length; i++) {
            if(!contains(fifo, referenceList[i])) {
                fifo[fifoIndex] = referenceList[i];
                fifoIndex = (fifoIndex + 1) % n;
            }
        }
        return fifo;
    }

    private static boolean contains(final int[] fifo, final int i) {
        return Arrays.stream(fifo)
                .anyMatch(value -> value == i);
    }
}
