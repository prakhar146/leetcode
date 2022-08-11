class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        for(int i = 0; i <= target; i++) {
            dp[i] = -1;
        }
        return findPossibleComb(nums, target, dp);
    }

    int findPossibleComb(int[] nums, int target, int[] dp) {
        if(target == 0) {
            return 1;
        }
        if(target < 0) {
            return 0;
        }
        if(dp[target] != -1) {
            return dp[target];
        }
        int totalWays = 0;
        for(int i: nums) {
            totalWays += findPossibleComb(nums, target - i, dp);
        }
        dp[target] = totalWays;
        return totalWays;
    }
}