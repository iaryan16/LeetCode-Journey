class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        int max = nums[0];
        for(int num : nums) max = Math.max(max, num);

        int c = 0;
        while(max > 0) {
            c++;
            max = max >> 1;
        }

        int maxXor = 1 << c;
        boolean arr[] = new boolean[maxXor];

        for(int i : nums) {
            for(int j : nums) {
                int xor = i ^ j;
                arr[xor] = true;
            }
        }

        boolean ans[] = new boolean[maxXor];

        for(int i=0; i<maxXor; i++) {
            if(!arr[i]) continue;
            for(int j : nums) {
                int xor = i ^ j;
                ans[xor] = true;
            }
        }

        int count = 0;
        for(boolean b : ans) 
            if(b) 
                count++;

        return count;
    }
}