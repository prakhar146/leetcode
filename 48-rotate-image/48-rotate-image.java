class Solution {
    public void rotate(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        
        int row = 0;
        int col = 0;
        while(row < ((M + 1) / 2)) {
            col = row;
            while(col < ((N - 1) - row)) {
                int nextRow = col;
                int nextCol = (N - 1) - row;
                rotate(matrix, row, col, nextRow, nextCol, matrix[row][col]);
                col++;
            }
            row++;
        }
        return;
    }
    
    void rotate(int[][] matrix, int startRow, int startCol, int nextRow, int nextCol, int numToPlace) {
        int nextNumToPlace = matrix[nextRow][nextCol];
        matrix[nextRow][nextCol] = numToPlace;
        if(nextRow == startRow && nextCol == startCol) {
            return;
        }
        int tmp = nextRow;
        nextRow = nextCol;
        nextCol = (matrix[0].length - 1) - tmp;
        rotate(matrix, startRow, startCol, nextRow, nextCol, nextNumToPlace);
    }
    
    void printMatrix(int[][] matrix) {
        for(int arr[]: matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }
}