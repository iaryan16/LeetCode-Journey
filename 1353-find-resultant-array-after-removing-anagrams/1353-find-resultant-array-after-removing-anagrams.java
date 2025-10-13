class Solution {
    public List<String> removeAnagrams(String[] words) {
        
        List<String> ans = new ArrayList<>();
        int n = words.length;
        
        for(int i=0; i<n; i++) {
            int j = i+1;
            while(j<n && anagram(words[i], words[j])) {
                j++;
            }
            ans.add(words[i]);
            i = j-1;
        }
        return ans;
    }

    public boolean anagram(String word1, String word2) {

        int arr[] = new int[26];

        for(int i=0; i<word1.length(); i++) {
            char ch = word1.charAt(i);
            arr[ch-'a']++;
        }

        for(int i=0; i<word2.length(); i++) {
            char ch = word2.charAt(i);
            arr[ch-'a']--;
        }
        
        for(int i=0; i<26; i++) {
            if(arr[i] != 0) {
                return false;
            }
        }

        return true;
        
    }
}