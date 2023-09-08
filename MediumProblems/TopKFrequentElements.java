import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num: nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // If write using the anonymous classes
        // PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
        //     public int compare(Integer a, Integer b){
        //         return map.get(b)-map.get(a);
        //     }
        // });
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));

        for (Map.Entry<Integer, Integer> entry: countMap.entrySet()) {
            queue.add(entry);
        }

        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = queue.poll().getKey();
        }
        return answer;
    }

    public int[] topKFrequentAgain(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Entry<Integer, Integer> entry: map.entrySet()) {
            queue.add(entry);
        }

        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = queue.poll().getKey();
        }

        return answer;
    }
}