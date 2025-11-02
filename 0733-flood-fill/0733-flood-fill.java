class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int n = image.length;
        int m = image[0].length;
        int ic = image[sr][sc];

        if (ic == color) return image;

        helper(image, sr, sc, ic, color, n, m);
        return image;
    }

    public void helper(int image[][], int i, int j, int ic,  int colour, int n, int m) {

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(i,j));
        image[i][j] = colour;

        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, 1, -1};

        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int cr = curr.x;
            int cc = curr.y;

            for(int k=0; k<4; k++) {
                int ii = cr+dx[k];
                int jj = cc+dy[k];
                if(ii<0 || ii>=n || jj<0 || jj>=m || image[ii][jj] != ic) {
                    continue;
                }
                q.offer(new Pair(ii,jj));
                image[ii][jj] = colour;
            }
        }
    }

    class Pair{
        int x,y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}