class Solution {

    public int minScore(int n, int[][] roads) {
        Map<Integer, List<int[]>> map = new HashMap<>();

        for(int i=0; i<roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int d = roads[i][2];
            map.putIfAbsent(u, new ArrayList());
            map.get(u).add(new int[]{v, d});
            map.putIfAbsent(v, new ArrayList());
            map.get(v).add(new int[]{u, d});
        }

        return solve(n, map);
    }

    public int solve(int n, Map<Integer, List<int[]>> map) {
        
        boolean visited[] = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);

        int ans = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            int node = q.poll();
            visited[node] = true;
            List<int[]> list = map.get(node);

            for(int nbr[] : list) {
                ans = Math.min(ans, nbr[1]);
                if(!visited[nbr[0]])
                    q.offer(nbr[0]);
            }
        }
        return ans;
    }
}