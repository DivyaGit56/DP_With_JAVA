class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int max = 0;

        for(int num:nums){
            max = Math.max(max,num);
        }

        int pointGet[] = new int[max+1];  // at each index , how much point i earn by delete it

        for(int num:nums){
            pointGet[num] += num;
        }
        

        

        int dp[] = new int [max+1];
        dp[0] = 0;
        if(max >= 1){
        dp[1] = pointGet[1];
        }
        for(int i = 2; i<=max; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+pointGet[i]);
        }
        return dp[max];
    }
}
