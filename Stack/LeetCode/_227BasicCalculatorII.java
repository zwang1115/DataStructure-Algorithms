package Stack.LeetCode;

import java.util.Stack;

public class _227BasicCalculatorII {

    /**
     * Time: O(n)
     * Space: O(n)
     * @param s
     * @return
     */
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int res = 0;
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                if (sign == '+') stack.push(num);
                if (sign == '-') stack.push(-num);
                if (sign == '*') stack.push(stack.pop() * num);
                if (sign == '/') stack.push(stack.pop() / num);
                sign = s.charAt(i);
                num = 0;
            }
        }

        for (int i : stack) {
            res += i;
        }
        return res;
    }


    /**
     * Time: O(n)
     * Space: O(1)
     * @param s
     * @return
     */
    public int calculate2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim().replaceAll(" +", "");
        int i = 0;
        int preVal = 0;
        char sign = '+';
        int res = 0;
        while (i < s.length()) {
            int curVal = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                curVal = curVal * 10 + s.charAt(i) - '0';
                i++;
            }
            if (sign == '+') {
                res += preVal;
                preVal = curVal;
            } else if (sign == '-') {
                res += preVal;
                preVal = -curVal;
            } else if (sign == '*') {
                preVal = preVal * curVal;
            } else if (sign == '/') {
                preVal = preVal / curVal;
            }
            if (i < s.length()) {
                sign = s.charAt(i);
                i++;
            }
        }
        res += preVal;
        return res;
    }
}
