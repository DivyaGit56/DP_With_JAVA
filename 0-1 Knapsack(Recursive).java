class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        return helper(W,  val,  wt,  n-1);
    }
    public int helper(int W, int val[], int wt[],int n){
        // Base case
        
        if(n <0 || W==0){
            return 0;
        }
        if(wt[n] <= W){
            int include = val[n]+helper(W-wt[n], val, wt, n-1);
            int exclude = helper(W, val, wt, n-1);
            return Math.max(include, exclude);
        }else{
            return helper(W,val,wt,n-1);
        }
        
    }
}
