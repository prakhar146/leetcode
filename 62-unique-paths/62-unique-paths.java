class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return getUniquePaths(0, 0, m, n, dp);
    }
    
    int getUniquePaths(int p, int q, int m, int n, int[][] dp) {
        if(p >= m || q >= n) {
            return 0;
        }
        if((p == (m - 1)) && (q == (n - 1))) {
            return 1;
        }
        if(dp[p][q] != -1) {
            return dp[p][q];
        }
        int op1 = getUniquePaths(p + 1, q, m, n, dp);
        int op2 = getUniquePaths(p, q + 1, m, n, dp);
        int paths = op1 + op2;
        dp[p][q] = paths;
        return paths;
    }
}