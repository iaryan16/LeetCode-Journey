class Solution {
    public int minimumCost(int[] nums, int k) {
        int n = nums.length, MOD = 1_000_000_007;

        int i = 0;
        long sum = 0;
        while(i < n) {
            sum += nums[i];
            i++;
        }
        if(sum <= k) {
            return 0;
        }

        long ops = ((sum + k - 1) / k) % MOD;
        ops = ((ops * (ops-1))/2) % MOD;

        return (int)ops;
    }
}