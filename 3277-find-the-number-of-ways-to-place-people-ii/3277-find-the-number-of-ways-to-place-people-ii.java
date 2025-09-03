class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if(a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int c = 0;
        for(int i=0; i<points.length; i++) {
            int xA = points[i][0];
            int yA = points[i][1];
            int maxY = Integer.MIN_VALUE;
            for(int j=i+1; j<points.length; j++) {
                int xB = points[j][0];
                int yB = points[j][1];
                if(yA >= yB && maxY < yB ) {
                    c++;
                    maxY = yB;
                }
            }
        }
        return c;
    }
}