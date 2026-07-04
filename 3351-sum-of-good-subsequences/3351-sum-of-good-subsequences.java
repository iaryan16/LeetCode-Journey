class Solution {
    public int sumOfGoodSubsequences(int[] nums) {
        int MOD = (int)(1_000_000_007);
        int MAX = 1_00_001;
        long dp[] = new long[MAX];
        long sum[] = new long[MAX];
        

        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            dp[num] = (1 + dp[num])% MOD;
            sum[num] = (sum[num] + num) % MOD;
            if(num - 1 >= 0 && dp[num-1] > 0) {
                dp[num] = (dp[num] + dp[num-1]) % MOD;
                sum[num] = (sum[num] + sum[num-1] +(dp[num-1] * num) % MOD) % MOD;
            }
            if(num+1 < MAX && dp[num+1] > 0) {
                dp[num] = (dp[num] + dp[num+1]) % MOD;
                sum[num] = (sum[num] + sum[num+1] + (dp[num+1] * num) % MOD) % MOD;
            }
        }

        long ans = 0;
        for(int i=0; i<MAX; i++) {
            ans = (ans + sum[i]) % MOD;
        }

        return (int)ans;
    }
} 