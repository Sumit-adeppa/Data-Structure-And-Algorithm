class Solution {
    public int majorityElement(int[] nums) {
         int ele = nums[0];
        int count = 0;

        for (int value : nums) {
            if (count == 0) {
                ele = value;
            }
            if (value == ele) {
                count++;
            } else  {
                count--;
            }
        }

        return ele;
    }
}