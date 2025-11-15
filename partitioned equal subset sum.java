class Solution {
    public Boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int i = 0; i<n; i++){
            sum = sum+nums[i];
        }
            if(sum%2 != 0){
                return false;
            }
                 int target = sum/2;
                Boolean[][]dp = new Boolean[n][target+1];
                

                
                return canPartition(nums,0,target,dp);
            }
    
    
        private Boolean canPartition(int []nums, int i, int target, Boolean[][]dp){
             int n = nums.length;
            if(target == 0)return true;
            if(i>= n || target<0)return false; // boundary cond

            if(dp[i][target] != null) return dp[i][target];


            Boolean take = canPartition(nums, i+1, target-nums[i], dp);
            Boolean nottake = canPartition(nums, i+1,target, dp );
            return dp[i][target] = (take||nottake);
        

        
    }
}
