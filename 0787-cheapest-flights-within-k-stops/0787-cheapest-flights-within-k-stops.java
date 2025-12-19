class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        Map<Integer, List<List>> graph = new HashMap<>();

        for(int i=0; i<flights.length; i++) {
            graph.putIfAbsent(flights[i][0], new ArrayList<>());
            List<Integer> list = new ArrayList<>();
            list.add(flights[i][1]);
            list.add(flights[i][2]);
            graph.get(flights[i][0]).add(list);
        }

        Queue<int[]> q = new LinkedList<>();

        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        

        q.offer(new int[]{src, 0, 0});

        while(!q.isEmpty()) {
            int curr[] = q.poll();

            int node = curr[0];
            int cp = curr[1];
            int cs = curr[2];
            
            if (cs > k) continue;
            
            if(graph.get(node) == null)
                continue;
            for(List<Integer> list : graph.get(node)) {
                int nbr = list.get(0);
                int np = list.get(1);
                int newDist = cp + np;
                if(newDist < dist[nbr]) {
                    dist[nbr] = newDist;
                    q.offer(new int[]{nbr, newDist, cs+1});
                } 
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}