class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = getRowNum(matrix, target);
        // System.out.println("rowNum " + row);
        return findNum(matrix, row, target);
    }
    
    boolean findNum(int[][] matrix, int row, int target) {
        int s = 0;
        int e = matrix[0].length;
        
        while(s < e) {
            int mid = (s + e) / 2;
            int midValue = matrix[row][mid];
            if(midValue == target) {
                return true;
            }
            if(midValue > target) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        
        return false;
    }
    
    int getRowNum(int[][] matrix, int target) {
        int s = 0;
        int e = matrix.length;
        int row = 0;
        
        while(s < e) {
            int mid = (s + e) / 2;
            int midNum = matrix[mid][0];
            if(target >= midNum) {
                row = mid;
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        
        return row;
    }
}