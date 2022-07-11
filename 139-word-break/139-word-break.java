class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int N = s.length();
        Map<String, Boolean> map = new HashMap<>();
        for(String w: wordDict) {
            map.put(w, true);
        }
        int[][] dp = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                String tmp = s.substring(i, j + 1);
                if(map.containsKey(tmp)) {
                    dp[i][j] = 1;
                }
            }
        }
        
        Boolean[][] dp2 = new Boolean[N][N];
        
        return canBreak(dp, 0, 0, dp2);
    }
    
    boolean canBreak(int[][] dp, int row, int col, Boolean[][] dp2) {
        int N = dp.length;
        if(row == N) {
            return true;
        }
        if(dp2[row][col] != null) {
            return dp2[row][col];
        }
        
        boolean ans = false;
        boolean op = false;
        for(int i = col; i < N; i++) {
            op = false;
            if(dp[row][i] == 1) {
                int newRow = i + 1;
                int newCol = newRow;
                op = canBreak(dp, newRow, newCol, dp2);
            }
            ans = ans || op;
        }
        dp2[row][col] = ans;
        return ans;
    }
}

/*
leetcode




*/