class Solution {
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;

        int r=0;
        int sum = 0, max = Integer.MIN_VALUE;
        while(r < n) {
            sum += nums[r];
            if(sum > max) {
                max = sum;
            }
            if(sum < 0) {
                sum = 0;
            }
            r++;
        }
        return max;
    }
}