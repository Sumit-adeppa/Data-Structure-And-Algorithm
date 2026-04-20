class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {

        List<int[]> result = new ArrayList<>();

		int p1 = 0, p2 = 0;

		while (p1 < A.length && p2 < B.length) {
			int lo = Math.max(A[p1][0], B[p2][0]); // Latest start
			int hi = Math.min(A[p1][1], B[p2][1]); // Earliest start

			if (lo <= hi) {
				result.add(new int[]{lo, hi}); // valid intersection
			}

			// Advance the pointer whose interval ends first
			// That interval is exhausted — it cannot intersect further
			if (A[p1][1] < B[p2][1]) {
				p1++;
			} else {
				p2++;
			}

		}

		return result.toArray(new int[result.size()][]);

        
    }
}