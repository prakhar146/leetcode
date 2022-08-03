class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int M = matrix.length;
        int N = matrix[0].length;
        
        int low = matrix[0][0];
        int high = matrix[M - 1][N - 1];
        
        while(low < high) {
            int mid = low + ((high - low) / 2);
            int count = getUpper(matrix, mid);
            if(count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
            // System.out.println("mid " + mid + " count -> " + count + " left -> " + low + " right -> " + high);
        }
        
        return low;
    }
    
    int getUpper(int[][] matrix, int mid) {
        int row = matrix.length - 1;
        int col = 0;
        int count = 0;
        int num = matrix[row][col];
        while(row > -1 && col < matrix[0].length) {
            num = matrix[row][col];
            if(num <= mid) {
                col++;
                count += row + 1;
            } else {
                row--;
            }
        }
        return count;
    }
}