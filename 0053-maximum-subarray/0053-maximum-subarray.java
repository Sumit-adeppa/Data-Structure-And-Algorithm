class Solution {
    public int maxSubArray(int[] nums) {

        // To find maximum sum possible
        int max_so_for = nums[0];

        // To store the maximum found at position
        int curr_max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curr_max = Math.max(nums[i], nums[i] + curr_max);
            max_so_for = Math.max(curr_max, max_so_for);
        }

        return max_so_for;
        
    }
}