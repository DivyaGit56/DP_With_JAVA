class Solution {
    static int[][]t;
        //  int n = arr.length;
    //  RECURSIVE CODE
    static int solve(int arr[],int i, int j){
        // Base case
        if(i>=j){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k = i; k<= j-1; k++){
            int tempAns = solve(arr,i, k)+solve(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
            
                min = Math.min(min,tempAns);
            
        }
        return min;
    }
    static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length;
        int i=1,j=n-1;
        
      return solve(arr,i,j);
    }
    
    
    // MEMOIZATION CODE
    
    static int solve(int arr[],int i,int j){
        // Base case
        
        if(i>=j){
            return 0;
        }
        
        if(t[i][j] != -1)return t[i][j];
        
        int min = Integer.MAX_VALUE;
        for(int k= i; k<j; k++){
            int tempAns = solve(arr,i, k)+solve(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
            
           min = Math.min(min,tempAns);
            
    
            
        }
        return t[i][j] = min;
    }
    
    // ITERATION CODE
     static int matrixMultiplication(int arr[]) {
         int n = arr.length;
         t = new int[n][n];
         
         for(int i = 0; i<n;i++){
             for(int j=0;j<n;j++){
                 t[i][j] = -1;
             }
         }
         return solve(arr,1,n-1);
    
}
}    
