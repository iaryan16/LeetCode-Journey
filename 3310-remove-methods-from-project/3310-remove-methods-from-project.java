class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge : invocations) {
            graph.get(edge[0]).add(edge[1]);
        }

        Set<Integer> bug = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        q.offer(k);
        bug.add(k);

        while(!q.isEmpty()) {
            int node = q.poll();
            for(int nei : graph.get(node)) {
                if(!bug.contains(nei)) {
                    bug.add(nei);
                    q.offer(nei);
                }
            }
        }

        for(int[] edge : invocations) {
            int u = edge[0], v = edge[1];
            if(!bug.contains(u) && bug.contains(v)) {
                return create(n);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(!bug.contains(i)) ans.add(i);
        }

        return ans;
    }

    public List<Integer> create(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(i);
        }
        return list;
    }
}