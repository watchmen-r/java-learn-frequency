import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupAnagrams {
    public static void main(String[] args) {

    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = Arrays.toString(chars);

            map.putIfAbsent(sorted, new ArrayList<String>());
            map.get(sorted).add(str);
        }

        List<List<String>> answer = new ArrayList<>();
        for(String key: map.keySet()) {
            answer.add(map.get(key));
        }
        return answer;
    }
}