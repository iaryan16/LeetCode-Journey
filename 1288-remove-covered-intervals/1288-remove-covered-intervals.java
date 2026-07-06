class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int n = intervals.length;
        int c = 0;
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1; i<n; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if(currStart >= start && currEnd <= end) {
                c++;
            } else {
                start = currStart;
                end = currEnd;
            }
        }

        return n-c;
    }
}