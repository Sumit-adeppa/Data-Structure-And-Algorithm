class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        //Step 1: Frequency map of t
        int[] freq = new int[128];
        for (char c : t.toCharArray()) freq[c]++;

        int left = 0;
        int right = 0;
        int required = t.length(); // Total character needed
        int minLen = Integer.MAX_VALUE;
        int start = 0; // Start index of minium window

        //Step 2: Sliding window
        while (right < s.length()) {

            char rchar = s.charAt(right);

            //Step 3: include current character
            if (freq[rchar] > 0) required--;
            freq[rchar]--;
            right++;

            // Step 4: Shrink window when valid
            while (required == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char lchar = s.charAt(left);
                freq[lchar]++;

                if (freq[lchar] > 0) required++;
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}