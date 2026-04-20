class Solution {
    public int singleNumber(int[] arr) {

        int n = arr.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
           sum ^= arr[i];
        }

        return sum;
        
    }
}