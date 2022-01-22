import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        String str = paragraph.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();

        String[] words = str.split("\\s+");

        List<String> bans = Arrays.asList(banned);
        Map<String, Integer> map = new HashMap<>();

        for(String word: words) {
            if(!bans.contains(word)) {
                map.putIfAbsent(word, 0);
                map.put(word, map.get(word) + 1);
            }
        }

        String answer = "";
        int maxNum = 0;
        for(String key: map.keySet()) {  
            if(map.get(key) > maxNum) {
                answer = key;
                maxNum = map.get(key);
            }
        }
        return answer;
    }
}