class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s, 0, s.length(), k);
    }

    // This function solves the problem for substring s[start ... end-1]
    static int helper(String s, int start, int end, int k) {
        // Base case:
        // If substring length is smaller than k,
        // no character can appear k times
        if (end - start < k) return 0;

        //Step 1: Count character frequencies
        int[] freq = new int[26];
        for (int i = start; i < end; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        //Step 2: Find a "bad" character
        for (int i = start; i < end; i++) {
            if (freq[s.charAt(i) - 'a'] < k) {
                //Step 3: Split and recurse
                int left = helper(s, start, i, k);
                int right = helper(s, i + 1, end, k);
                return Math.max(left, right);
            }
        }
        //Step 4: No bad characters found
        // Entire substring is valid
        return end - start;
    }
}