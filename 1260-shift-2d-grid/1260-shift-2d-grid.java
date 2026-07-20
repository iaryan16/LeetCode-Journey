class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        int n = grid.length, m = grid[0].length;

        int ele = n * m;
        k = k % ele;

        int ans[][] = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                int newIdx = (i * m + j + k ) % ele;
                int X = newIdx / m;
                int Y = newIdx % m;

                ans[X][Y] = grid[i][j];
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            list.add(new ArrayList<>());
            for(int j=0; j<m; j++) {
                list.get(i).add(ans[i][j]);
            }
        }

        return list;
    }
}