class Solution {
    public int maxWidthRamp(int[] nums) {
        
        int n = nums.length;

        int leftMin[] = new int[n];
        leftMin[0] = nums[0];

        int rightMax[] = new int[n];
        rightMax[n-1] = nums[n-1];

        for(int i=1; i<n; i++) {
            leftMin[i] = Math.min(leftMin[i-1], nums[i]);
        }

        for(int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], nums[i]);
        }

        int i=0, j=0, width = 0;

        while(i < n && j < n) {
            if(leftMin[i] <= rightMax[j]) {
                width = Math.max(width, j-i);
                j++;
            } else {
                i++;
            }
        }
        return width;
    }
}