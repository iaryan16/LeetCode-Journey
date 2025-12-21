class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int dist[][] = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
                if(i == j)
                    dist[i][j] = 0;
            }
        }

        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int d = edges[i][2];
            dist[u][v] = d;
            dist[v][u] = d;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if (dist[j][i] == Integer.MAX_VALUE) 
                    continue;
                for(int k=0; k<n; k++) {
                    if (dist[i][k] == Integer.MAX_VALUE) 
                        continue;
                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                }
            }
        }

        int minCity = -1;
        int cityCount = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            int c = 0;
            for(int j=0; j<n; j++) {
                if(dist[i][j] <= distanceThreshold) {
                    c++;
                }
            }

            if(c <= cityCount) {
                minCity = i;
                cityCount = c;
            }
        }

        return minCity;
    }
}
