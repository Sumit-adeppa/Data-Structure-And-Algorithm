class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        // This will store the final Pascal's Triangle
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        // Edge Case 1:
        // If numRows is 0, return empty result
        if (numRows == 0) return result;
        
        // First row of Pascal's Triangle is always [1]
        List<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        
        // Add first row to result
        result.add(firstRow);
        
        // Edge Case 2:
        // If only one row is required, return result
        if (numRows == 1) return result;
        
        // Loop to generate remaining rows (starting from row index 1)
        for (int i = 1; i < numRows; i++) {
            
            // Get the previous row to build current row
            List<Integer> prevRow = result.get(i - 1);
            
            // Create a new row
            ArrayList<Integer> row = new ArrayList<Integer>();
            
            // First element of every row is always 1
            row.add(1);
            
            // Fill the middle elements
            // Each element = sum of two elements above it
            for (int j = 0; j < i - 1; j++) {
                row.add(prevRow.get(j) + prevRow.get(j + 1));
            }
            
            // Last element of every row is always 1
            row.add(1);
            
            // Add current row to result
            result.add(row);
        }
        
        // Return the complete Pascal's Triangle
        return result;
    }
}