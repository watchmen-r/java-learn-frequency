import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int answer = 0;
        for (int num: nums) {
            int miniAns = 1;

            int target = num;
            while(set.contains(++target)) {
                set.remove(target);
                miniAns++;
            }

            target = num;
            while(set.contains(--target)) {
                set.remove(target);
                miniAns++;
            }

            answer = Math.max(answer, miniAns);
        }
        return answer;
    }
}