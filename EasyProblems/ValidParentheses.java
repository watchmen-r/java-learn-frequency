import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            if (target == '(' || target == '{' || target == '[') {
                stack.add(target);
            }

            if (stack.size() == 0) {
                return false;
            }

            if (target == ')' && stack.pop() != '(') {
                return false;
            }

            if (target == '}' && stack.pop() != '{') {
                return false;
            }

            if (target == ']' && stack.pop() != '[') {
                return false;
            }
        }

        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
