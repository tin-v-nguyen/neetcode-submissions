class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int max = 0;
        int buy = 0;
        int sell = 1;

        while (sell < prices.length) {
            int profit = prices[sell] - prices[buy];
            if (profit > max) {
                max = profit;
            } else if (prices[sell] < prices[buy]) {
                buy = sell;
            }
            sell++;
        }

        return max;
    }
}
