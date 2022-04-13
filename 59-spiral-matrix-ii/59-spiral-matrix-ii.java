class Solution {
    public int[][] generateMatrix(int n) {
        int rowStart = 0, colStart = 0;
        int rowEnd = n, colEnd = n;
        int cnt = 1;
        
        int[][] matrix = new int[n][n];
        while(rowStart < rowEnd) {
            for(int i = colStart; i < colEnd; i++) {
                matrix[rowStart][i] = cnt;
                cnt++;
            }
            rowStart++;
            for(int i = rowStart; i < rowEnd; i++) {
                matrix[i][colEnd - 1] = cnt;
                cnt++;
            }
            colEnd--;
            for(int i = (colEnd - 1); i >= colStart; i--) {
                matrix[rowEnd - 1][i] = cnt;
                cnt++;
            }
            rowEnd--;
            for(int i = (rowEnd - 1); i >= rowStart; i--) {
                matrix[i][colStart] = cnt;
                cnt++;
            }
            colStart++;
        }
        return matrix;
    }
}