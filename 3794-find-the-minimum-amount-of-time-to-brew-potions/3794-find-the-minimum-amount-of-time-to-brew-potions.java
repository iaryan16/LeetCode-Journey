class Solution {
    public long minTime(int[] skill, int[] mana) {
        
        int start = 0;

        int n = skill.length;
        int m = mana.length;

        long time[] = new long[n];
        for(int i=0; i<m; i++) {
            time[0] += skill[0] * mana[i];
            for(int j=1; j<n; j++) {
                time[j] = Math.max(time[j-1], time[j]) + (long)mana[i] * skill[j];
            }

            for(int j=n-2; j>=0; j--) {
                time[j] = time[j+1] - (long)mana[i] * skill[j+1];
            }
        }

        return time[n-1];
    }
}