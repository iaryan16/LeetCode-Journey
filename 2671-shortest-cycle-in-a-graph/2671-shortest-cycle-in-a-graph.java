class Solution {
    int ans = Integer.MAX_VALUE;
    
    public int findShortestCycle(int n, int[][] edges) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        int m = edges.length;

        for (int i = 0; i < m; i++) {
            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.putIfAbsent(edges[i][1], new ArrayList<>());
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        for(int i=0; i<n; i++) {
            bfs(i, graph, new int[n]);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;

    }

    public void bfs(int node, Map<Integer, List<Integer>> graph, int dist[]) {
        Queue<Integer> q = new LinkedList<>();
        int parent[] = new int[dist.length];
        q.offer(node);
        Arrays.fill(dist, -1);
        dist[node] = 1;

        while(!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> list = graph.get(curr);
            if (list == null) 
                continue;
            for(int nbr : graph.get(curr)) {
                if(dist[nbr] == -1) {
                    dist[nbr] = dist[curr] + 1;
                    parent[nbr] = curr;
                    q.offer(nbr);  
                } else if(parent[curr] != nbr) {
                    ans = Math.min(ans, dist[curr] + dist[nbr] - 1);
                }
            }
        }
    }
}