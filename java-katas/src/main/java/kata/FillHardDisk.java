package kata;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://www.codewars.com/kata/5d49c93d089c6e000ff8428c
 */
public class FillHardDisk {
  public static int save(int[] sizes, int hd) {
      AtomicInteger sum = new AtomicInteger(0);
      return (int)Arrays.stream(sizes).takeWhile(size -> sum.addAndGet(size) <= hd).count();
  }
}