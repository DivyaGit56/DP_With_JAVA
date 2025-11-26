class Solution {

    public int minCoins(int coins[], int sum) {
        int n = coins.length;
        int[][] t = new int[n+1][sum+1];
        // code here
        for(int i= 0; i<=n;i++){
            
                 t[i][0] = 0;
        }
        for(int j=0;j<=sum;j++){
                t[0][j] = Integer.MAX_VALUE-1;
            }
        
        
        for(int j= 1; j<=sum;j++){
            if(j%coins[0] == 0) t[1][j] =j/coins[0];
            else
            t[1][j] = Integer.MAX_VALUE-1;
        }
        for(int i= 2; i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(coins[i-1] <= j){
                    t[i][j] = Math.min(1+t[i][j-coins[i-1]],t[i-1][j]);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        int ans = t[n][sum];
        if (ans == Integer.MAX_VALUE - 1) return -1;

        return ans;
       
    }
}
