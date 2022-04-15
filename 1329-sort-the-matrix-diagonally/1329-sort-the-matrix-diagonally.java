class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int row = m - 1;
        int col = 0;
        int[] tmpArr = new int[Math.min(m,n)];
        int tmpIdx = 0;
        
        while(row > -1) {
            int i = row;
            int j = col;

            tmpIdx = 0;
            while(i < m && j < n) {
                tmpArr[tmpIdx] = mat[i][j];
                tmpIdx++;
                
                // System.out.print("[" + i + ", " + j + "]");
                i++;
                j++;
            }
            
            Arrays.sort(tmpArr, 0, tmpIdx);
            i = row;
            j = col;
            tmpIdx = 0;
            while(i < m && j < n) {
                // tmpArr[tmpIdx] = mat[i][j];
                // tmpIdx++;
                mat[i][j] = tmpArr[tmpIdx];
                tmpIdx++;
                // System.out.print("[" + i + ", " + j + "]");
                i++;
                j++;
            }
            
            
            // System.out.println();
            row--;
        }
        
        row = 0;
        col = 1;
        
        while(col < n) {
            int i = row;
            int j = col;
            
            tmpIdx = 0;
            while(i < m && j < n) {
                tmpArr[tmpIdx] = mat[i][j];
                tmpIdx++;
                
                // System.out.print("[" + i + ", " + j + "]");
                i++;
                j++;
            }
            
            Arrays.sort(tmpArr, 0, tmpIdx);
            i = row;
            j = col;
            tmpIdx = 0;
            while(i < m && j < n) {
                // tmpArr[tmpIdx] = mat[i][j];
                // tmpIdx++;
                mat[i][j] = tmpArr[tmpIdx];
                tmpIdx++;
                // System.out.print("[" + i + ", " + j + "]");
                i++;
                j++;
            }
            
            // System.out.println();
            col++;
        }
        
        return mat;
    }
}
/*

2,0
1,0 2,1
0,0 1,1 2,2
*/