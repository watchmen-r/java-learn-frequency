import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int max = 0;

        for (int num: nums) {
            int consecutive = 1;
            int target = num;
            while(set.contains(--target)) {
                consecutive++;
                set.remove(target);
            }
            target = num;
            while(set.contains(++target)) {
                consecutive++;
                set.remove(target);
            }

            max = Math.max(max, consecutive);
        }
        return max;
    }
}
