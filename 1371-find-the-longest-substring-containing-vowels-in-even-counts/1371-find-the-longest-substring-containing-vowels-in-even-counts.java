class Solution {
    public int findTheLongestSubstring(String s) {
        // Map to store first index of each state
        Map<Integer, Integer> map = new HashMap<>();
        int state = 0;  // 5-bit mask: a,e,i,o,u
        int maxLen = 0;
        // Initial state (all vowels even) at index -1
        map.put(0, -1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // Toggle corresponding bit if vowel
            if (ch == 'a') state ^= (1 << 0);
            else if (ch == 'e') state ^= (1 << 1);
            else if (ch == 'i') state ^= (1 << 2);
            else if (ch == 'o') state ^= (1 << 3);
            else if (ch == 'u') state ^= (1 << 4);
            // If state seen before, update max length
            if (map.containsKey(state)) maxLen = Math.max(maxLen, i - map.get(state));
            // Otherwise store first occurrence
            else map.put(state, i);
        }
        return maxLen;
    }
}