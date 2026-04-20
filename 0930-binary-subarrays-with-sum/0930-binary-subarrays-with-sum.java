class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
         int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (map.containsKey(prefixSum - goal))
                answer += map.get(prefixSum - goal);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return answer;
    }
}