import java.util.Arrays;
import java.util.Comparator;

class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int s1SpaceIndex = s1.indexOf(' ');
                int s2SpaceIndex = s2.indexOf(' ');
                char s1First = s1.charAt(s1SpaceIndex + 1);
                char s2First = s2.charAt(s2SpaceIndex + 1);

                // 文字ログか数字ログか、もしくは数字ログ同士か
                if(s1First <= '9') {
                    if(s2First <= '9') return 0;
                    else return 1;
                }
                if(s2First <= '9') return -1;

                // 文字ログは辞書順に並べる
                int preCompute = s1.substring(s1SpaceIndex+1).compareTo(s2.substring(s2SpaceIndex+1));
                if (preCompute == 0) return s1.substring(0,s1SpaceIndex).compareTo(s2.substring(0,s2SpaceIndex));
                return preCompute;
            }
        };
        Arrays.sort(logs, myComp);
        return logs;
    }
}