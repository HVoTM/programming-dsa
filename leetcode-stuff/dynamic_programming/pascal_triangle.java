/**
 * Pascal's Triangle
 * 
 * Topic: Dynamic Programming
 * 
 * Reference: https://leetcode.com/problems/pascals-triangle/description/?envType=problem-list-v2&envId=dynamic-programming
 */
class PascalTriangle {
    // Time O(n^2)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        // Base case:
        Integer[] row1 = {1};
        Integer[] row2 = {1, 1};

        if (numRows < 1) {
            return result;
        } else if (numRows == 1) {
            result.add(Arrays.asList(row1));
            return result;
        } else if (numRows == 2) {
            result.add(Arrays.asList(row1));
            result.add(Arrays.asList(row2));
            return result;
        } else {
            result.add(Arrays.asList(row1));
            result.add(Arrays.asList(row2));
            // iterate
            for (int i = 2; i < numRows; i++){
                // instantiate a subarray
                List<Integer> subarray = new ArrayList<>();
                subarray.add(1);
                for (int j = 0; j < (i-1); j++) {
                    subarray.add((result.get(i-1).get(j) + result.get(i-1).get(j+1)));
                }
                subarray.add(1);
                result.add(subarray);
            }

            return result;
        }
        // Lambda operation to printou the number
        // result.forEach(num -> System.out.println(num));
    }

    public List<List<Integer>> generateSimpler(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);                                   // first element
            for (int j = 1; j < i; j++) {                 // middle elements
                List<Integer> prev = result.get(i - 1);
                row.add(prev.get(j - 1) + prev.get(j));
            }
            if (i > 0) {
                row.add(1);                               // last element
            }
            result.add(row);
        }
        return result;
    }
}