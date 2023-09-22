import java.util.Stack;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int answer = 0;
        Stack<int[]> stack = new Stack<>();
        int startIndex;
        for (int i = 0;i < heights.length; i++) {
            startIndex = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] target = stack.pop();
                int targetHorizontal = target[0];
                int targetHeight = target[1];
                answer = Math.max(answer, targetHeight * (i - targetHorizontal));
                startIndex = targetHorizontal;
            }
            stack.add(new int[]{startIndex, heights[i]});
        }

        while(!stack.isEmpty()) {
            int[] target = stack.pop();
            int targetHorizontal = target[0];
            int targetHeight = target[1];
            answer = Math.max(answer, targetHeight * (heights.length - targetHorizontal));
        }
        return answer;
    }
}
