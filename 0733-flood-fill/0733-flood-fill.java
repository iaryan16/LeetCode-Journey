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

        if(i<0 || i>=n || j<0 || j>=m || image[i][j] != ic) {
            return ;
        }
        
        image[i][j] = colour;
        
        helper(image, i+1, j, ic, colour, n, m);
        helper(image, i-1, j, ic, colour, n, m);
        helper(image, i, j+1, ic, colour, n, m);
        helper(image, i, j-1, ic, colour, n, m);
    }
}