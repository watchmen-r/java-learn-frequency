import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        var stack = new Stack<StackTemperature>();
        int[] answer = new int[temperatures.length];
        
        for (int i = 0; i < temperatures.length; i++) {
            int currentDate = i;
            var data = new StackTemperature(){
                {
                    date = currentDate;
                    temperature = temperatures[currentDate];
                }
            };
            while (!stack.empty() && stack.peek().temperature < temperatures[i]) {
                var target = stack.pop();
                answer[target.date] = i - target.date;
            }
            stack.add(data);
        }

        while(!stack.empty()) {
            var target = stack.pop();
            answer[target.date] = 0;
        }
        return answer;
    }
}

class StackTemperature {
    int date;
    int temperature;
}
