class Solution {
    public String removeKdigits(String num, int k) {
        
        if(k == num.length()) {
            return "0";
        }
        Stack<Character> st = new Stack<>();

        int n = num.length();

        for(int i=0; i<n; i++) {
            char ch = num.charAt(i);

            while(!st.isEmpty() && k>0 && (st.peek() - '0' > ch - '0')) {
                st.pop();
                k--;
            } 
            st.push(ch);
        }

        while(k>0) {
            st.pop();
            k--;
        }

        if(st.isEmpty()) {
            return "0";
        }

        String res = "";

        while(!st.isEmpty()) {
            res = st.pop() + res;
        }

        int i = 0;
        while(i<res.length() && res.charAt(i) == '0') {
            i++;
        }

        if(i == res.length()) {
            return "0";
        }
        return res.substring(i);
    }
}