class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        return helper(nums, k) - helper(nums, k-1);
    }

    public int helper(int nums[], int k) {

        int l = 0, ans = 0, count = 0;

        if(k<0) {
            return 0;
        }

        for(int r=0; r<nums.length; r++) {
            if((nums[r] & 1) == 1) {
                count++;
            }

            while(count > k) {
                if((nums[l] & 1) == 1) {
                    count--;
                }
                l++;
            }

            if(count <= k) {
                ans += r-l+1;
            }
        }

        return ans;
    }

}