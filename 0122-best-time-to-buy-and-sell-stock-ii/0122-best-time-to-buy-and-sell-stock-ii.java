class Solution {
    public int maxProfit(int[] prices) {

        /*
            Dry Run: prices = [7, 1, 5, 3, 6, 4]
            Day:    0    1    2    3    4    5
            Price:  7    1    5    3    6    4

            Day 0 → Day 1:   7 → 1   Price DROPPED.  Do nothing.
            Day 1 → Day 2:   1 → 5   Price ROSE.     Earn 5-1 = +4
            Day 2 → Day 3:   5 → 3   Price DROPPED.  Do nothing.
            Day 3 → Day 4:   3 → 6   Price ROSE.     Earn 6-3 = +3
            Day 4 → Day 5:   6 → 4   Price DROPPED.  Do nothi
            Total =      7

            ONE RULE TO REMEMBER
            If prices[tomorrow] > prices[today]
                profit += prices[tomorrow] - prices[today]
        */

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