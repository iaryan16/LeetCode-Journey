class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        
        int n = nums.size();
        int arr[] = new int[n];
        arr[n-1] = 1;
        for(int i=n-2; i>=0; i--) {
            if(nums.get(i) < nums.get(i+1)) {
                arr[i] = 1+ arr[i+1];
            } else {
                arr[i] = 1;
            }
        }

        for(int i=n-1; i>=k; i--) {
            if(arr[i] >= k && arr[i-k] >= k) {
                return true;
            } 
        }

        return false;
    }
}