import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubstringWithout {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;

        int answer = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            char letter = s.charAt(right);

            if (map.containsKey(letter)) {
                // ここが思いつかなかった。
                left = Math.max(map.get(letter) + 1, left);
            }
            answer = Math.max(answer, right - left + 1);
            map.put(letter, right);
            right++;
        }
        return answer;
    }
}
