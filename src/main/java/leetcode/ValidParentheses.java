package leetcode;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {

    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char parentheses : s.toCharArray()){
            if(parentheses == '(' || parentheses == '{' || parentheses == '['){
                stack.push(parentheses);
            } else if (parentheses == ')') {
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }else return false;
            } else if (parentheses == '}'){
                if(!stack.isEmpty() && stack.peek()=='{'){
                    stack.pop();
                }else return false;
            } else if(parentheses == ']'){
                if(!stack.isEmpty() && stack.peek()=='['){
                    stack.pop();
                }else return false;
            }
        }
        return stack.isEmpty();
    }
}
