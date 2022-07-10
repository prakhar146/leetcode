class Solution {
    public int coinChange(int[] coins, int amount) {
        // Arrays.sort(coins, Collections.reverseOrder());
        return getCoins(coins, amount, new Integer[amount + 1]);
    }
    
    int getCoins(int[] coins, int amount, Integer[] dp) {
        if(amount < 0) {
            return -1;
        }
        if(amount == 0) {
            return 0;
        }
        if(dp[amount] != null) {
            return dp[amount];
        }
        int N = coins.length;
        int ans = -1;
        for(int i = 0; i < N; i++) {
            int tmpAmt = amount - coins[i];
            int op = getCoins(coins, tmpAmt, dp);
            if(op > -1) {
                if(ans > -1) {
                    ans = Math.min(ans, 1 + op);   
                } else {
                    ans = 1 + op;
                }
            }
        }
        dp[amount] = ans;
        return ans;
    }
}