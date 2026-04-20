class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // exactly k odds = atMost(k) - atMost(k - 1)
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    private static int atMost(int[] nums, int k) {
        //Critical fix: no subarray can have < 0 odd numbers
        if (k < 0) return 0;
        int left = 0;
        int oddCount = 0;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            // include nums[right]
            if (nums[right] % 2 != 0) {
                oddCount++;
            }
            // shrink window until valid
            while (oddCount > k) {
                if (nums[left] % 2 != 0) {
                    oddCount--;
                }
                left++;
            }
            // number of valid subarrays ending at 'right'
            count += (right - left + 1);
        }
        return count;
    }
}