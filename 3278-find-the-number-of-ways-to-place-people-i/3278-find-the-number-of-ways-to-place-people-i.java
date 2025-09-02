class Solution {
    public int numberOfPairs(int[][] points) {

        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(b[1], a[1]);
        });

        int c = 0;
        
        for (int i = 0; i < points.length; i++) {
            int maxY = Integer.MIN_VALUE;
            int yA = points[i][1];

            for (int j = i + 1; j < points.length; j++) {
                int yB = points[j][1];
                if (yB <= yA && yB > maxY) {
                    c++;
                    maxY = yB;
                }
            }
        }
        return c;
    }
}