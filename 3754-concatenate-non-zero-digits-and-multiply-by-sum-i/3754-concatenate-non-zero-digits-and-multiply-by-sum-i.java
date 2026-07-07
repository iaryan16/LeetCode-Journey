class Solution {
    public long sumAndMultiply(int n) {
        return solve(n);
    }

    public long solve(int n) {
        StringBuilder sb = new StringBuilder();
        String str = Integer.toString(n);
        int sum = 0;
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch <= '9' && ch >= '1') {
                sb.append(ch);
                sum += (ch - '0');
            }   
        }
        int x;
        if(sb.length() == 0) {
            x = 0;
        } else {
            x = Integer.parseInt(sb.toString());
        }

        return 1L * x * sum;
    }
}