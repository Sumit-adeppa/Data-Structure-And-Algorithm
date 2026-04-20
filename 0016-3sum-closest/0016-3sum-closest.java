class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Step 1: Sort the Array
        Arrays.sort(nums);
        // Step 2: Initialize the closest Sum
        int closestSum = nums[0] + nums[1] + nums[2];
        // Step 3: Fix the one element
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            // Step 4: Two-pointer approach
            while (left < right) {
                // Update the closest sum if current is closer
                int currentSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                    closestSum =  currentSum;
                }
                // Move pointers
                if (currentSum == target) return currentSum;
                else if (currentSum < target) left++;
                else right--;

            }
        }
        return closestSum;
    }
}