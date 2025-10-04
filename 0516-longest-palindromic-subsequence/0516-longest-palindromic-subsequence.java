class Solution {
    public int longestPalindromeSubseq(String s1) {
        
        String s2 = reverse(s1);

        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n+1][m+1];

        for(int i=0; i<=n; i++) {
            for(int j=0; j<=m; j++) {
                    dp[i][j] = -1;
            }
        }
        return subseq(s1, s2, n, m, dp);
    }

    public int subseq(String s1, String s2, int n, int m, int dp[][]) {
        if(n==0 || m==0) {
            return 0;
        }

        if(dp[n][m] != -1) {
            return dp[n][m];
        }
        
        if(s1.charAt(n-1) == s2.charAt(m-1)) {
            return dp[n][m] = 1 + subseq(s1, s2, n-1, m-1, dp);
        } else {
            return dp[n][m] = Math.max(subseq(s1, s2, n-1, m, dp), subseq(s1, s2, n, m-1, dp));
        }
    }

    public static String reverse(String s) {
        String rev = "";
        int n = s.length()-1;
        while(n>=0) {
            char ch = s.charAt(n);
            rev += ch;
            n--;
        }
        return rev;
    }

} 