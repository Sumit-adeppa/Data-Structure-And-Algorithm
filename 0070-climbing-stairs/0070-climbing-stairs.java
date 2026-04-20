class Solution {
    public int climbStairs(int n) {
        List<Integer> dp = new ArrayList<>();

        // Base cases
        dp.add(1); // dp[0]
        dp.add(1); // dp[1]

        for (int i = 2; i <= n; i++) {
            dp.add(dp.get(i - 1) + dp.get(i - 2));
        }

        return dp.get(n);
    }
}