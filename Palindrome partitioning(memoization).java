class Solution {
    static int[][]t;
    static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    static int solve(String s,int i,int j){
        if(i>=j)return 0;
        if(isPalindrome(s,i,j))return 0;
         if (t[i][j] != -1) return t[i][j];
        int min = Integer.MAX_VALUE;
        
        for(int k=i;k<=j-1;k++){
            int temp = solve(s,i,k)+solve(s,k+1,j)+1;
            min = Math.min(min,temp);
        }
        return t[i][j] = min;
    }
    static int palPartition(String s) {
        // code here
         int n = s.length();
        t = new int[n][n];
        
        for (int i = 0; i < n; i++)
            java.util.Arrays.fill(t[i], -1);
        return solve(s,0,n-1);
        
    }
}
