class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;
        int min = nums[0], max = nums[0];
        for(int i=1; i<n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        return gcd(min, max);
    }

    public int gcd(int a, int b) {
        while(b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return Math.abs(a);
    }
}