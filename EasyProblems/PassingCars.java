// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {

    public int PassingCars(int[] A) {
        // write your code in Java SE 8

        int plus = 0;
        int sum = 0;
        for(int num: A) {
            if(num == 0) {
                plus += 1;
                continue;
            }

            sum += plus;
        }
        return sum;
    }
}