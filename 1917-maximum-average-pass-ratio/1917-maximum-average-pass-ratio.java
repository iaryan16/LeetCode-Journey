class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        
        int n = classes.length;
        double arr[] = new double[n];
        double max = -1;
        int maxIdx = -1;
        for(int i=0; i<n; i++) {
            arr[i] = (double)(classes[i][0] + 1)/(double)(classes[i][1] + 1) - (double)(classes[i][0])/(double)(classes[i][1]);
            if(arr[i] > max) {
                maxIdx = i;
            }
        }

        classes[maxIdx][0] += extraStudents;
        classes[maxIdx][1] += extraStudents;
        double total = 0;
        for(int i=0; i<n; i++) {
            total += (double)classes[i][0] / (double)classes[i][1];
        }

        return total/n;
        
    }
}