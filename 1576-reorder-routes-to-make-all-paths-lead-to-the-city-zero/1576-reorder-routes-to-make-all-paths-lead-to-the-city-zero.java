class Solution {
    HashMap<Integer, List<Integer>> original = new HashMap<>();
    HashMap<Integer, List<Integer>> reverse = new HashMap<>();
    boolean visited[];
    int ans;

    public int minReorder(int n, int[][] connections) {
        visited = new boolean[n+1];
        bfs(connections);
        ans = 0;
        dfs(0);
        return ans;

    }

    public void bfs(int connections[][]) {

        for(int i=0; i<connections.length; i++) {
            int s = connections[i][0];
            int d = connections[i][1];
            original.putIfAbsent(s, new ArrayList<>());
            original.get(s).add(d);
            reverse.putIfAbsent(d, new ArrayList<>());
            reverse.get(d).add(s);

        }
    }

    public void dfs(int node) {
        
        visited[node] = true;
        if(original.get(node) != null) {
            for(int i : original.get(node)) {
                if(!visited[i]) {
                    ans++;
                    dfs(i);
                }
            }
        }

        if(reverse.get(node) != null) {
            for(int i : reverse.get(node)) {
                if(!visited[i]) {
                    dfs(i);
                }
            }
        }

        
    }
}