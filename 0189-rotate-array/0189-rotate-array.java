class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}

/*
    Original: [1, 2, 3, 4, 5, 6, 7]
    k = 3 % 7 = 3

    Step 1: Reverse entire array
        [7, 6, 5, 4, 3, 2, 1]

    Step 2: Reverse first k=3 elements → indices 0 to 2
        [5, 6, 7, 4, 3, 2, 1]

    Step 3: Reverse remaining n-k=4 elements → indices 3 to 6
        [5, 6, 7, 1, 2, 3, 4]

    Result: [5, 6, 7, 1, 2, 3, 4] ✓
*/