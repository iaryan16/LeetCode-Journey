class Solution {
    public int maxChunksToSorted(int[] arr) {
        
        int n = arr.length, max = -1;
        int c = 0;
        for(int i=0; i<n; i++) {
            max = Math.max(max, arr[i]);
            if(max == i) {
                c++;
            }
        }
        return c;
    }
}