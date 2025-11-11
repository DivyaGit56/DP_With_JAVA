class Solution {

//     private int solve(List<Pair<Integer,Integer>>count,int m, int n, int i){
//         // base case
//         if(( i>= count.size())|| (m==0 && n==0)){
//             return 0;
//         }
        
//         int take = 0;
//         Pair<Integer, Integer> p = count.get(i);

//         if (p.getKey() <= m && p.getValue() <= n) {
//             take = 1 + solve(count, m - p.getKey(), n - p.getValue(), i + 1);
//         }

//         int skip = solve(count, m,n,i+1);
//         return Math.max(take, skip);
//     }
//     public int findMaxForm(String[] strs, int m, int n) {
    

//         List<Pair<Integer,Integer>>count = new LinkedList<>();
//                 for (String s : strs) {
//             int countZeros = 0;
//             int countOnes = 0;

//             for( char ch : s.toCharArray()){
//                 if(ch == '0'){
//                     countZeros++;
//                 }else{
//                     countOnes++;
//                 }

                
//             }
//             count.add(new Pair<>(countZeros, countOnes));
            
//         }
//         return solve(count, m, n,0);
        
//     }
// }

// Memoization table

import java.util.*;

class Solution {

    private int[][][] dp; // memoization table

    private int solve(List<Pair<Integer, Integer>> count, int m, int n, int i) {
        // base case
        if (i == count.size()) {
            return 0;
        }

        // if already computed
        if (dp[i][m][n] != -1) {
            return dp[i][m][n];
        }

        Pair<Integer, Integer> p = count.get(i);
        int zeros = p.getKey();
        int ones = p.getValue();

        // skip current string
        int skip = solve(count, m, n, i + 1);

        // take current string (if possible)
        int take = 0;
        if (zeros <= m && ones <= n) {
            take = 1 + solve(count, m - zeros, n - ones, i + 1);
        }

        // store and return
        return dp[i][m][n] = Math.max(take, skip);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        List<Pair<Integer, Integer>> count = new ArrayList<>();

        // count zeros and ones for each string
        for (String s : strs) {
            int countZeros = 0, countOnes = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '0') countZeros++;
                else countOnes++;
            }
            count.add(new Pair<>(countZeros, countOnes));
        }

        int len = count.size();
        dp = new int[len][m + 1][n + 1];

        // initialize dp with -1
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(count, m, n, 0);
    }
}
