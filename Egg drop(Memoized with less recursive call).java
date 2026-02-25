class Solution {

    int[][] dp;

    public int superEggDrop(int k, int n) {

        dp = new int[k + 1][n + 1];

        // Initialize dp with -1
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(k, n);
    }

    private int solve(int k, int n) {

        // Base cases
        if (n == 0 || n == 1) return n;
        if (k == 1) return n;

        if (dp[k][n] != -1) return dp[k][n];

        int min = Integer.MAX_VALUE;

        for (int x = 1; x <= n; x++) {

            int low, high;

            // break case
            if (dp[k - 1][x - 1] != -1) {
                low = dp[k - 1][x - 1];
            } else {
                low = solve(k - 1, x - 1);
                dp[k - 1][x - 1] = low;
            }

            // not break case (corrected)
            if (dp[k][n - x] != -1) {
                high = dp[k][n - x];
            } else {
                high = solve(k, n - x);
                dp[k][n - x] = high;
            }

            int temp = 1 + Math.max(low, high);
            min = Math.min(min, temp);
        }

        dp[k][n] = min;
        return min;
    }
}
