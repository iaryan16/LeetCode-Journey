class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int newMat[][] = new int[n][m];

        for(int i=0; i<m; i++) {
            newMat[0][i] = matrix[0][i] - '0';
        }
        
        for(int i=1; i<n; i++) {
            for(int j=0; j<m; j++) {
                newMat[i][j] = matrix[i][j] == '0' ? 0 : (newMat[i-1][j]) + 1;
            }
        }

        int max = 0;

        for(int i=0; i<n; i++) {
            max = Math.max(max, larArea(newMat[i]));
        }
        return max;

    }

    public int larArea(int[] heights) {
        
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