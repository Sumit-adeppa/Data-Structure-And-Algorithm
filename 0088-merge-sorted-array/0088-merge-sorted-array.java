class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m + n];

        for (int i = 0; i < nums1.length; i++) merged[i] = nums1[i];
        
        for (int i = 0; i < nums2.length; i++) merged[m + i] = nums2[i];

        Arrays.sort(merged);

                for (int i = 0; i < merged.length; i++) {
            nums1[i] = merged[i];
        }
        
    }
}