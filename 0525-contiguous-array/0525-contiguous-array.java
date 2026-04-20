class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLength = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) sum += 1;
            else sum += -1;

            if (map.containsKey(sum)) {
                int prevIndex = map.get(sum);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                map.put(sum, i);
            }
        }
        return maxLength;
    }
}