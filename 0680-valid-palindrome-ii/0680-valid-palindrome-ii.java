class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // If characters match, move inward
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }
            // First mismatch: try deleting one character
            else {
                // Option 1: skip left character
                // Option 2: skip right character
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }
        return true;
    }

    static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

}