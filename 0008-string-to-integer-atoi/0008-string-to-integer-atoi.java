class Solution {
    public static int MAX = Integer.MAX_VALUE;
    public static int MIN = Integer.MIN_VALUE;

    public int myAtoi(String s) {
        
        if(s==null) return 0;

        int sign = 1;
        long ans = 0;
        s = s.trim();
        
        if(s.length()==0) return 0;
        
        if(s.charAt(0)=='-') sign = -1;

        int i = (s.charAt(0)=='+'|| s.charAt(0)=='-')? 1: 0 ;
        
        ans = recursive(s, i, ans, sign);
        return (int)(sign * ans);

    }

    public long recursive(String s, int i, long ans, int sign) {

        if(i == s.length() || !Character.isDigit(s.charAt(i))) {
            return ans;
        }
        char ch = s.charAt(i);
        if(ch == '-') {
            sign = -1;
        }

        ans = ans * 10 + ch - '0';

        if(sign==-1 && -1*ans<MIN) return MIN;
        if(sign==1 && 1*ans>MAX) return MAX;
        
        return recursive(s, i+1, ans, sign);
        
        
    }
}