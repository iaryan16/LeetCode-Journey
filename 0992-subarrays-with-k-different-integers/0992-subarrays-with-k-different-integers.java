class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }

    public int helper(int nums[], int k) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        int l=0;
        int count = 0;
        for(int r=0; r<n; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while(map.size() > k) {
                if(map.get(nums[l]) != null) {
                    if(map.get(nums[l]) == 1){
                        map.remove(nums[l]);
                    } else {
                        map.put(nums[l], map.get(nums[l])-1);
                    }
                }
                l++;
            }

            if(map.size() <= k) {
                count += r-l+1;
            }
        }

        return count;
    }

}