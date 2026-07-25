class Solution {
    public void moveZeroes(int[] nums) {
        

        int n = nums.length;
        int l =0, r=0;
        while(r < n) {
            while(l < n && nums[l] != 0) {
                l++;
            }
            while(r < n && nums[r] == 0) {
                r++;
            }
            if(l <= r && r < n && l < n) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                // l++;
                // r++;
            } else {
                r++;
            }
        }
    }
}