class Solution {
    public int countPrimes(int n) {
        
        if (n <= 2) return 0;
        
        boolean arr[] = new boolean[n];

        for(int i=0; i<n; i++) {
            arr[i] = true;
        }

        arr[0] = false;
        arr[1] = false;

        for(int i = 2; i * i < n ; i++) {
            if(arr[i]) {
                for(int j = i * i; j < n; j += i) {
                    arr[j] = false;
                }
            }
            
        }
        int c = 0;
        for(int i=2; i<n; i++) {
            if(arr[i])  
                c++;
        }
        return c;
    }
}