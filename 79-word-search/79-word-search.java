class Solution {
    public boolean exist(char[][] board, String word) {
        List<int[]> possibleStartingPoints = new ArrayList<>();
        char c = word.charAt(0);
        
        int M = board.length;
        int N = board[0].length;
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == c) {
                    possibleStartingPoints.add(new int[] {i, j});
                }
            }
        }
        
        boolean wordFound = false;
        for(int i = 0; i < possibleStartingPoints.size(); i++) {
            boolean[][] visited = new boolean[M][N];
            int[] startPt = possibleStartingPoints.get(i);
            wordFound = wordFound || doDFS(board, startPt[0], startPt[1], word, 0, visited);
            if(wordFound) {
                return wordFound;
            }
        }
        
        return wordFound;
    }
    
    boolean doDFS(char[][] board, int x, int y, String dest, int ptr, boolean[][] visited) {
        if(ptr == dest.length()) {
            return true;
        }
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }
        if(board[x][y] != dest.charAt(ptr)) {
            return false;
        }
        if(visited[x][y]) {
            return false;
        }
        
        visited[x][y] = true;
        boolean op1, op2, op3, op4;
        
        op1 = doDFS(board, x - 1, y, dest, ptr + 1, visited);
        op2 = doDFS(board, x + 1, y, dest, ptr + 1, visited);
        op3 = doDFS(board, x, y - 1, dest, ptr + 1, visited);
        op4 = doDFS(board, x, y + 1, dest, ptr + 1, visited);
        
        visited[x][y] = false;
        boolean ans = op1 || op2 || op3 || op4;
        // System.out.println("ptr " + ptr + " ans " + ans);
        return ans;
    }
}