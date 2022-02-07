import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> answer = new ArrayList<>();

    void recursive(StringBuilder sb, int n, int leftCount, int rightCount) {
        if(leftCount < rightCount) {
            return;
        }
        if(n == leftCount && n == rightCount) {
            answer.add(sb.toString());
            return;
        }

        if(leftCount < n) {
            sb.append("(");
            leftCount++;
            recursive(sb, n, leftCount, rightCount);
            sb.deleteCharAt(leftCount + rightCount - 1);
            leftCount--;
        }

        if(rightCount < n) {
            sb.append(")");
            rightCount++;
            recursive(sb, n, leftCount, rightCount);
            sb.deleteCharAt(leftCount + rightCount - 1);
            rightCount--;
        }
    }
    
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        recursive(sb, n, 1, 0);
        return answer;
    }
}