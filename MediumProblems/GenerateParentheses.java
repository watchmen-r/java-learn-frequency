import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> parentheses = new ArrayList<>();
    List<String> answer = new ArrayList<>();
    int num;
    public List<String> generateParenthesis(int n) {
        num = n;
        backTracking(0, 0);
        return answer;
    }

    void backTracking(int left, int right) {
        if (left + right == num * 2) {
            answer.add(parentheses.stream().reduce("", (a, b) -> a + b));
            return;
        } 

        if (left < num) {
            parentheses.add("(");
            backTracking(++left, right);
            parentheses.remove(parentheses.size() - 1);
            left--;
        }

        if (right < left) {
            parentheses.add(")");
            backTracking(left, ++right);
            parentheses.remove(parentheses.size() - 1);
            right--;
        }
    }
}