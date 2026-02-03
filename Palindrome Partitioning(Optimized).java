class Solution {
    static int[][] dp;
    static boolean[][] pal;

    static int solve(String s, int i, int j) {

        if (i >= j) return 0;

        if (pal[i][j]) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {

            if (pal[i][k]) {
                int right = solve(s, k + 1, j);
                min = Math.min(min, 1 + right);
            }
        }

        return dp[i][j] = min;
    }

    static int palPartition(String s) {

        int n = s.length();

        dp = new int[n][n];
        pal = new boolean[n][n];

        // Initialize dp
        for (int i = 0; i < n; i++)
            java.util.Arrays.fill(dp[i], -1);

        // Precompute palindrome table
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {

                if (gap == 0)
                    pal[i][j] = true;

                else if (gap == 1)
                    pal[i][j] = (s.charAt(i) == s.charAt(j));

                else
                    pal[i][j] = (s.charAt(i) == s.charAt(j)) && pal[i + 1][j - 1];
            }
        }

        return solve(s, 0, n - 1);
    }
}
