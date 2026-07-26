class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        if(n == 1) {
            return 1;
        }
        char arr[] = s.toCharArray();
        Set<Character> set = new HashSet<>();

        int l=0, r=0, max=0;

        while(r < n) {
            while(set.contains(arr[r])) {
                set.remove(arr[l]);
                l++;
            }
            set.add(arr[r]);
            max = Math.max(r-l+1, max);
            r++;
        }
        return max;
    }
}