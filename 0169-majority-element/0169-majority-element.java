class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) candidate = num;
            count += (num == candidate) ? 1 : -1; 
        }

        return candidate;
    }
}

/* 
    Dry run on [2, 2, 1, 1, 1, 2, 2]:
    Index 0: num=2 | count=0, so candidate=2, count=1
    Index 1: num=2 | num==candidate, count=2
    Index 2: num=1 | num!=candidate, count=1
    Index 3: num=1 | num!=candidate, count=0
    Index 4: num=1 | count=0, so candidate=1, count=1
    Index 5: num=2 | num!=candidate, count=0
    Index 6: num=2 | count=0, so candidate=2, count=1
    Final candidate = 2. Correct.
*/