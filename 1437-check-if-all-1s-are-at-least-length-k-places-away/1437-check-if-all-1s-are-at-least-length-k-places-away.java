class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        
        int n = nums.length;
        int prev = 0;

        int si = -1;
        for(int i=0; i<n; i++) {
            if(nums[i] == 1) {
                if(si == -1) {
                    si = i;
                } else if(i - si - 1 >= k) {
                    si = i;
                } else {
                    return false;
                }
            }    
        }
        return true;
    }
} 