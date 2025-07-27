package leetcode;

import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }
    public static int[] dailyTemperatures(int[] temperatures){
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];
        int presentDay;
        for(presentDay = 0; presentDay < temperatures.length; presentDay++ ){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[presentDay]){
                int prevDay = stack.pop();
                answer[prevDay] = presentDay - prevDay;
            }
            stack.push(presentDay);
        }
        return answer;
    }
}
