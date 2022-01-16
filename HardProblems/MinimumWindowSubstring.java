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

        // tにあるユニークな文字数を格納
        int formed = 0;

        
    }
}