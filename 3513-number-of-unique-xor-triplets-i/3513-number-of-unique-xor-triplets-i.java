class Solution {
    public int uniqueXorTriplets(int[] nums) {
        
        int n = nums.length;

        if(n <= 2) {
            return n;
        }
        int count = 0;
        for(int i=0; i<n; i++) {
            count = count | nums[i]; 
        }

        return count + 1;
    }
}