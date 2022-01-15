class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] amounts = new int[amount + 1];
        for(int i = 0 ; i < amounts.length; i++) {
            amounts[i] = amount + 1;
        }
        amounts[0] = 0;
        
//         int minCoin = Integer.MAX_VALUE;
//         for(int coin: coins) {
//             if(coin < minCoin) {
//                 minCoin = coin;
//             }
//         }
        
//         amounts[minCoin] = 1;
        
        for(int i = 1; i < amounts.length; i++) {
            for(int coin: coins) {
                    if(i - coin >= 0 && amounts[i - coin] < amount) {
                        amounts[i] = Math.min(amounts[i], amounts[i - coin] + 1);
                    }
                }
        }
        // System.out.println("Array -> " + Arrays.toString(amounts));
        
       return amounts[amount] > amount ? -1 : amounts[amount];
    }
}