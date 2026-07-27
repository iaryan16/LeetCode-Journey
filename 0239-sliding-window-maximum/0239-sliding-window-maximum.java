class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        

        int n = nums.length;
        int ans[] = new int[n-k+1];

        int l=0, r=0;
        Deque<Integer> d = new ArrayDeque<>();

        while(r < n) {
            
            while(!d.isEmpty() && d.getFirst() < l) {
                d.pollFirst();
            }

            while(!d.isEmpty() && nums[d.peekLast()] < nums[r]) {
                d.pollLast();
            }
    
            d.addLast(r);

            if(r - l + 1 == k) {
                ans[r-k+1] = nums[d.getFirst()];
                l++;
            }
            r++;
        }

        return ans;
    }
}