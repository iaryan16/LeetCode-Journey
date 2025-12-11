class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int col[] = new int[n];

        for(int i=0; i<n; i++) col[i] = -1;

        for(int i=0; i<n; i++) {
            if(col[i] == -1) {
                if(dfs(i, graph, col, 0) == false)
                    return false;
            }
        }

        return true;
        
    }

    public static boolean dfs(int node, int graph[][], int col[], int colour) {

        col[node] = colour;
        
        for(int nbr : graph[node]) {
            if(col[nbr] == -1) {
                if(dfs(nbr, graph, col, 1-colour) == false)
                    return false;
            } else if(col[nbr] == colour) {
                return false;
            }
        }
        
        return true;
    }
}