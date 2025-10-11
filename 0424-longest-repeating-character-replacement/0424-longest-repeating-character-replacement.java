class Solution {
    public int characterReplacement(String s, int k) {
        int arr[] = new int[26];

        int l = 0;
        int count = 0;
        int max = 0;

        for(int r=0; r<s.length(); r++) {
            char ch = s.charAt(r);
            count = Math.max(count, ++arr[ch-'A']);
            if(r-l+1 - count > k) {
                arr[s.charAt(l) - 'A']--;
                l++;
            }
            max = Math.max(max, r-l+1);
        }
        return max;
    }
}