import java.util.Stack;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int answer = 0, n = heights.length;
        // Defines index 0 is horizontal axis, index 1 is height
        Stack<int[]> stack = new Stack<>();

        // Assigns index to store at the stack. If current coordinate is lower than past coordinate,
        // can use this variable to calculate.
        int startIndex;
        for (int i = 0; i < heights.length; i++) {
            startIndex = i;
            while(!stack.empty() && stack.peek()[1] > heights[i]) {
                int[] target = stack.pop();
                int horizontalIndex = target[0];
                int height = target[1];
                answer = Math.max(answer, height * (i - horizontalIndex));
                startIndex = horizontalIndex;
            }
            // When calculate next, we use horizontalIndex whose height is more lower.
            stack.push(new int[]{startIndex, heights[i]});
        }

        while(!stack.empty()) {
            int[] target = stack.pop();
            int horizontalIndex = target[0];
            int height = target[1];
            answer = Math.max(answer, height * (n - horizontalIndex));
        }
        return answer;
    }
}
