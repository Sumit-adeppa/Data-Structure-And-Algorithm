class Solution {
    public int compress(char[] chars) {
        int write = 0;   // where we write compressed output
        int read = 0;    // where we read input

        while (read < chars.length) {
            char ch = chars[read];
            int count = 0;

            while (read < chars.length && chars[read] == ch) {
                read++;
                count++;
            }

            chars[write++] = ch;

            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}