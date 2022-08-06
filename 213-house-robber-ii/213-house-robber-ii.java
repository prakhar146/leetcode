class Solution {
    // class Pair {
    //     int cash;
    //     boolean include
    // }
    public int rob(int[] nums) {
        int N = nums.length;
        int[][] dp = new int[N][2];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 2; j++) {
                 dp[i][j] = -1;
            }
        }
        int ans = robHouse(nums, 0, dp, false);
        // System.out.println(Arrays.toString(dp));
        return ans;
    }
    
    int robHouse(int[] nums, int idx, int[][] dp, boolean includeFirst) {
        if(idx >= nums.length) {
            return 0;
        }
        if(dp[idx][toInt(includeFirst)] > -1) {
            return dp[idx][toInt(includeFirst)];
        }
        int op1 = -1;
        if(idx == 0) {
            op1 = nums[idx] + robHouse(nums, idx + 2, dp, true);
        } else if(idx < (nums.length - 1) || !includeFirst) {
            op1 = nums[idx] + robHouse(nums, idx + 2, dp, includeFirst);
        }
        // int op1 = nums[idx] + robHouse(nums, idx + 2, dp);
        int op2 = robHouse(nums, idx + 1, dp, includeFirst);
        int ans = Math.max(op1, op2);
        dp[idx][toInt(includeFirst)] = ans;
        return ans;
    }
    
    int toInt(boolean b) {
        return b ? 1 : 0;
    }
}