class Solution {
    public int uniqueXorTriplets(int[] nums) {

        int n = nums.length;
        
        if(n == 1) {
            return 1;
        } else if(n == 2) {
            if(nums[0] == nums[1]) return 1;
            return 2;
        }

        Set<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++) {
            int x = nums[i];
            for(int j=i; j<n; j++) {
                int y = nums[j];
                int xor = x ^ y;
                set.add(xor);
            }
        }

        HashSet<Integer> ans = new HashSet<>();
        for(int i : nums) ans.add(i);

        for(int i : set) {
            for(int j : nums) {
                int xor = i ^ j;
                ans.add(xor);
            }
        }

        return ans.size();
    }
}