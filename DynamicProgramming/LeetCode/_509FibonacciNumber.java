package DynamicProgramming.LeetCode;

public class _509FibonacciNumber {

    /**
     * Recursion
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * Recursion using memorization
     */
    int[] memorization = new int[15464691];
    public int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        if (memorization[n] == 0) {
            memorization[n] = fib2(n - 1) + fib2(n - 2);
        }
        return memorization[n];

    }

    /**
     * Dynamic programming(best)
     * @param n
     * @return
     */
    public int fib3(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * Using while
     * @param n
     * @return
     */
    public int fib4(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        while (n-- > 1) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
