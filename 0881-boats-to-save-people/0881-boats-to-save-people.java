class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // Strp 1: Sort the array
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int boats = 0;
        // Step 2: Apply Two pointer
        while (left <= right) {
            // If lightest + heaviest can go together
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            }
            // Heaviest person goes alone
            else right--;
            // One boat is used in every iteration
            boats++;
        }
        return boats;
    }
}