import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithout {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int count = 0;
        int ahead = 0;

        while(ahead < s.length()) {
            if(map.containsKey(s.charAt(ahead))) {
                max = Math.max(max, count);
                int tmp = ahead;
                ahead = map.get(s.charAt(ahead)) + 1;
                map.put(s.charAt(tmp), tmp);
                count = 0;
            } else {
                map.put(s.charAt(ahead), ahead);
                ahead++;
                count++;
            }
        }
        return max;
    }
}
