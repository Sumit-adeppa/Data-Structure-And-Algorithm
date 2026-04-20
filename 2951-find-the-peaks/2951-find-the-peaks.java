class Solution {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> arr = new ArrayList<>();

        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i - 1] < mountain[i] && mountain[i] > mountain[i + 1]) {
                arr.add(i);
            }
        }

        return arr;
    }
}