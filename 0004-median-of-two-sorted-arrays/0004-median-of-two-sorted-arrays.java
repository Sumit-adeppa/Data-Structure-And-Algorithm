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

/*
    nums1 = [1, 3], nums2 = [2]
    m = 2, n = 1

    merge = new int[3] => [0, 0, 0]

    First loop (copy nums1):
    i=0: merge[0] = nums1[0] = 1 => [1, 0, 0]
    i=1: merge[1] = nums1[1] = 3 => [1, 3, 0]

    Second loop (copy nums2):
    i=0: merge[0+2] = merge[2] = nums2[0] = 2 => [1, 3, 2]

    Arrays.sort(merge) => [1, 2, 3]
    
    size = 3
    size % 2 == 0? 3 % 2 = 1. No. Odd.
    return merge[3/2] = merge[1] = 2
    Output: 2.00000. Correct.
*/