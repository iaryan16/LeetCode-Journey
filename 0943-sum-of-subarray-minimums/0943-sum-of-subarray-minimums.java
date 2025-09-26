class Solution {
    public int sumSubarrayMins(int[] arr) {

        long mod2 = 1000000007L;
        int n = arr.length;

        int left[] = new int[n];
        int right[] = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if(st.isEmpty())
                left[i] = i+1;
            else
                left[i] = i - st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if(st.isEmpty())
                right[i] = n-i;
            else
                right[i] = st.peek() - i;
            st.push(i);
        }

        long sum = 0;

        for(int i=0; i<n; i++) {
            sum = (sum + (long)arr[i] * left[i] * right[i]) % mod2;
        }
        sum = sum % mod2;

        return (int)sum;
    }
}