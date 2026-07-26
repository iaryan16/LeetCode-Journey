class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int n1 = s1.length();
        int n2 = s2.length();

        if(n1 > n2) {
            return false;
        }

        int freq1[] = new int[26];
        int freq2[] = new int[26];

        for(int i=0; i<n1; i++) {
            char ch = s1.charAt(i);
            freq1[ch-'a']++;
        }

        int l=0, r=0;

        while(r < n2) {
            char ch = s2.charAt(r);
            freq2[ch-'a']++;

            if(r-l+1 == n1) {
                if(check(freq1, freq2)) {
                    return true;
                }
                ch = s2.charAt(l);
                freq2[ch-'a']--;
                l++;
            }
            r++;
        }
        return false;
    }

    public boolean check(int freq1[], int freq2[]) {
        for(int i=0; i<26; i++) {
            if(freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }
}