class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int mod = 1000000007;// to avoid overflow
        // code here
        int [][]t = new int [n+1][target+1];
        
        // initialization
        for(int i = 0; i<=n; i++){
            for(int j = 0; j<=target; j++){
                if(i == 0) t[i][j] = 0;
                if(j == 0) t[i][j] = 1;
            }
        }
        
        // code
        for(int i = 1; i<=n; i++){
            for(int j = 0; j<=target; j++){
                if(nums[i-1] <= j){
                    t[i][j] =   (t[i-1][j] + t[i-1][j-nums[i-1]])%mod;
                    
                }else{
                    t[i][j] = t[i-1][j];
                }
                
                
            }
        }
                return t[n][target];
                
        
    }
}
