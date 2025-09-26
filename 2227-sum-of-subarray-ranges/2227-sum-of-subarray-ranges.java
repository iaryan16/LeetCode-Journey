class Solution {
    public long subArrayRanges(int[] nums) {

        long large = largest(nums);
        long small = smallest(nums);
        return large - small;
    }

    private long largest(int nums[]) {
        int n = nums.length;
        int left[] = new int[n];
        int right[] = new int[n];
        long mod2 = 1000000007L;

        Stack<Integer> st = new Stack<>();
    
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }

            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long sum = 0;

        for(int i=0; i<n; i++) {
            sum = sum + (long)nums[i] * (i - left[i]) * (right[i] - i);
        }
        return sum;
    }

    private long smallest(int nums[]) {
        int n = nums.length;
        int left[] = new int[n];
        int right[] = new int[n];
        long mod2 = 1000000007L;

        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }

            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long sum = 0;

        for(int i=0; i<n; i++) {
            sum = sum + (long)nums[i] * (i - left[i]) * (right[i] - i);
        }
        return sum;
    }
}