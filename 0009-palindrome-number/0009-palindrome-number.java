class Solution {
    public boolean isPalindrome(int x) {

        if (x < 0) return false;

        int temp = x;
        int rev = 0;

        while (x > 0) {
            int digit = x % 10;
            rev = rev * 10 + digit;
            x /= 10; 
        }

        return temp == rev;
    }
}
/*
    x = 121
    x = 121, so the negative check passes.

    temp = 121, rev = 0

    Iteration 1:
    digit = 121 % 10 = 1
    rev   = 0 * 10 + 1 = 1
    x     = 121 / 10 = 12

    Iteration 2:
    digit = 12 % 10 = 2
    rev   = 1 * 10 + 2 = 12
    x     = 12 / 10 = 1

    Iteration 3:
    digit = 1 % 10 = 1
    rev   = 12 * 10 + 1 = 121
    x     = 1 / 10 = 0

    x = 0, exit loop.
    
    return temp == rev => 121 == 121 => true. Correct.
*/