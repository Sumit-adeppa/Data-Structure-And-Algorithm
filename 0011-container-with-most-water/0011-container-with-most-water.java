/* 
    height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
    Indices:  0  1  2  3  4  5  6  7  8
    
    left = 0, right = 8, max = 0

    Iteration 1:
    left=0, right=8
    width   = 8 - 0 = 8
    heights = min(height[0], height[8]) = min(1, 7) = 1
    area    = 8 * 1 = 8
    max     = max(0, 8) = 8
    height[0]=1 < height[8]=7, so left++
    left=1

    Iteration 2:
    left=1, right=8
    width   = 8 - 1 = 7
    heights = min(height[1], height[8]) = min(8, 7) = 7
    area    = 7 * 7 = 49
    max     = max(8, 49) = 49
    height[1]=8 > height[8]=7, so right--
    right=7

    Iteration 3:
    left=1, right=7
    width   = 7 - 1 = 6
    heights = min(height[1], height[7]) = min(8, 3) = 3
    area    = 6 * 3 = 18
    max     = max(49, 18) = 49 (no change)
    height[1]=8 > height[7]=3, so right--
    right=6

    Iteration 4:
    left=1, right=6
    width   = 6 - 1 = 5
    heights = min(height[1], height[6]) = min(8, 8) = 8
    area    = 5 * 8 = 40
    max     = max(49, 40) = 49 (no change)
    height[1]=8 == height[6]=8, so right-- (else branch)
    right=5

    Iteration 5:
    left=1, right=5
    width   = 5 - 1 = 4
    heights = min(height[1], height[5]) = min(8, 4) = 4
    area    = 4 * 4 = 16
    max     = max(49, 16) = 49 (no change)
    height[1]=8 > height[5]=4, so right--
    right=4

    Iteration 6:
    left=1, right=4
    width   = 4 - 1 = 3
    heights = min(height[1], height[4]) = min(8, 5) = 5
    area    = 3 * 5 = 15
    max     = max(49, 15) = 49 (no change)
    height[1]=8 > height[4]=5, so right--
    right=3

    Iteration 7:
    left=1, right=3
    width   = 3 - 1 = 2
    heights = min(height[1], height[3]) = min(8, 2) = 2
    area    = 2 * 2 = 4
    max     = max(49, 4) = 49 (no change)
    height[1]=8 > height[3]=2, so right--
    right=2

    Iteration 8:
    left=1, right=2
    width   = 2 - 1 = 1
    heights = min(height[1], height[2]) = min(8, 6) = 6
    area    = 1 * 6 = 6
    max     = max(49, 6) = 49 (no change)
    height[1]=8 > height[2]=6, so right--
    right=1

    left=1, right=1
    left < right? No. Exit loop.
    return 49. Correct.

    Area formula to burn into memory:
        area = (right - left) * min(height[left], height[right])

*/
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