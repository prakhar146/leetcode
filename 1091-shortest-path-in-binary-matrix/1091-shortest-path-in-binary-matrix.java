class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0) {
            return -1;
        }
        return doBFS(grid);
    }
    
    int doBFS(int[][] matrix) {
        int distance = 1;

        int M = matrix.length;
        int N = matrix[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        matrix[0][0] = 5;
        boolean canReach = false;

        int[][] moves = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, 
                                        {-1, -1}, {1, -1}, {-1, 1}, {1, 1}};

        // int[][] moves = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


        while(!q.isEmpty()) {
            int numOfPoints = q.size();

            for(int i = 0; i < numOfPoints; i++) {
                int[] currentLocation = q.poll();
                int currentX = currentLocation[0];
                int currentY = currentLocation[1];
                if(currentX == (M - 1) && currentY == (N - 1)) {
                        canReach = true;
                        return distance;
                }
                // matrix[newX][newY] = 5;
                // if(matrix[currentLocation[0]][currentLocation[1]] == 9) {
                //     canReach = true;
                //     return distance;
                // }
                

                for(int[] move: moves) {
                    int newX = currentX + move[0];
                    int newY = currentY + move[1];
                    int[] newPos = new int[]{newX, newY};
                    if(isValid(matrix, newPos)) {
                        matrix[newX][newY] = 5;
                        q.offer(newPos);
                    }
                }
            }
            distance++;
        }

        if(!canReach) {
            return -1;
        }
        return distance;
    }

    boolean isValid(int[][] matrix, int[] pos) {
        int x = pos[0];
        int y = pos[1];
        if(x < 0 || y < 0) {
            return false;
        }
        if(x >= matrix.length || y >= (matrix[0].length)) {
            return false;
        }
        if(matrix[x][y] == 0 || matrix[x][y] == 9) {
            return true;
        }
        return false;
    }
}