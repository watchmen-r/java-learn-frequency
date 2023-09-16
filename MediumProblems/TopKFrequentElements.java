import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> prQueue = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            prQueue.add(entry);
        }

        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = prQueue.poll().getKey();
        }
        return answer;
    }
}