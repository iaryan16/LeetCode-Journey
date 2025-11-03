class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int cost = 0;

        for(int i=0; i<n-1; i++) {
            char ch1 = colors.charAt(i);
            char ch2 = colors.charAt(i+1);
            if(ch1 == ch2) {
                if(neededTime[i]<neededTime[i+1]) {
                    cost += neededTime[i];
                } else {
                    cost += neededTime[i+1];
                    neededTime[i+1] = neededTime[i];
                }  
            }
        }

        return cost;
    }
}