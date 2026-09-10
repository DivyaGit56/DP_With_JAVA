class Solution {
    public long mostPoints(int[][] questions) {
      
        // BACKWARD RECURRENCES

         int n = questions.length;
         long dp[] = new long[n+1];

        for(int i= n-1; i>=0; i--){
            int p = questions[i][0];
            int jump = questions[i][1];

            int next = Math.min(n,i+jump+1);

            // skip i question
            long skip = dp[i+1];

            // solve i question

            long solve = p+dp[next];

            dp[i] = Math.max(skip,solve);

        }
        return dp[0];


        // FORWARD RECURRENCE

        for(int i = 0; i<n; i++){

            int p = questions[i][0];
            int jump = questions[i][1];

            dp[i+1] = Math.max(dp[i+1],dp[i]);

            int next = Math.min(n,i+jump+1);

            dp[next] = Math.max(dp[next], dp[i]+p);



        }

      return dp[n];
    }
}
