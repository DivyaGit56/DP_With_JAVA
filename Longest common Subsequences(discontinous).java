 // 1. with recursive approach

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        return lcs(text1, text2, text1.length(), text2.length());
    }
    private int lcs(String text1, String text2, int n, int m) {

    
        // int n = text1.length();
        // int m = text2.length();
        
        // base case
        if(n == 0 || m==0)return 0;

        // choice diagram code
        // 1. when last character match
        if(text1.charAt(n-1) == text2.charAt(m-1)){
            return 1+lcs( text1,  text2, n-1,m-1);
        }else{
        // 2.when last character not match , we have two choice take max of it
        return Math.max(lcs(text1,text2,n-1,m),lcs(text1,text2,n,m-1) );
        }
        
    }
}

//2. Memoization(Bottom up dp)

class Solution {
    int[][]t;
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
         int m = text2.length();
        
         t = new int[1001][1001];
         for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                t[i][j] = -1;
            }
        }

         return lcs(text1, text2, n, m);
     }

    private int lcs(String text1, String text2, int n, int m) {

    
        //   int n = text1.length();
        //   int m = text2.length();
        
        //   base case
         if(n == 0 || m==0)return 0;
         if(t[n][m] != -1)return t[n][m];

        if(text1.charAt(n-1) == text2.charAt(m-1)){
            return t[n][m] = 1+lcs(text1,text2,n-1,m-1);
        }else{
            return t[n][m] =Math.max(lcs(text1,text2,n,m-1),lcs(text1,text2,n-1,m));
        }   

    }
}      


//  3. TOP DOWN DP 

class Solution {
     public int longestCommonSubsequence(String text1, String text2) {
         int m = text1.length();
         int n = text2.length();
        
        int[][]t = new int[1001][1001];
        //  initialization

         for(int i =0; i<m+1; i++){
            for(int j = 0; j<n+1; j++){
                t[i][j] = 0;
            }
         }

         for(int i =1; i<m+1; i++){
            for(int j =1; j<n+1; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
         }
         return t[m][n];

     }
}
