class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        
        int dist[] = new int[n];
        boolean ans[] = new boolean[queries.length];

        int val = 0;
        dist[0] = 0;

        for(int i=1; i<n; i++) {
            if(Math.abs(nums[i]-nums[i-1]) > maxDiff) {
                val++;
            }
            dist[i] = val;
        }

        for(int i=0; i<queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            if(dist[u] == dist[v]) {
                ans[i] = true;
            }
        }
        return ans;

        
    }
}