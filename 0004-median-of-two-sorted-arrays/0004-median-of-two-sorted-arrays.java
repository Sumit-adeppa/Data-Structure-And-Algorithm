class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merge = new int[m + n];
        for (int i = 0; i < m; i++) {
            merge[i] = nums1[i];
        } 
        for (int i = 0; i < n; i++) {
            merge[i + m] = nums2[i];
        }
        Arrays.sort(merge);
        int size = m + n;
        if (size % 2 == 0) {
            return (merge[size/2-1] + merge[size/2])/2.0;
        }
        return merge[size/2];
    }
}