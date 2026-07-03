class Solution {
    public int minTimeToReach(int[][] moveTime) {

        return bfs(moveTime);
    }

    public int bfs(int moveTime[][]) {

         
        int n = moveTime.length;
        int m = moveTime[0].length;
        // boolean visited[][] = new boolean[n][m];
        long distance[][] = new long[n][m];
        for(int i=0; i<n; i++) Arrays.fill(distance[i], Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        distance[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});

        while(!pq.isEmpty()) {
            int curr[] = pq.poll();
            int x = curr[0];
            int y = curr[1];
            int time = curr[2];
            if(x == n-1 && y == m-1) {
                return time;
            }

            if (time > distance[x][y])
                continue;

            // if(visited[x][y]) 
            //     continue;

            // visited[x][y] = true;

            for(int dir[] : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                // if(newX < 0 || newX >= n || newY < 0 || newY >= m || visited[newX][newY])
                //     continue;

                if(newX < 0 || newX >= n || newY < 0 || newY >= m)
                    continue;

                int newTime = Math.max(time, moveTime[newX][newY]) + 1;

                if(distance[newX][newY] > newTime) {
                    distance[newX][newY] = newTime;
                    pq.offer(new int[]{newX, newY, newTime});
                }
            }   
        }
        return -1;
    }
}