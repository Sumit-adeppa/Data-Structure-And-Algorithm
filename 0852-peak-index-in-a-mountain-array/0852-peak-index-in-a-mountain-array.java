class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                // ascending slope → peak is on the right
                left = mid +  1;
            }
            else {
                // descending slope → peak is at mid or on the left
                right = mid;
            }
        }
        // left == right → peak index
        return left;
    }
}