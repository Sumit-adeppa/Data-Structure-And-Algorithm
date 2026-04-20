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