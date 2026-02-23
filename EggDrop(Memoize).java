class Solution {

    int[][] dp;

    public int superEggDrop(int k, int n) {

        dp = new int[k + 1][n + 1];
        return solve(k, n);
    }

    private int solve(int k, int n) {

        // Base cases
        if (n == 0 || n == 1) return n;
        if (k == 1) return n;

        // If already calculated
        if (dp[k][n] != 0) return dp[k][n];

        int min = Integer.MAX_VALUE;

        for (int x = 1; x <= n; x++) {

            int breakCase = solve(k - 1, x - 1);
            int notBreakCase = solve(k, n - x);

            int temp = 1 + Math.max(breakCase, notBreakCase);

            min = Math.min(min, temp);
        }

        dp[k][n] = min;
        return min;
    }
}
