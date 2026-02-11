class Solution {

    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n = gas.length;
        int total = 0;
        int curr = 0;

        int idx = -1;
        for(int i=0; i<n; i++) {
            if(idx == -1) {
                idx = i;
            }
            total += (gas[i] - cost[i]);
            curr += (gas[i] - cost[i]);

            if(curr < 0) {
                curr = 0;
                idx = -1;
            }
        }
        
        return total < 0 ? -1 : idx;
    }
}