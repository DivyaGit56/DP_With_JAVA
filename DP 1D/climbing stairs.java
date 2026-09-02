class Solution {
    int dp[];
    public int solve(int n){
        if(n<=2){
            return n;
        }
        dp[n] = solve(n-1)+solve(n-2);
        return dp[n];
    }
    public int climbStairs(int n) {
        // RECURSION

  if(n<=2){
    return n;
}
return climbStairs(n-1)+climbStairs(n-2);

// RECURSION + MEMOIZATION

dp = new int [n+1];
Arrays.fill(dp,-1);
return solve(n);

// Bottom up

int dp [] = new int[n+1];
dp[0] = 1;
dp[1] = 1;

for(int i = 2; i<=n; i++){
    dp[i] = dp[i-1]+dp[i-2];
}
    return dp[n];    
    }
}
