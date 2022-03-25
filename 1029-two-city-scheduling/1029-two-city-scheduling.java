class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int[][] dp = new int[costs.length / 2][costs.length / 2];
        return minCost(costs, 0, 0, 0, dp);
    }
    
    int minCost(int[][] costs, int idx, int cityA, int cityB, int[][] dp) {
        if(cityA >= (costs.length / 2)) {
            return findCost(costs, idx, 1);
        }
        if(cityB >= (costs.length / 2)) {
            return findCost(costs, idx, 0);
        }
        if(dp[cityA][cityB] > 0) {
            return dp[cityA][cityB];
        }
        int op1 = costs[idx][0] + minCost(costs, idx + 1, cityA + 1, cityB, dp);
        int op2 = costs[idx][1] + minCost(costs, idx + 1, cityA, cityB + 1, dp);
        
        int ans = Math.min(op1, op2);
        dp[cityA][cityB] = ans;
        return ans;
    }
    
    int findCost(int[][] costs, int idx, int city) {
        int sum = 0;
        while(idx < costs.length) {
            sum += costs[idx][city];
            idx++;
        }
        return sum;
    }
}