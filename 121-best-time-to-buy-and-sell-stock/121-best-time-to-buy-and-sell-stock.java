class Solution {
    public int maxProfit(int[] prices) {
        int buyingPriceIdx = 0, sellingPriceIdx = 0, maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            buyingPriceIdx = prices[i] < prices[buyingPriceIdx] ? i : buyingPriceIdx;
            sellingPriceIdx = buyingPriceIdx > sellingPriceIdx ? buyingPriceIdx : sellingPriceIdx;
            sellingPriceIdx = prices[i] > prices[sellingPriceIdx] ? i : sellingPriceIdx;
            maxProfit = Math.max(maxProfit, prices[sellingPriceIdx] - prices[buyingPriceIdx]);
        }
        return maxProfit;
    }
}