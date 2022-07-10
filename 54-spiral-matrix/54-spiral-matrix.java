class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        
        int top = 0;
        int bottom = N;
        int left = 0;
        int right = M;
        
        List<Integer> spiral = new ArrayList<>();
        
        while(top < bottom && left < right) {
            for(int i = left; i < right; i++) {
                spiral.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i < bottom; i++) {
                spiral.add(matrix[i][right - 1]);
            }
            right--;
            if(top >= bottom || left >= right) {
                break;
            }
            for(int i = (right - 1); i >= left; i--) {
                spiral.add(matrix[bottom - 1][i]);
            }
            bottom--;
            for(int i = (bottom - 1); i >= top; i--) {
                spiral.add(matrix[i][left]);
            }
            left++;
        }
        
        return spiral;
    }
}