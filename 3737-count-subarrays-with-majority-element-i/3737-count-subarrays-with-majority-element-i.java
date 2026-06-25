class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;
        int count[] = new int[n];

        
        for(int i=0; i<n; i++) {
                count[i] = (i>0 ? count[i-1] : 0) + (nums[i] == target ? 1 : 0);
        }

        int c = 0;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                int tar = count[j] - (i > 0 ? count[i-1] : 0);
                int len = j-i+1;
                if(tar > len/2) {
                    c++;
                }
            }
        }

        return c;
        
    }

}