class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> st = new Stack<>();

        int n = heights.length;
        
        int left[] = new int[n];
        int right[] = new int[n];

        // right ke chote element nikal rhe
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            if(st.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();

        // left ke chote element nikal rhe
        for(int i = 0; i<n; i++) {
            while(!st.isEmpty() && heights[i] <=heights[st.peek()])
                st.pop();
            if(st.isEmpty())
                left[i] = -1;
            else 
                left[i] = st.peek();
            st.push(i);
        }

        int max = 0;

        for(int i=0; i<n; i++) {
            max = Math.max(max, heights[i] * (right[i] - left[i] -1 ));
        }

        return max;
    }
}