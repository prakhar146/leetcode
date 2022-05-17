class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] exists = new int[board.length][board[0].length];
        int m = board.length, n = board[0].length;
        boolean ans = false;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                ans = ans || doesExists(board, word, 0, i, j, exists);
                if(ans) {
                    return true;
                }
            }
        }
        return false;
        // return doesExists(board, word, 0, 0, 0, exists);
        
        // return doesExistStack(board, word, exists);
    }
    
    boolean doesExists(char[][] board, String word, int wordPtr, int rowPtr, int colPtr, int[][] exists) {
        if(wordPtr == word.length()) {
            return true;
        }
        if((rowPtr == board.length) || (colPtr == board[0].length) || (rowPtr < 0) || (colPtr < 0)) {
            return false;
        }
        if(word.charAt(wordPtr) != board[rowPtr][colPtr]) {
            return false;
        }
        if(exists[rowPtr][colPtr] == 1) {
            return true;
        }
        if(exists[rowPtr][colPtr] == -1) {
            return false;
        }
        boolean op1 = false, op2 = false, op3 = false, op4 = false, op5 = false, op6 = false, op7 = false, op8 = false;
        
        // if(word.charAt(wordPtr) == board[rowPtr][colPtr]) {
        //     op1 = doesExists(board, word, wordPtr + 1, rowPtr + 1, colPtr, exists);
        //     op2 = doesExists(board, word, wordPtr + 1, rowPtr, colPtr + 1, exists);
        //     op3 = doesExists(board, word, wordPtr + 1, rowPtr - 1, colPtr, exists);
        //     op4 = doesExists(board, word, wordPtr + 1, rowPtr, colPtr - 1, exists);   
        // }
        exists[rowPtr][colPtr] = -1;
        op1 = doesExists(board, word, wordPtr + 1, rowPtr + 1, colPtr, exists);
        op2 = doesExists(board, word, wordPtr + 1, rowPtr, colPtr + 1, exists);
        op3 = doesExists(board, word, wordPtr + 1, rowPtr - 1, colPtr, exists);
        op4 = doesExists(board, word, wordPtr + 1, rowPtr, colPtr - 1, exists);   
        // op5 = doesExists(board, word, wordPtr, rowPtr + 1, colPtr, exists);
        // op6 = doesExists(board, word, wordPtr, rowPtr, colPtr + 1, exists);
        // op7 = doesExists(board, word, wordPtr, rowPtr - 1, colPtr, exists);
        // op8 = doesExists(board, word, wordPtr, rowPtr, colPtr - 1, exists);
        
        boolean ans = (op1 || op2 || op3 || op4 || op5 || op6 || op7 || op8);
        exists[rowPtr][colPtr] = 0;
        return ans;
    }
}

/*



*/