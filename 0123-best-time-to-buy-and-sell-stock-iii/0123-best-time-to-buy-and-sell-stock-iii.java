class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;  // best state after 1st buy
        int sell1 = 0;                 // best state after 1st sell
        int buy2 = Integer.MIN_VALUE;  // best state after 2nd buy
        int sell2 = 0;                 // best state after 2nd sell

        for (int price : prices) {
            buy1  = Math.max(buy1,  -price);           // buy as cheap as possible
            sell1 = Math.max(sell1,  buy1  + price);   // sell for max profit
            buy2  = Math.max(buy2,   sell1 - price);   // reinvest 1st profit into 2nd buy
            sell2 = Math.max(sell2,  buy2  + price);   // final total profit
        }

        return sell2;
    }
}
        /*
            DRY RUN: prices = [3, 3, 5, 0, 0, 3, 1, 4]
            Start:
            buy1  = -INF
            sell1 =  0
            buy2  = -INF
            sell2 =  0

            Each day, update in this order:
            buy1  = max(buy1,  -price)       // buy as cheap as possible
            sell1 = max(sell1,  buy1 + price) // sell for max profit
            buy2  = max(buy2,  sell1 - price) // use first profit to fund second buy
            sell2 = max(sell2, buy2 + price) // final profit

            Day 0, price = 3:
            buy1  = max(-INF, -3)     = -3
            sell1 = max(0,  -3+3)     = 0
            buy2  = max(-INF, 0-3)    = -3
            sell2 = max(0,  -3+3)     = 0

            Day 1, price = 3:
            buy1  = max(-3, -3)       = -3
            sell1 = max(0,  -3+3)     = 0
            buy2  = max(-3, 0-3)      = -3
            sell2 = max(0,  -3+3)     = 0

            Day 2, price = 5:
            buy1  = max(-3, -5)       = -3
            sell1 = max(0,  -3+5)     = 2      <-- sold first at 5, bought at 3
            buy2  = max(-3, 2-5)      = -3
            sell2 = max(0,  -3+5)     = 2

            Day 3, price = 0:
            buy1  = max(-3, -0)       = 0      <-- buy at 0 is better
            sell1 = max(2,  0+0)      = 2
            buy2  = max(-3, 2-0)      = 2      <-- use profit from first sell to fund buy2
            sell2 = max(2,  2+0)      = 2

            Day 4, price = 0:
            buy1  = max(0, 0)         = 0
            sell1 = max(2, 0+0)       = 2
            buy2  = max(2, 2-0)       = 2
            sell2 = max(2, 2+0)       = 2

            Day 5, price = 3:
            buy1  = max(0, -3)        = 0
            sell1 = max(2, 0+3)       = 3      <-- or sell at 3 after buying at 0
            buy2  = max(2, 3-3)       = 2
            sell2 = max(2, 2+3)       = 5      <-- second sell kicks in: profit 3+3 = 6? wait...
            Let me trace sell2 carefully:
            buy2 = 2 means "I have 2 profit from first trade, then bought at 3, so net = 2-3 = -1"... but we took max(2, 3-3) = max(2, 0) = 2. So buy2 stayed at 2.
            sell2 = max(2, 2+3) = max(2, 5) = 5.

            Day 6, price = 1:
            buy1  = max(0, -1)        = 0
            sell1 = max(3, 0+1)       = 3
            buy2  = max(2, 3-1)       = 2
            sell2 = max(5, 2+1)       = 5

            Day 7, price = 4:
            buy1  = max(0, -4)        = 0
            sell1 = max(3, 0+4)       = 4
            buy2  = max(2, 4-4)       = 2      <-- 4-4 = 0, buy2 stays at 2
            sell2 = max(5, 2+4)       = 6      <-- final answer
        */