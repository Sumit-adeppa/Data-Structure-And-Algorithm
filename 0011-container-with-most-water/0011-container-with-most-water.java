class Solution {
    public int maxArea(int[] height) {
        // Pointer starting from the leftmost line
        int left = 0;
        // Pointer starting from the rightmost line
        int right = height.length - 1;
        // Variable to store the maximum water area found so far
        int max = 0;
        // Continue until both pointers meet
        while (left < right) {
            // Width of the container = distance between left and right lines
            int width = right - left;
            // Height of the container is limited by the shorter line
            int heights = Math.min(height[left], height[right]);
            // Area of water that can be stored between these two lines
            int area = width * heights;
            // Update maximum area if current area is larger
            max = Math.max(max, area);
            // Move the pointer pointing to the shorter line
            // because the shorter line limits the water
            if (height[left] < height[right]) {
                left++;   // Try to find a taller line on the left
            } else {
                right--;  // Try to find a taller line on the right
            }
        }
        // Return the maximum area found
        return max;
    }
}