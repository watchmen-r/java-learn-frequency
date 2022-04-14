import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Mergeintervals {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (nums1, nums2) -> Integer.compare(nums1[0], nums2[0]));

        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}