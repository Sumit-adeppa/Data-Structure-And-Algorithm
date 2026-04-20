class Solution {
    public int removeElement(int[] nums, int val) {
        int write = 0;   // position to place next valid element

        for (int read = 0; read < nums.length; read++) {

            // if current element is NOT equal to val, keep it
            if (nums[read] != val) {
                nums[write] = nums[read];
                write++;
            }
        }

        // write tells how many elements are NOT equal to val
        return write;

    }
}