package kata;

import java.util.LinkedList;

// https://www.codewars.com/kata/5417423f9e2e6c2f040002ae
public class Digitize {

    public static int[] digitize(int n){
        if(n == 0) {
            return new int[]{0};
        }

        LinkedList<Integer> list = new LinkedList<>();
        while(n > 0) {
            list.addFirst(n % 10);
            n /= 10;
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
