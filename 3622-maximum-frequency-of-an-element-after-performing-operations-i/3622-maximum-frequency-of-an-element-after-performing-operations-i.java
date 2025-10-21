class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        
        Arrays.sort(nums);

        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int arr[] = new int[max + 1];

        for(int i=0; i<n; i++) {
            arr[nums[i]]++;
        }

        for(int i=1; i<arr.length; i++) {
            arr[i] += arr[i-1];
        }
        int ans = -1;

        for(int i = min; i<=max; i++) {
            int l = Math.max(min, i-k);
            int r = Math.min(max, i+k);

            int f = arr[i]- arr[i-1];
            int extra = Math.min(numOperations, arr[r] - arr[l-1] - f);
            ans = Math.max(ans, extra+f);
        }

        return ans;
    }
}