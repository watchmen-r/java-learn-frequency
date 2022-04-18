import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> allocator = new PriorityQueue<Integer>(
            intervals.length,
            new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    return a - b;
                }
            });
        
        Arrays.sort(intervals, (nums1, nums2) -> Integer.compare(nums1[0], nums2[0]));

        // Add the first meeting
        allocator.add(intervals[0][1]);

        for(int i = 1; i < intervals.length; i++) {
            // If the room due to free up the earliest is free, assign that room to this meeting
            if(intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }
            allocator.add(intervals[i][1]);
        }
        return allocator.size();
    }
}