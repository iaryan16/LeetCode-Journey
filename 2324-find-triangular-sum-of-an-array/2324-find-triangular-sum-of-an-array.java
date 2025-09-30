class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length-1;
        int m = n;

        if(n==0) {
            return nums[0];
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                nums[j] = (nums[j] + nums[j+1]) % 10;
            }
            m--;
        }

        return nums[0];
    }
}