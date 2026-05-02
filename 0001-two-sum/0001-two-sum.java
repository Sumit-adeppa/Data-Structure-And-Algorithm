class Solution {
    /*
        nums = [2, 7, 11, 15], target = 9.
        State before the loop starts:
        map = {}

        i = 0, nums[0] = 2
        comp = 9 - 2 = 7
        map.containsKey(7)? No.
        map.put(2, 0)
        map = {2:0}

        i = 1, nums[1] = 7
        comp = 9 - 7 = 2
        map.containsKey(2)? YES.
        return new int[]{map.get(2), 1} => [0, 1]
        Output: [0, 1]. Loop ends here.

     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (map.containsKey(comp)) 
                return new int[]{map.get(comp), i};
            map.put(nums[i], i);
        }
        return null;
    }
}
