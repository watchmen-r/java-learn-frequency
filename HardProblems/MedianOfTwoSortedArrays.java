import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Double> list = new ArrayList<>();

        for (int n : nums1) {
            list.add(n * 1.0);
        }

        for (int n : nums2) {
            list.add(n * 1.0);
        }

        Collections.sort(list);

        if (list.size() % 2 == 1) {
            return list.get(list.size() / 2);
        }

        return (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2;

    }
}