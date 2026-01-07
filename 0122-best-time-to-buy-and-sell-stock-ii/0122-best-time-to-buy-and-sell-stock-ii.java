class Solution {
    int dp[][];
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];

        for(int i=0; i<prices.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, prices);
    }

    public int solve(int i, int buy, int prices[]) {
        
        if(i >= prices.length) return 0;

        if(dp[i][buy] != -1) {
            return dp[i][buy];
        }

        if(buy == 0) {
            return dp[i][buy] = Math.max(solve(i+1, 0, prices), 
                            solve(i+1, 1, prices) - prices[i]);
        }

        if(buy == 1) {
            return dp[i][buy] = Math.max(solve(i+1, 1, prices), 
                            solve(i+1, 0, prices) + prices[i]);
        }
        
        return 0;
        
    }
}