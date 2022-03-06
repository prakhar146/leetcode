class Solution {
    long c = 7 + (int)Math.pow(10, 9);
    class UsefulMethods {
        public long factorial(int number) {
            long result = 1;

            for (int factor = 2; factor <= number; factor++) {
                result = (long)((result % c) * (factor % c)) % c;
            }

            return result;
        }
    }
    UsefulMethods um = new UsefulMethods();
    
    public int countOrders(int n) {
        long[][] dp = new long[n + 1][n + 1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;
        dp[1][1] = 1;
        
        return (int)countValidOrders(n, n, dp);
    }
    
    long countValidOrders(int p, int d, long[][] dp) {
        // Base cases
        if(p == 1 && d == 1) {
            dp[p][d] = 1;
            return 1;
        }
        if(p < 1) {
            dp[p][d] = um.factorial(d);
            return dp[p][d];
        }
        if(dp[p][d] != -1) {
            return dp[p][d];
        }
        // Rec
        long op1 = 0, op2 = 0, op3 = 0;
        op1 = ((p % c) * (countValidOrders(p - 1, d, dp) % c)) % c;
        if(p < d) {
            int diff = d - p;
            op2 = ((diff % c) * (countValidOrders(p, d - 1, dp) % c)) % c;
        }
        
        dp[p][d] = ((op1 % c) + (op2 % c)) % c;
        return dp[p][d];
        
    }
}