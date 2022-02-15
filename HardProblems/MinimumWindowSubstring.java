import java.util.HashMap;
import java.util.Map;

class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            // getOrDefaultは値がgetできなければ第二引数が渡される
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        // ユニークな文字で必要な数
        int required = dictT.size();

        int l = 0;
        int r = 0;

        // 必要な数が揃った文字をカウントする
        int formed = 0;

        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

        // スライドする際に使う(index1=window length, index2=left, index3=right)
        int[] ans = { -1, 0, 0 };

        while (r < s.length()) {
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);
            
            // 必要な数が揃ったらインクリメント
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // 必要な数が揃ったらスライドする
            while(l <= r && formed == required) {
                // windowの左の文字
                c = s.charAt(l);

                if(ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if(dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "": s.substring(ans[1], ans[2] + 1);
    }
}