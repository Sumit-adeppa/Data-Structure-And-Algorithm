class Solution {
    public int lengthOfLongestSubstring(String s) {
       Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            // If duplicate found, shrink window from left
            while (set.contains(s.charAt(right ))) {
                set.remove(s.charAt(left));
                left++;
            }
            // Add current character
            set.add(s.charAt(right));
            // Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;    
    }
}

/*Here is the dry run:
    Example 1: s = "abcabcbb", target output = 3.

    State before the loop:
    set = {}, left = 0, maxLength = 0

    right = 0, s[0] = 'a'
    while: set.contains('a')? No. Skip.
    set.add('a') => set = {a}
    maxLength = max(0, 0-0+1) = 1
    Window: [a], left=0, right=0

    right = 1, s[1] = 'b'
    while: set.contains('b')? No. Skip.
    set.add('b') => set = {a, b}
    maxLength = max(1, 1-0+1) = 2
    Window: [a, b], left=0, right=1

    right = 2, s[2] = 'c'
    while: set.contains('c')? No. Skip.
    set.add('c') => set = {a, b, c}
    maxLength = max(2, 2-0+1) = 3
    Window: [a, b, c], left=0, right=2

    right = 3, s[3] = 'a'
    while: set.contains('a')? YES.
    set.remove(s[0]='a'), left++ => left=1, set = {b, c}
    set.contains('a')? No. Exit while.
    set.add('a') => set = {b, c, a}
    maxLength = max(3, 3-1+1) = 3 (no change)
    Window: [b, c, a], left=1, right=3

    right = 4, s[4] = 'b'
    while: set.contains('b')? YES.
    set.remove(s[1]='b'), left++ => left=2, set = {c, a}
    set.contains('b')? No. Exit while.
    set.add('b') => set = {c, a, b}
    maxLength = max(3, 4-2+1) = 3 (no change)
    Window: [c, a, b], left=2, right=4

    right = 5, s[5] = 'c'
    while: set.contains('c')? YES.
    set.remove(s[2]='c'), left++ => left=3, set = {a, b}
    set.contains('c')? No. Exit while.
    set.add('c') => set = {a, b, c}
    maxLength = max(3, 5-3+1) = 3 (no change)
    Window: [a, b, c], left=3, right=5

    right = 6, s[6] = 'b'
    while: set.contains('b')? YES.
    set.remove(s[3]='a'), left++ => left=4, set = {b, c}
    set.contains('b')? YES. (still there)
    set.remove(s[4]='b'), left++ => left=5, set = {c}
    set.contains('b')? No. Exit while.
    set.add('b') => set = {c, b}
    maxLength = max(3, 6-5+1) = 2. No change. Stays 3.
    Window: [c, b], left=5, right=6

    right = 7, s[7] = 'b'
    while: set.contains('b')? YES.
    set.remove(s[5]='c'), left++ => left=6, set = {b}
    set.contains('b')? YES.
    set.remove(s[6]='b'), left++ => left=7, set = {}
    set.contains('b')? No. Exit while.
    set.add('b') => set = {b}
    maxLength = max(3, 7-7+1) = 1. No change. Stays 3.
    Window: [b], left=7, right=7

    return maxLength = 3. Correct.
 */