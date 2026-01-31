class Solution {
     
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
}
       
