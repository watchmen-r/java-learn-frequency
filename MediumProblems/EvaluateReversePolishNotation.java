import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token: tokens) {
            if (token.equals("+")) {
                var num = stack.pop() + stack.pop();
                stack.add(num);
            } else if (token.equals("-")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.add(num2 - num1);
            } else if (token.equals("*")) {
                var num = stack.pop() * stack.pop();
                stack.add(num);
            } else if (token.equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.add(num2 / num1);
            } else {
                stack.add(Integer.parseInt(token));
            }

        }
        return stack.pop();
    }
}