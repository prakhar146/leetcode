class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Integer[] startPosition = new Integer[] {0, 0};

        Queue<Integer[]> nodesToVisit = new LinkedList<>();
        if (grid[startPosition[0]][startPosition[1]] == 1) {
            return -1;
        }
        nodesToVisit.offer(startPosition);

        int[][] possibleMoves = new int[][] {
                {0, -1},
                {-1, -1},
                {-1, 0},
                {-1, 1},
                {0, 1},
                {1, 1},
                {1, 0},
                {1, -1}
        };

        int level = 1;
        while (!nodesToVisit.isEmpty()) {
            int size = nodesToVisit.size();
            while (size > 0) {
                Integer[] currentPosition = nodesToVisit.poll();
                Integer[] pos = new Integer[] {currentPosition[0], currentPosition[1]};

                if (currentPosition[0] == (grid.length - 1) && currentPosition[1] == (grid[0].length - 1)) {
                    return level;
                }

                for (int[] moves: possibleMoves) {
                    pos[0] = currentPosition[0] + moves[0];
                    pos[1] = currentPosition[1] + moves[1];
                    visitNode(grid, nodesToVisit, pos);
                }
                size--;
            }
            level++;
        }

        return -1;
    }
    
    
    void visitNode(int[][] grid, Queue<Integer[]> q, Integer[] pos) {
        if (isValid(grid, pos)) {
            grid[pos[0]][pos[1]] = 1;
            q.offer(new Integer[] {pos[0], pos[1]});
        }
    }
    
    boolean isValid(int[][] grid, Integer[] pos) {
        int x = pos[1];
        int y = pos[0];

        if (x < 0 || y < 0) {
            return false;
        }
        if (x >= grid[0].length || y >= grid.length) {
            return false;
        }
        return grid[y][x] != 1;
    }
}