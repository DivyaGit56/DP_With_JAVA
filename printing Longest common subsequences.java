public class PrintLCS {
    public static void main(String[] args) {
        String X = "abcde";
        String Y = "ace";

        int m = X.length();
        int n = Y.length();

        int[][] dp = new int[m + 1][n + 1];

        // Step 1: Build DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Step 2: Backtrack to print LCS
        int i = m, j = n;
        StringBuilder lcs = new StringBuilder();

        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs.append(X.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        System.out.println("LCS: " + lcs.reverse().toString());
    }
}
