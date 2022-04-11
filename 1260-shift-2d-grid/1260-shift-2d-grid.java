class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rSize = grid[0].length;
        int cSize = grid.length;
        List<List<Integer>> kGrid = new ArrayList<>(cSize);
        for(int i = 0; i < cSize; i++) {
            List<Integer> kRow = new ArrayList<>(rSize);
            for(int j = 0; j < rSize; j++) {
                kRow.add(-1);
            }
            // System.out.println(Arrays.toString(kRow.toArray()));
            kGrid.add(kRow);
        }
        // System.out.println("row size " + rSize);
        // System.out.println("col size " + cSize);
        
        for(int i = 0; i < cSize; i++) {
            for(int j = 0; j < rSize; j++) {
                int col = (j + (k % rSize));
                int row = (i + (k / rSize));
                int newRow = (i + (k / rSize) + (col / rSize)) % cSize;
                int newCol = col % rSize;
                // // int newCol = (j + (k % cSize)) % cSize;
                List<Integer> kRow = kGrid.get(newRow);
                kRow.set(newCol, grid[i][j]);
                kGrid.set(newRow, kRow);
            }
        }
        return kGrid;
    }
}

/*

int rowSize = grid[0].length

row - k / rowSize
column - k % rowSize

k = 1
row = 0
column = 1

k = 2
row = 0
column = 2

k = 3
row = 1
column = 0

---------

 2,2
 
k = 4

row =  2 + 4 / rowSize
    = 2 + 1
    = 3
    column = 2 + 4 % rowSize
        = 2 + 1
        = 3




*/