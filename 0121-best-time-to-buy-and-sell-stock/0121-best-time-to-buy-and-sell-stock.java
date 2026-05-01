class Solution {
    public int maxProfit(int[] prices) {

        /*
            prices = [7, 1, 5, 3, 6, 4]
            Start: buyPrice = 7, max_Profit = 0
            i=1: price=1, cur_Profit = 1-7 = -6,  max_Profit=0,  buyPrice=1
            i=2: price=5, cur_Profit = 5-1 =  4,  max_Profit=4,  buyPrice=1
            i=3: price=3, cur_Profit = 3-1 =  2,  max_Profit=4,  buyPrice=1
            i=4: price=6, cur_Profit = 6-1 =  5,  max_Profit=5,  buyPrice=1
            i=5: price=4, cur_Profit = 4-1 =  3,  max_Profit=5,  buyPrice=1
            Answer: 5

            Two rules per step:
                1. If cur_Profit beats max_Profit, update max_Profit.
                2. If today's price is lower than buyPrice, update buyPrice.
        */

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