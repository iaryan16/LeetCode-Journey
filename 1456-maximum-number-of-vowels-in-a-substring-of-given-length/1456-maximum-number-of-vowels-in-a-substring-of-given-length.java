class Solution {
    public int maxVowels(String s, int k) {
        
        int n = s.length();
        char arr[] = s.toCharArray();

        int freq[] = new int[26];

        int l=0, r=0, c=0, max=0;

        while(r < n) {
            if(check(arr[r])) c++;

            if(r-l+1 > k) {
                if(check(arr[l])) {
                    c--;
                }
                l++;
            }

            max = Math.max(max, c);
            r++;
        }
        return max;
    }

    public boolean check(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    // public int check(int[] freq) {
    //     int c = 0;
    //     for(int i=0; i<freq.length; i++) {
    //         if(i == 0 || i == 4 || i == 8 || i == 14 || i == 20) {
    //             c += freq[i];
    //         }
    //     }

    //     return c;
    // }
}