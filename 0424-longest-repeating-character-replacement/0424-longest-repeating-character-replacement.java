class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            //include current character
            freq[s.charAt(right) - 'A']++;
            //Update max Frequency
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            //Check if window is invalid
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            // Update answer
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}