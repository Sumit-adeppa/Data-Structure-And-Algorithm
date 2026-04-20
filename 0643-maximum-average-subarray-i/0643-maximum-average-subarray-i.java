class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double avg = 0;
        int windowSum = 0;
        int maxSum = 0;
        // Step 1: First window sum
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        maxSum = windowSum;
        // Step 2: Slide the window
        for (int i = k; i < nums.length; i++) {
            windowSum = windowSum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, windowSum);
        }
        avg = (double) maxSum / k;
        return  avg;
    }
}