class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {

        int c = 1, prev = 0, ans = 0, res = 0;

        for(int i=0; i<nums.size()-1; i++) {
            if(nums.get(i) < nums.get(i+1)) {
                c++;
            } else {
                prev = c;
                c = 1;
            }
            ans = Math.min(prev, c);
            ans = Math.max(ans, c/2);
            res = Math.max(ans, res);
        }

        return res;
    }
}