class Solution {
    public List<Integer> partitionLabels(String s) {
        // Step 1: Store last occurrence of each character
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }  

        List<Integer> result = new ArrayList<>();

        int start = 0;  // start of current partition
        int end = 0;    // end of current partition

        // Step 2: Traverse the string
        for (int i = 0; i < s.length(); i++) {

            // Update the farthest end needed
            end = Math.max(end, last[s.charAt(i) - 'a']);

            // Step 3: If we reached the end, cut the partition
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1; // start next partition
            }
        }

        return result;
    }
}