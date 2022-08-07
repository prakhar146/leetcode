class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int M = text1.length();
        int N = text2.length();
        int[][] dp = new int[M][N];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }
        
        return lcs(text1, text2, 0, 0, dp);
    }
    
    int lcs(String text1, String text2, int idx1, int idx2, int[][] dp) {
        if(idx1 >= text1.length() || idx2 >= text2.length()) {
            return 0;
        }
        if(dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }
        char c1 = text1.charAt(idx1);
        char c2 = text2.charAt(idx2);
        int op1 = -1, op2 = -1, op3 = -1;
        if(c1 == c2) {
            op1 = 1 + lcs(text1, text2, idx1 + 1, idx2 + 1, dp);
        }
        op2 = lcs(text1, text2, idx1 + 1, idx2, dp);
        op3 = lcs(text1, text2, idx1, idx2 + 1, dp);
        int ans = Math.max(op1, Math.max(op2, op3));
        dp[idx1][idx2] = ans;
        return ans;
    }
}