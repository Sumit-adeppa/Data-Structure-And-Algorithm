class Solution {
    public int reverse(int x) {
        int temp = x;
        int rev = 0;

        while (temp != 0) {
            int digit = temp % 10;
            temp /= 10;
            // Overflow check
            if (rev > Integer.MAX_VALUE / 10 ||
               (rev == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 ||
               (rev == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            rev = rev * 10 + digit;
        }

        return rev;

    }
}

/*
    Key constants to know before starting:
    Integer.MAX_VALUE     = 2147483647
    Integer.MAX_VALUE/10  = 214748364   (last safe digit: 7)
    Integer.MIN_VALUE     = -2147483648
    Integer.MIN_VALUE/10  = -214748364  (last safe digit: -8)

    Example 1: x = 123

    temp = 123, 
    rev = 0

    Iteration 1:
    digit = 123 % 10 = 3
    temp  = 123 / 10 = 12
    overflow check: 0 > 214748364? No. 0 < -214748364? No.
    rev = 0 * 10 + 3 = 3

    Iteration 2:
    digit = 12 % 10 = 2
    temp  = 12 / 10  = 1
    overflow check: 3 > 214748364? No. 3 < -214748364? No.
    rev = 3 * 10 + 2 = 32

    Iteration 3:
    digit = 1 % 10 = 1
    temp  = 1 / 10  = 0
    overflow check: 32 > 214748364? No. 32 < -214748364? No.
    rev = 32 * 10 + 1 = 321
    
    temp = 0, exit loop.
    return 321. Correct.
*/