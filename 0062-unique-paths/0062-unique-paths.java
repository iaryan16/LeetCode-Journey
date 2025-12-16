class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        
        // 1st approach
        // return solve(0, 0, m, n, dp);

        // solve(0, 0, m, n, dp);
        // return dp[0][0];


        // 2nd approach
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i == 0)  dp[i][j] = 1;
                if(j == 0)  dp[i][j] = 1;

                if(i != 0 && j != 0)    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    public int solve(int i, int j, int m, int n, int dp[][]) {
        
        if(i >= m || j >= n) {
            return 0;
        }

        if(i == m-1 && j == n-1) {
            return dp[i][j] = 1;
        }

        if(dp[i][j] > 0) {
            return dp[i][j];
        }

        return dp[i][j] = solve(i+1, j, m, n, dp) + solve(i, j+1, m, n, dp);
        
    }
}