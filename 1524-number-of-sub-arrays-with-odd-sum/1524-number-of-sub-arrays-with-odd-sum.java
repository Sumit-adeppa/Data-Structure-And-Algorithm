class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1000000007;
        int prefixSum = 0;
        int evenPrefix = 1;
        int oddPrefix = 0;
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (prefixSum % 2 != 0) {
                answer += evenPrefix;
                oddPrefix++;
            } else {
                answer += oddPrefix;
                evenPrefix++;
            }
            answer %= MOD;
        }
        return answer;
    }
}