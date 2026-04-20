class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        int prefixSum = 0;
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        for (int num : nums) {
            prefixSum += num;
            if (set.contains(prefixSum - target)) {
                answer++;
                prefixSum = 0;
                set.clear();
                set.add(0);
            } else {
                set.add(prefixSum);
            }
        }
        return answer;
    }
}