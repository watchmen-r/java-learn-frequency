import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> temp = new ArrayList<>();
    List<String> answer = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return answer;
    }

    void backtrack(int openN, int closeN, int n) {
        if (temp.size() == n * 2) {
            String tmpAnswer = temp.stream().reduce("", (sub, element) -> sub + element);
            answer.add(tmpAnswer);
        }

        if (openN < n) {
            temp.add("(");
            backtrack(++openN, closeN, n);
            temp.remove(temp.size()-1);
            openN--;
        }

        if (closeN < n && closeN < openN) {
            temp.add(")");
            backtrack(openN, ++closeN, n);
            temp.remove(temp.size()-1);
            closeN--;
        }
    }
}