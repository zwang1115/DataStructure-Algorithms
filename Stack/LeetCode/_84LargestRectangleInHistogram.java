package Stack.LeetCode;

import java.util.Stack;

public class _84LargestRectangleInHistogram {

    /**
     * Time: O(n)
     * Space: O(n)
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i <= heights.length; i++) {
            int hi = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && hi < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int start = stack.isEmpty() ? -1 : stack.peek();
                int distance = i - start - 1;
                int area = height * distance;
                res = Math.max(res, area);
            }
            stack.push(i);
        }
        return res;
    }
}
