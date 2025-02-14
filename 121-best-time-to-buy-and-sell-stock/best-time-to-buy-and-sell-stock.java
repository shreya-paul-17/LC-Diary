class Solution {
    public int maxProfit(int[] prices) {
        // Kadane's Algo
        int buy=prices[0], profit=0;
        for(int i=1; i<prices.length; i++) {
            if(prices[i]<buy) {
                buy=prices[i];
            } else if (prices[i] - buy > profit) {
                profit = prices[i]-buy;
            }
        }
        return profit;
    }
}