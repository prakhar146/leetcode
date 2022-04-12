class Solution {
    private int[][] moves = new int[][] {
        {-1, -1},
        {-1, 0},
        {-1, 1},
        {0, -1},
        {0, 1},
        {1, -1},
        {1, 0},
        {1, 1}
    };
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int s = getStatus(board, m, n, i, j);
                board[i][j] = s;
            }
        }
        decodeBoard(board, m, n);
    }
    
    int getStatus(int[][] board, int m, int n, int x, int y) {
        int liveCnt = 0;
        for(int[] move: moves) {
            int xPos = x + move[0];
            int yPos = y + move[1];
            if((xPos > -1 && yPos > -1) && (xPos < m && yPos < n)) {
                int cell = board[xPos][yPos];
                if(cell > 0) {
                   liveCnt++; 
                }
            }
        }
        
        if(board[x][y] == 0) {
            if(liveCnt == 3) {
                // dead to alive
                return -1;
            } else {
                // dead to dead
                return 0;
            }
        } else {
            if(liveCnt < 2 || liveCnt > 3) {
                // live to dead
                return 2;
            } else {
                // alive to alive
                return 1;
            }
        }
    }
    
    void decodeBoard(int[][] board, int m, int n) {
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int decoded = Math.abs(board[i][j] % 2);
                board[i][j] = decoded;
            }
        }
    }
}
/*
LIVE to LIVE -> 1
DEAD to DEAD -> 0
LIVE to DEAD -> 2
DEAD to LIVE -> -1

*/