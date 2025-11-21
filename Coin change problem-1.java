class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int t[][] = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {

                if (j == 0)
                    t[i][j] = 0; // 0 coins needed to make amount 0

                else if (i == 0)
                    t[i][j] = 1000000; // large number (infinity)

            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {

                if (coins[i - 1] <= j) {
                    t[i][j] = Math.min(
                            1 + t[i][j - coins[i - 1]], // take coin
                            t[i - 1][j] // don't take
                    );
                } else {
                    t[i][j] = t[i - 1][j];
                }

            }
        }

        return (t[n][amount] >= 1000000) ? -1 : t[n][amount];
    }
}
