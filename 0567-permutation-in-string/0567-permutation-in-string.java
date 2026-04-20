class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        //Step 1: Count frequency of character in p
        for (char ch : s1.toCharArray()) {
            s1Freq[ch - 'a']++;
        }

        int windowSize = s1.length();

        //Step 2: First window
        for (int i = 0; i < windowSize; i++) {
            windowFreq[s2.charAt(i) - 'a']++;
        }

        if (matches(s1Freq, windowFreq)) return true;

        //Step 3: Sliding Window
        for (int i = windowSize; i < s2.length(); i++) {
            windowFreq[s2.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i - windowSize) - 'a']--;
            if (matches(s1Freq, windowFreq)) return true;
        }

        return false;
    }

    static boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}