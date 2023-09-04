import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            if (map.containsKey(String.valueOf(chars))) {
                map.get(String.valueOf(chars)).add(str);
            } else {
                map.put(String.valueOf(chars), new ArrayList<>(){{
                    add(str);
                }});
            }
        }

        return map.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
    }
}