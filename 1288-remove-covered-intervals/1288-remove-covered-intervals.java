class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        int n = intervals.length;
        int c = 0;
        for(int i=0; i<n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            boolean flag = true;
            for(int j=i+1; j<n; j++) {
                int currStart = intervals[j][0];
                int currEnd = intervals[j][1];
                if(start >= currStart && end <= currEnd) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                c++;
            }
        }

        return c;
    }
}