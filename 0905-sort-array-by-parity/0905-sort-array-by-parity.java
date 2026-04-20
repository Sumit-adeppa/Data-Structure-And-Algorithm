class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            // left: skip over even numbers (they are already correct)
            while (left < right && nums[left] % 2 == 0) left++;

            // right: skip over odd numbers (they are already correct)
            while (left < right && nums[right] % 2 != 0) right--;

            // left points to odd, right points to even → swap
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }

        }

        return nums;

    }
}