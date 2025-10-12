class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums,goal) - helper(nums, goal-1);
    }

    public int helper(int[] nums, int goal) {
        int n = nums.length;
        int sum = 0, count = 0, l = 0;
        
        if(goal < 0) {
            return 0;
        }
        for(int r=0; r<n; r++) {
            sum += nums[r];
            while(sum > goal) {
                sum -= nums[l];
                l++;
            }
            if(sum <= goal) {
                count += r-l+1;
            }
        }
        return count;
    }
}