class Solution {
    public int numberOfSubstrings(String s) {
        int a = 0, b = 0, c = 0;
        int l = 0, count = 0;
        
        int n = s.length();

        for(int r=0; r<n; r++) {
            char ch = s.charAt(r);
            if(ch == 'a')   a++;
            else if(ch == 'b')  b++;
            else if(ch == 'c')  c++;

            while(a>=1 && b>=1 && c>=1) {
                count += n - r;
                char ch1 = s.charAt(l);
                if(ch1 == 'a')   a--;
                else if(ch1 == 'b')  b--;
                else if(ch1 == 'c')  c--;
                l++;
            }
        }

        return count;
    }
}