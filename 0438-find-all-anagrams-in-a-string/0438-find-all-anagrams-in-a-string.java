class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n1 = p.length();
        int n2 = s.length();

        int freq1[] = new int[26];
        int freq2[] = new int[26];

        for(int i=0; i<n1; i++) {
            char ch = p.charAt(i);
            freq1[ch-'a']++;
        }

        int l=0, r=0;
        List<Integer> list = new ArrayList<>();

        while(r < n2) {
            char ch = s.charAt(r);
            freq2[ch-'a']++;

            if(r-l+1 == n1) {
                if(check(freq1, freq2)) {
                    list.add(l);
                }
                ch = s.charAt(l);
                freq2[ch-'a']--;
                l++;
            }
            r++;
        }
        return list;
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