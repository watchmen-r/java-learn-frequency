import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;

        Set<Integer> set = IntStream.of(nums).boxed().collect(Collectors.toSet());

        for (int i = 0; i < nums.length; i++) {
            int count = 1;

            // look left
            int num = nums[i];
            while (set.contains(--num)) {
                count++;
                set.remove(num);
            }

            // look right
            num = nums[i];
            while(set.contains(++num)) {
                count++;
                set.remove(num);
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public int longestConsecutiveAgain(int[] nums) {
        int max = 0;
        Set<Integer> set = IntStream.of(nums).boxed().collect(Collectors.toSet());

        for (int i = 0; i < nums.length; i++) {
            int consecutive = 1;
            int target = nums[i];
            while(set.contains(--target)) {
                consecutive++;
                set.remove(target);
            }
            target = nums[i];
            while(set.contains(++target)) {
                consecutive++;
                set.remove(target);
            }

            max = Math.max(max, consecutive);
        }
        return max;
    }
}