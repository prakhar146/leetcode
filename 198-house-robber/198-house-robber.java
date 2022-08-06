class Solution {
    public int rob(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        for(int i = 0; i < N; i++) {
            dp[i] = -1;
        }
        return robHouse(nums, 0, dp);
    }
    
    int robHouse(int[] nums, int idx, int[] dp) {
        if(idx >= nums.length) {
            return 0;
        }
        if(dp[idx] > -1) {
            return dp[idx];
        }
        int op1 = nums[idx] + robHouse(nums, idx + 2, dp);
        int op2 = robHouse(nums, idx + 1, dp);
        int ans = Math.max(op1, op2);
        dp[idx] = ans;
        return ans;
    }
}