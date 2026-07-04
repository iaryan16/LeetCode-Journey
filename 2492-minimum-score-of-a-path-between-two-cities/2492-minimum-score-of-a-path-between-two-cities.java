class Solution {
    class Pair {
        int y, d;
        Pair(int y, int d) {
            // this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    public int minScore(int n, int[][] roads) {
        Map<Integer, List<Pair>> map = new HashMap<>();

        for(int i=0; i<roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int d = roads[i][2];
            map.putIfAbsent(u, new ArrayList());
            map.get(u).add(new Pair(v, d));
            map.putIfAbsent(v, new ArrayList());
            map.get(v).add(new Pair(u, d));
        }

        // boolean visited[] = new boolean[n+1];
        int dist[] = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        solve(1, map, dist);
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<=n; i++) {
            ans = Math.min(ans, dist[i]);
        }
        return ans;
    }

    public void solve(int node, Map<Integer, List<Pair>> map, int[] dist) {
    
        for(Pair nbr : map.get(node)) {
            if(dist[nbr.y] > nbr.d) {
                dist[nbr.y] = nbr.d;
                solve(nbr.y, map, dist);
            }
        }
    }
}