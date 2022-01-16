class Solution {
    public int mincostTickets(int[] days, int[] costs) {
                int[] dp = new int[days.length];
        for (int i = 0; i < days.length; i++) {
            dp[i] = costs[2] * days.length;
        }
        int min = costs[0];
        for (int i: costs) {
            min = Math.min(min, i);
        }
        dp[0] = min;
        for (int i = 1 ; i < days.length ; i++) {
            int c1 = costs[0] + dp[i - 1];
            int d7 = 0;
            int c2 = costs[1];
            while (d7 < i && ((days[i] - days[d7]) >= 7)) {
                c2 = costs[1] + dp[d7];
                d7++;
            }
            int d30 = 0;
            int c3 = costs[2];
            while (d30 < i && ((days[i] - days[d30]) >= 30)) {
                c3 = costs[2] + dp[d30];
                d30++;
                
            }
            dp[i] = Math.min(c1, Math.min(c2, c3));
        }

        return dp[days.length - 1];
    }
}