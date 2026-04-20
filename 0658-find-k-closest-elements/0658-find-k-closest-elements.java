class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;

        // Shrink the window until its size becomes k
        while (right - left + 1 > k) {

            // Compare distances from x
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;        // remove left element
            } else {
                right--;       // remove right element
            }
        }

        // Collect result
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}