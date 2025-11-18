class Solution {
    private static int CountOfSubset(int[]A, int sum){
        int n = A.length;
        int t[][] = new int[n+1][sum+1];
        for(int i = 0; i<= n; i++){
            for(int j = 0; j<=sum;j++){
                if(i==0)t[i][j] = 0;
                if(j==0)t[i][j] = 1;
            }
        }
                 for(int i = 1; i<= n; i++){
                   for(int j = 0; j<=sum;j++){
                       if(A[i-1]<=j){
                           t[i][j] = t[i-1][j]+t[i-1][j-A[i-1]];
                           
                       }else{
                           t[i][j] = t[i-1][j];
                           
                       }
            }
        }
        return t[n][sum];
    }
    static int findTargetSumWays(int N, int[] A, int target) {
        int sum = 0;
        for(int i = 0; i<N; i++){
            sum += A[i];
            
        }
        // code here
        if((sum + target) % 2 != 0) 
            return 0;
        if(Math.abs(target)>sum)return 0;

        int s1 = (target+sum)/2;
        return CountOfSubset(A,s1);
    }
};
