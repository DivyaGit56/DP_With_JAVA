import java.util.*;
class Solution {
    int t[][] = new int [1002][1002];
    public Solution(){
    for(int i = 0; i<1002; i++){
        Arrays.fill(t[i],-1);
    }
    }
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
        
        // if already computed
        if(t[n][W] != -1) return t[n][W];
        if(wt[n] <= W){
            int include = val[n]+helper(W-wt[n], val, wt, n-1);
            int exclude = helper(W, val, wt, n-1);
             t[n][W] =  Math.max(include, exclude);
        }else{
             t[n][W] =  helper(W,val,wt,n-1);
        }
        return t[n][W];
        
    }
}
