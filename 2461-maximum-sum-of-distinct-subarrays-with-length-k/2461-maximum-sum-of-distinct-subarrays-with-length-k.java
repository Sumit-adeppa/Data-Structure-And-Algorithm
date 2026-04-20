class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long windowSum = 0;
        long maxSum = 0;
        HashSet<Integer> set = new HashSet<>();
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            // If duplicate appears, shrink window
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                windowSum -= nums[left];
                left++;
            }
            // Add current element
            set.add(nums[right]);
            windowSum += nums[right];
            if (right - left + 1 == k) {
                // If window size becomes k
                maxSum = Math.max(maxSum, windowSum);
                // Slide window forward
                set.remove(nums[left]);
                windowSum -= nums[left];
                left++;
            }
        }
        return maxSum;
    }
}