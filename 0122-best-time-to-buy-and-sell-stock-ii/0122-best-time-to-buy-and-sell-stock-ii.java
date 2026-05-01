class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0; // total profit accumulated

        // start from day 1, compare with previous day
        for (int i = 1; i < prices.length; i++) {
            // if today is higher than yesterday, take the gain
            if (prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;

    }
}