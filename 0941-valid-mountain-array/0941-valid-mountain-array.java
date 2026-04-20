class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;

        // 1. Walk up to the peak
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        // 2. Peak cannot be the first or last element
        // (Must have an increasing slope and a decreasing slope)
        if (i == 0 || i == n - 1) {
            return false;
        }

        // 3. Walk down from the peak
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        // 4. If we reached the end, it's a valid mountain
        return i == n - 1;
    }
}