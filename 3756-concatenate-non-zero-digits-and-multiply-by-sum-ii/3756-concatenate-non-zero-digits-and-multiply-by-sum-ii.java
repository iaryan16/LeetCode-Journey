class Solution {
   long nums[], sums[], len[], power[];
   int MOD;

    public int[] sumAndMultiply(String s, int[][] queries) {
        MOD = (int)(1e9 + 7);
        int n = s.length();
        power = new long[n+1];
        nums = new long[n+1];
        sums = new long[n+1];
        len = new long[n+1];
        solve(s);
        int ans[] = new int[queries.length];
        power[0] = 1;
        for(int i=1; i<n+1; i++)
            power[i] = (power[i-1] * 10) % MOD;
        for(int i=0; i<queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1]+1;

            long currSum = sums[r] - sums[l];
            long num = (nums[r] - nums[l] * power[(int)(len[r] - len[l])] % MOD
                + MOD) % MOD;

            ans[i] = (int)((num * currSum) % MOD);
        }
        return ans;
    }

    public void solve(String str) {
        long curr = 0;
        long currSum = 0;
        long c = 0;
        for(int i=0; i<str.length(); i++) {
            int n = str.charAt(i) - '0';
            if(n != 0) {
                curr = (curr * 10 + n) % MOD;
                currSum = (currSum + n) % MOD;
                c++;
            }
            
            nums[i+1] = curr % MOD;
            sums[i+1] = currSum % MOD;
            len[i+1] = c;
        }
    }
} 