class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int arr[] = new int[3];

        for(int i=0; i<nums.length; i++) {
            arr[nums[i]]++;
        }
        int k = 0, i=0;
        while(k <= 2 && i < n) {
            while(arr[k] <= 0) {
                k++;
            }
            nums[i++] = k;
            arr[k]--;
            
        }
    }
}