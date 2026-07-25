class Solution {
    public int maxProfit(int[] prices) {
        
        int l =0, r = prices.length;
        int max = 0;
        int init = prices[0];
        while(l < r) {
            if(prices[l] < init) {
                init = prices[l];
            }
            max = Math.max(prices[l] - init, max);
            l++;
        }
        return max;
    }
}