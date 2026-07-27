class Solution {
    public int maxVowels(String s, int k) {
        
        int n = s.length();
        char arr[] = s.toCharArray();

        int freq[] = new int[26];

        int l=0, r=0, max=0;

        while(r < n) {
            freq[arr[r]-'a']++;

            if(r-l+1 > k) {
                freq[arr[l]-'a']--;
                l++;
            }

            max = Math.max(max, check(freq));
            r++;
        }
        return max;
    }

    public int check(int[] freq) {
        int c = 0;
        for(int i=0; i<freq.length; i++) {
            if(i == 0 || i == 4 || i == 8 || i == 14 || i == 20) {
                c += freq[i];
            }
        }

        return c;
    }
}