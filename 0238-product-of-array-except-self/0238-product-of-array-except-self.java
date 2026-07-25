class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int left[] = new int[n];
        int right[] = new int[n];

        left[0] = nums[0];
        right[n-1] = nums[n-1];

        for(int i=1; i<n-1; i++) {
            left[i] = left[i-1] * nums[i];
            right[n-1-i] = nums[n-1-i] * right[n-i];
        }

        int ans[] = new int[n];

        for(int i=0; i<n; i++) {
            ans[i] = (i > 0 ? left[i-1] : 1) * (i+1 < n ? right[i+1] : 1);
        }

        return ans;
    }
}