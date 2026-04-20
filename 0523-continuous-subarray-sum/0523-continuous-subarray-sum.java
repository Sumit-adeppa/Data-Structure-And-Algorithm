class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Case 1: k == 0
        if (k == 0) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 0 && nums[i - 1] == 0) {
                    return true;
                }
            }
            return false;
        }

        int runningSum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        // remainder 0 occurs at index -1
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            int remainder = runningSum % k;

            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) >= 2) {
                    return true;
                }
            } else {
                // store FIRST occurrence of this remainder
                map.put(remainder, i);
            }
        }
        return false;
    }
}