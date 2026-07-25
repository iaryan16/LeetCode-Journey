class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int y = nums[l];
                int z = nums[r];
                long sum = x+y+z;
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(x);
                    list.add(y);
                    list.add(z);
                    ans.add(list);
                    while (l < r && nums[l] == y) {
                        l++;
                    }
                    while (r > l && nums[r] == z) {
                        r--;
                    }
                } else if (sum > 0) {
                    while (r > l && nums[r] == z) {
                        r--;
                    }
                } else {
                    while (l < r && nums[l] == y) {
                        l++;
                    }
                }
            }

            while (i < n && x == nums[i]) {
                i++;
            }
            i=i-1;
        }

        return ans;
    }
}