class Solution {
    public int calculate(String s) {
        int result = 0;
        int number = 0;
        int sign = 1;
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                number = number * 10 + (c - '0');
            }
            if (c == '+' || c == '-'){
                result += sign * number;
                number = 0;
                if (c == '+'){
                    sign = 1;
                } else {
                    sign = -1;
                }
            }
            if (c == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }
           if (c == ')'){
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        result += sign * number;
        return result;
    }
}
