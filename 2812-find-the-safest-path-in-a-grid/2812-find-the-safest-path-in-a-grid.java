class Solution {
    class Pair {
        int x, y;
        Pair(int a, int b) {
            x = a;
            y = b;
        }
    }
    int dir[][] = {{1,0}, {0, 1}, {-1, 0}, {0, -1}};
    int score[][];
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int m = grid.get(0).size();
        score = new int[n][m];

        for(int i=0; i<n; i++) {
            Arrays.fill(score[i], Integer.MAX_VALUE);
        }

        bfs(grid);

        boolean visited[][] = new boolean[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return b[2] - a[2];
        });

        pq.offer(new int[]{0, 0, score[0][0]});

        while(!pq.isEmpty()) {
            int curr[] = pq.poll();
            int x = curr[0];
            int y = curr[1];
            int s = curr[2];

            if(x == n-1 && y== m-1) return s;

            if(visited[x][y]) continue;

            visited[x][y] = true;

            for(int arr[] : dir) {
                int newX = x + arr[0];
                int newY = y + arr[1];
                if(Math.min(newX, newY) >= 0 && Math.max(newX, newY) < n && !visited[newX][newY]) {
                    int newScore = Math.min(s, score[newX][newY]);
                    pq.offer(new int[]{newX, newY, newScore});
                    
                }
            }
        }

        return -1;

    }

    public void bfs(List<List<Integer>> grid) {
        
        Queue<Pair> q = new LinkedList();
        int n = grid.size();
        int m = grid.get(0).size();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid.get(i).get(j) == 1) {
                    score[i][j] = 0;
                    q.offer(new Pair(i, j));
                }
            }
        }
    
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            int s = score[x][y];
            for(int arr[] : dir) {
                int newX = x + arr[0];
                int newY = y + arr[1];
                if(Math.min(newX, newY) >= 0 && Math.max(newX, newY) < n && 
                score[newX][newY] > s + 1) {
                    score[newX][newY] = s + 1;
                    q.offer(new Pair(newX, newY));
                }
            }
        }
    }
}