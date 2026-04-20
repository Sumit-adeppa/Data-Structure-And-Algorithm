class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int reminder = prefixSum % k;
            if (reminder < 0) reminder += k;
            if (map.containsKey(reminder)) answer += map.get(reminder);
            map.put(reminder, map.getOrDefault(reminder, 0) + 1);
        }
        return answer;
    }
}