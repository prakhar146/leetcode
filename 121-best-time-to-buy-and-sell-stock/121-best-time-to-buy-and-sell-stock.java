class Solution {
    public int maxProfit(int[] prices) {
        // 7 1 5 3 6 4
        // 
        int lsf = Integer.MAX_VALUE;
        int currentProfit;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            lsf = Math.min(lsf, prices[i]);
            currentProfit = prices[i] - lsf;
            maxProfit = Math.max(currentProfit, maxProfit);
        }
        return maxProfit;
    }
}


// 7 1 5 3 6 4
/*
7 - 7 = 0
1 - 1 = 0
1 - 5 = 4
1 - 3 = 2
1 - 6 = 5
1- 4 = 3



*/