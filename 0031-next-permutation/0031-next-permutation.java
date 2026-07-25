class Solution {
    public void nextPermutation(int[] nums) {
        
        int n = nums.length;
        int idx = -1;

        for(int i=n-1; i>=1; i--) {
            if(nums[i-1] < nums[i]) {
                idx = i-1;
                break;
            }
        }
        if(idx == -1) {
            reverse(nums, 0, n-1);
            return;
        }

        for(int i=n-1; i>idx; i--) {
            if(nums[i] > nums[idx]) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }

        reverse(nums, idx+1, n-1);
        return;
    }

    public void reverse(int arr[], int l, int r) {
        while(l <= r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}