class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int c = 0;
        Arrays.sort(nums);

        for(int k=2; k<n; k++) {
            int i = 0;
            int j = k-1;
            while(i<j) {
                if(nums[i]+nums[j] > nums[k]) {
                    c += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }
        return c;
    }
}