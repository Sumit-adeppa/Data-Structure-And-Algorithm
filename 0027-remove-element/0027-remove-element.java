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

/*
    Dry run on [3, 2, 2, 3], val=3:
    k=0, i=0 | nums[0]=3 == val  | skip       | k=0
    k=0, i=1 | nums[1]=2 != val  | nums[0]=2  | k=1
    k=1, i=2 | nums[2]=2 != val  | nums[1]=2  | k=2
    k=2, i=3 | nums[3]=3 == val  | skip       | k=2

    Array after: [2, 2, _, _]
    Return k=2 ✓ 
*/