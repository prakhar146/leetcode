class Solution {
    Map<Integer, Integer> minCoinsReqd = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        if(minCoinsReqd.containsKey(amount)) {
            return minCoinsReqd.get(amount);
        }
        if(amount == 0) {
            return 0;
        }
        if(amount < 0) {
            return -1;
        }
        
        int minCoins = Integer.MAX_VALUE;
        for(int i = 0 ; i < coins.length ; i++) {
            int coinsUsed = coinChange(coins, amount - coins[i]);
            if(coinsUsed >= 0) {
                minCoins = Math.min(minCoins, 1 + coinsUsed);
            }
        }
        minCoins = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
        minCoinsReqd.put(amount, minCoins);
        
        return minCoins;
    }
}