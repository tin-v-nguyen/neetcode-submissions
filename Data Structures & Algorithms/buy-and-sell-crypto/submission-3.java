class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyDay = 0;
        int sellDay = 1;
        while (sellDay < prices.length) {
            profit = Math.max(profit, prices[sellDay] - prices[buyDay]);
            if (prices[buyDay] >= prices[sellDay]) {
                buyDay = sellDay;
            }
            sellDay++;
        }
        return profit;
    }
    
}
