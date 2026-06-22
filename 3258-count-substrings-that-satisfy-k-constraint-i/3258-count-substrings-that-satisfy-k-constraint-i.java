class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        
        int n = s.length();

        int l=0, r=0, ans=0;
        int o=0, z=0;
        while(r < n) {

            if(s.charAt(r) == '1') o++;
            else z++;

            
            while(o > k && z > k) {
                if(s.charAt(l) == '1') o--;
                else z--;
                l++;
            }
            ans += (r-l+1);
            r++;
        }

        return ans;
    }
}