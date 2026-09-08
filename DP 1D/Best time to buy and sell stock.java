class Solution {
    public int maxProfit(int[] prices) {
          


    //    int maxProfit = 0;

    //     for(int i=0; i<prices.length; i++){
            
        
    // for(int j = i+1; j<prices.length; j++){
    //         maxProfit = Math.max(maxProfit,prices[j]-prices[i]);
    // }
    //     }
    //     return maxProfit;

    // APPROACH-2

    // int bestBuy = prices[0];
    // int maxP = 0;

    // for(int j = 1; j<prices.length; j++){
    //     maxP = Math.max(maxP,prices[j]-bestBuy);

    
    // if(prices[j]<bestBuy){
    //     bestBuy = prices[j];
    // }
    // }
    // return maxP;


    int n = prices.length;
    
   
    int[] min = new int[n];
        min[0] = prices[0];

        // Minimum price till each day
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(min[i - 1], prices[i]);
        }


    int dp[] = new int[n];
    dp[0] = 0;
    for(int i = 1; i<n; i++){
        dp[i] = Math.max(dp[i-1],prices[i]-min[i]);
    }
    return dp[n-1];
    }
}
