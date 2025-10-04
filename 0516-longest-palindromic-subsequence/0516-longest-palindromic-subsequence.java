class Solution {
    public int longestPalindromeSubseq(String s1) {
        
        int n = s1.length();
        int dp[][] = new int[n+1][n+1];

        for(int i=0; i<=n; i++) {
            for(int j=0; j<=n; j++) {
                dp[i][j] = -1;
            }
        }

        int i=0;
        int j = s1.length()-1;

        return subseq(s1, i, j, dp);

    }

    public int subseq(String s, int i, int j, int dp[][]) {
        if(i > j) {
            return 0;
        }
        if(i == j) {
            return 1;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 2 + subseq(s, i+1, j-1, dp);
        } else {
            return dp[i][j] = Math.max(subseq(s, i+1, j, dp), subseq(s, i, j-1, dp));
        }   
    }

} 