class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];

        //Step 1: Count frequency os character in p
        for (char ch : p.toCharArray()) {
            pFreq[ch - 'a']++;
        }

        int left = 0;
        int right = 0;
        int windowSize = p.length();

        // Step 2: Sliding window
        while (right < s.length()) {

            // Add current charater to window
            windowFreq[s.charAt(right) - 'a']++;
            right++;

            // When window size matches p length
            if (right - left == windowSize) {

                //Step 3: Compare frequency arrays
                if (Arrays.equals(pFreq, windowFreq)){
                    result.add(left);
                }

                // Remove leftmost character
                windowFreq[s.charAt(left) - 'a']--;
                left++;

            }
        }

        return result;

    }
}