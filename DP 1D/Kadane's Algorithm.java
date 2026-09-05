class Solution {
    int maxSubarraySum(int[] arr) {
        int n = arr.length;
        // Code here
        
        int max [] = new int[n+1];
       max[0] = arr[0];
        
        for(int i = 1; i<n; i++){
            
            max[i] = Math.max( arr[i], max[i-1]+arr[i]);
            
        }
       int ans = max[0];
       for(int i = 1; i<n; i++){
           ans = Math.max(ans,max[i]);
       }
       return ans;
    }
}
