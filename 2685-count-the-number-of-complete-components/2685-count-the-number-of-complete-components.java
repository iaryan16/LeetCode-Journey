class Solution {
    boolean visited[];

    public int countCompleteComponents(int n, int[][] edges) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            map.get(u).add(v);
            map.get(v).add(u);
        }

        visited = new boolean[n];

        int c = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && solve(i, map)) {
                c++;
            }
        }

        return c;
    }

    // public boolean solve(int node, Map<Integer, List<Integer>> map) {

    //     Queue<Integer> q = new LinkedList<>();
    //     q.offer(node);
    //     int nodes = 0, edges = 0;
    //     while (!q.isEmpty()) {
    //         int curr = q.poll();
    //         if (visited[curr])
    //             continue;
    //         visited[curr] = true;
    //         nodes++;
    //         for (int i : map.get(curr)) {
    //             if (!visited[i]) {
    //                 q.offer(i);
    //                 edges++;
    //             }
    //         }
    //     }

    //     int reqEdges = (nodes * (nodes - 1)) / 2;

    //     if (edges == reqEdges) {
    //         return true;
    //     }
    //     return false;
    // }

    // public boolean solve(int node, Map<Integer, List<Integer>> map) {

    //     Queue<Integer> q = new LinkedList<>();
    //     q.offer(node);

    //     int nodes = 0;
    //     int edges = 0;

    //     while (!q.isEmpty()) {
    //         int curr = q.poll();

    //         if (visited[curr])
    //             continue;

    //         visited[curr] = true;
    //         nodes++;

    //         edges += map.get(curr).size();

    //         for (int next : map.get(curr)) {
    //             if (!visited[next]) {
    //                 q.offer(next);
    //             }
    //         }
    //     }

    //     edges /= 2;

    //     int reqEdges = nodes * (nodes - 1) / 2;

    //     return edges == reqEdges;
    // }

    public boolean solve(int node, Map<Integer, List<Integer>> map) {

        Queue<Integer> q = new LinkedList<>();
        List<Integer> component = new ArrayList<>();

        q.offer(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            component.add(curr);

            for (int next : map.get(curr)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }

        int size = component.size();

        for (int curr : component) {
            if (map.get(curr).size() != size - 1) {
                return false;
            }
        }

        return true;
    }
}