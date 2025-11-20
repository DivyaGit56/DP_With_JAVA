class Solution {
    public int cutRod(int[] price) {
        // code here
        int n = price.length;
        int []length = new int[n];
        for(int i = 0; i<n; i++){
            length[i] = i+1;
        }
        int [][]t = new int[n+1][n+1];
        // initialization
        for(int i = 0; i<=n; i++){
            for(int j = 0;j<=n; j++){
                if(i==0)t[i][j] =0;
                if(j==0)t[i][j] =1;
            }
        }
        
        // code
        for(int i = 1; i<=n; i++){
            for(int j = 1;j<=n; j++){
                if(length[i-1] <= j){
                    int include = price[i-1]+t[i][j-length[i-1]];
                    int exclude = t[i-1][j];
                    t[i][j] = Math.max(include, exclude);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
        return t[n][n];
    }
}
