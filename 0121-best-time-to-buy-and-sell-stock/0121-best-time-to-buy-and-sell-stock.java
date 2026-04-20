class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max_Profit = 0;
        int buyPrice = prices[0];

        for (int i = 1; i < n; i++) {
            int cur_Profit = prices[i] - buyPrice;
            if (cur_Profit > max_Profit) {
                max_Profit = cur_Profit;
            }
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            }
        }

        return max_Profit;
    }
}