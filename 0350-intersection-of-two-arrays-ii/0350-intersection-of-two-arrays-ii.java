class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        // Step 1: sort both arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();
        int p1 = 0, p2 = 0;

        // Step 2: two pointers advance together
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                p1++;                    // nums1 is behind, advance it
            } else if (nums1[p1] > nums2[p2]) {
                p2++;                    // nums2 is behind, advance it
            } else {
                result.add(nums1[p1]);   // match: record, advance both
                p1++;
                p2++;
            }
        }

        // Step 3: convert to int[]
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }

        return arr;

        
    }
}