class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        if(m == 1 && n == 1) {
            return 0;
        }
        int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] visited = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        
        Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                return (a1[2] - a2[2]);
            }
        });
        pq.add(new int[]{0,0,0});
        
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int currentEff = top[2];
            for(int[] move: moves) {
                int r = top[0] + move[0];
                int c = top[1] + move[1];
                if((r > -1 && c > -1) && (r < m && c < n)) {
                    int eff = Math.max(currentEff, Math.abs(heights[top[0]][top[1]] - heights[r][c]));
                    if(eff < visited[r][c]) {
                        visited[r][c] = eff;
                        pq.add(new int[]{r, c, eff});
                    }
                }
            }
            
        }
        
        return visited[m - 1][n - 1];
    }
    
    // int minEffortPath(int[][] paths, int i, int j, int[][] visited) {
    //     if(i == paths.length && j == paths[0].length) {
    //         return 0;
    //     }
    //     if(i > paths.length || j > paths[0].length || i < 0 || j < 0) {
    //         return Integer.MAX_VALUE;
    //     }
    //     int op1, op2, op3, op4 = Integer.MAX_VALUE;
    //     int vDist = Integer.MAX_VALUE;
    //     if((i - 1) > -1) {
    //         vDist = Math.abs(paths[i - 1][j] - paths[i][j]);
    //         if(vDist < )
    //         op1 = Math.max(Math.abs(paths[i - 1][j] - paths[i][j]), minEffortPath(paths, i - 1, j, visited));
    //     }
    //     if((i + 1) < paths.length) {
    //         op2 = Math.max(Math.abs(paths[i + 1][j] - paths[i][j]), minEffortPath(paths, i + 1, j, visited));
    //     }
    //     if((j + 1) < paths[0].length) {
    //         op3 = Math.max(Math.abs(paths[i][j + 1] - paths[i][j]), minEffortPath(paths, i, j + 1, visited));
    //     }
    //     if((j - 1) > -1) {
    //         op4 = Math.max(Math.abs(paths[i][j - 1] - paths[i][j]), minEffortPath(paths, i, j - 1, visited));
    //     }
    //     int ans = Math.min(op1, Math.min(op2, Math.min(op3, op4)));
    //     visited[i][j] = ans;
    //     return ans;
    // }
}