class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // Continue binary search while pointers haven't crossed
        while (left < right) {
            int mid = (left + right) / 2;
            // If middle element < right neighbor, peak must be on right half
            // (array increases here, so peak can't be on left)
            if (nums[mid] < nums[mid + 1]) left = mid + 1;
            // Otherwise, peak must be on left half (including mid)
            // (array decreases here or mid is peak)
            else right = mid;
        }
        // When loop ends, left == right points to a peak element
        return left;
    }
}