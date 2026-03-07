class Solution {
    public boolean checkOnesSegment(String s) {
        
        int n = s.length();
        char[] c = s.toCharArray();
        for(int i = 1; i < n; i++) {
            if(c[i] == '1' && c[i - 1] == '0') 
                return false;
        }
        return true;
    }
}