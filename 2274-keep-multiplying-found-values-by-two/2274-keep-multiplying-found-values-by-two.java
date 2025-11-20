class Solution {
    public int findFinalValue(int[] nums, int original) {
    
        int n = nums.length;
        boolean arr[] = new boolean[1001];
        for(int i=0; i<n; i++) {
            arr[nums[i]] = true;;
        }

        while(original < 1001 && arr[original]) {
            original *= 2;
        }

        return original;
    }
}