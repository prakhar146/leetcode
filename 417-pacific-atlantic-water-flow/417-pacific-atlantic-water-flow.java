class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int M = heights.length;
        int N = heights[0].length;
        
        Boolean[][] pacific = new Boolean[M][N];
        Boolean[][] atlantic = new Boolean[M][N];
        
        for(int i = 0; i < M; i++) {
            pacific[i][0] = true;
            atlantic[i][N - 1] = true;
        }
        
        for(int i = 0; i < N; i++) {
            pacific[0][i] = true;
            atlantic[M - 1][i] = true;
        }
        // System.out.println("Pacific");
        canReach(heights, M, N, pacific);
        // System.out.println("Atlantic");
        canReach(heights, M, N, atlantic);
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(pacific[i][j] != null && atlantic[i][j] != null) {
                    ans.add(Arrays.asList(new Integer[]{i, j}));
                }
            }
        }
        return ans;
    }
    
    void canReach(int[][] heights, int M, int N, Boolean[][] visited) {
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(visited[i][j] != null) {
                    markVisited(heights, i, j, M, N, visited);
                }
            }
        }
        
        // for(Boolean[] v: visited) {
        //     System.out.println(Arrays.toString(v));
        // }
    }
    
    void markVisited(int[][] heights, int row, int col, int M, int N, Boolean[][] visited) {
        if(row < 0 || col < 0) {
            return;
        }
        if(row >= M || col >= N) {
            return;
        }
        if(visited[row][col] == null) {
            return;
        }
        // left
        if((col - 1) > -1 && heights[row][col] <= heights[row][col - 1] && visited[row][col - 1] == null) {
            visited[row][col - 1] = true;
            markVisited(heights, row, col - 1, M, N, visited);
        }
        // right
        if((col + 1) < N && heights[row][col] <= heights[row][col + 1] && visited[row][col + 1] == null) {
            visited[row][col + 1] = true;
            markVisited(heights, row, col + 1, M, N, visited);
        }
        // top
        if((row - 1) > -1 && heights[row][col] <= heights[row - 1][col] && visited[row - 1][col] == null) {
            visited[row - 1][col] = true;
            markVisited(heights, row - 1, col, M, N, visited);
        }
        // bottom
        if((row + 1) < M && heights[row][col] <= heights[row + 1][col] && visited[row + 1][col] == null) {
            visited[row + 1][col] = true;
            markVisited(heights, row + 1, col, M, N, visited);
        }
        return;
    }
    
    Boolean canReachSea(int[][] heights, int row, int col, int M, int N, Boolean[][] visited) {
        if(row < 0 || col < 0) {
            return false;
        }
        if(row >= M || col >= N) {
            return false;
        }
        if(visited[row][col] != null) {
            return visited[row][col];
        }
        Boolean left = false, top = false, right = false, bottom = false;
        visited[row][col] = false;
        if((col - 1 > -1) && heights[row][col] >= heights[row][col - 1]) {
            left = canReachSea(heights, row, col - 1, M, N, visited);
            visited[row][col] = visited[row][col] || left;
        }
        if(((col + 1) < N) && heights[row][col] >= heights[row][col + 1]) {
            right = canReachSea(heights, row, col + 1, M, N, visited);
            visited[row][col] = visited[row][col] || right;
        }
        if(((row - 1) > -1) && heights[row][col] >= heights[row - 1][col]) {
            top = canReachSea(heights, row - 1, col, M, N, visited);
            visited[row][col] = visited[row][col] || top;
        }
        if(((row + 1) < M) && heights[row][col] >= heights[row + 1][col]) {
            bottom = canReachSea(heights, row + 1, col, M, N, visited);
            visited[row][col] = visited[row][col] || bottom;
        }
        
        visited[row][col] = (left || right || bottom || top);
        return visited[row][col];
    }
}