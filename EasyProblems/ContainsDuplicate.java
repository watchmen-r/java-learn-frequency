import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        int total = nums.length;
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        if (total == set.size()) {
            return false;
        }
        return true;
    }
}
