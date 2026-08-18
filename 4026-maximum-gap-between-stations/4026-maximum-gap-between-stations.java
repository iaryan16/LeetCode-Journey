class Solution {
    public int maximumGap(String skill, String station) {
        
        int n = skill.length();
        int m = station.length();

        char a[] = skill.toCharArray();
        char b[] = station.toCharArray();
        
        int left[] = new int[n];
        int right[] = new int[n];

        int j=0;
        for(int i=0; i<n; i++) {
            while(a[i] != b[j]) 
                j++;
            left[i] = j;
            j++;
        }

        j=m-1;
        for(int i=n-1; i>=0; i--) {
            while(a[i] != b[j]) 
                j--;
            right[i] = j;
            j--;
        }

        int ans = 0;

        for(int i=1; i<n; i++) {
            ans = Math.max(ans, right[i] - left[i-1]);
        }

        return ans;
    }
}