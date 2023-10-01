import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> answer = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backTracking(0, 0, n, list);
        return answer;
    }

    private void backTracking(int left, int right, int n, List<String> list) {
        if (left == n && right == n) {
            String parentheses = list.stream().reduce("", (a, b) -> a + b);
            answer.add(parentheses);
        }

        if (left < n) {
            list.add("(");
            backTracking(++left, right, n, list);
            left--;
            list.remove(list.size() - 1);
        }

        if (right < left) {
            list.add(")");
            backTracking(left, ++right, n, list);
            right--;
            list.remove(list.size() - 1);
        }
    }
}