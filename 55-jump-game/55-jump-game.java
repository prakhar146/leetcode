class Solution {
    public boolean canJump(int[] nums) {
        int N = nums.length;
        boolean[] dp = new boolean[N];
        dp[N - 1] = true;
        for(int i = (N - 2); i > -1; i--) {
            for(int j = i; j <= Math.min(i + nums[i], N - 1); j++) {
                dp[i] = dp[i] || dp[j];
                if(dp[i]) {
                    break;
                }
            }
        }
        
        return dp[0];
    }
}

/*

    for(i = (N - 1); i > 0; i--) {
        for(int j = i; j < (i + nums[i]); j++) {
            dp[i] = dp[i] || nums[j];
        }
    }

*/