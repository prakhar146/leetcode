class Solution {
    public int lengthOfLIS(int[] nums) {
        // int N = nums.length;
        // int[] dp = new int[N];
        // for(int i = 0; i < N; i++) {
        //     dp[i] = 1;
        // }
        // dp[N - 1] = 1;
        // for(int i = (N - 2); i > -1; i--) {
        //     for(int j = (i + 1); j < N; j++) {
        //         int ans = -1;
        //         if(nums[j] > nums[i]) {
        //             ans = 1 + dp[j];
        //         }
        //         dp[i] = Math.max(ans, dp[i]);
        //     }
        // }
        
        // System.out.println(Arrays.toString(dp));
        // return findMax(dp);
        return tryRec(nums);
    }
    
    int tryRec(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        for(int i = 0; i < N; i++) {
            dp[i] = -1;
        }
        // int ans = findLIS(nums, 0, dp);
        for(int i = 0; i < N; i++) {
            if(dp[i] == -1) {
                findLIS(nums, i, dp);
            }
        }
        // System.out.println(Arrays.toString(dp));
        return findMax(dp);
    }
    
    int findLIS(int[] nums, int idx, int[] dp) {
        if(idx >= nums.length) {
            return 0;
        }
        if(dp[idx] != -1) {
            return dp[idx];
        }
        int max = 1;
        for(int i = (idx + 1); i < nums.length; i++) {
            if(nums[i] > nums[idx]) {
                max = Math.max(max, 1 + findLIS(nums, i, dp));
            }
        }
        dp[idx] = max;
        return max;
    }
    
    int findMax(int[] arr) {
        int max = -1;
        for(int i: arr) {
            max = Math.max(i, max);
        }
        return max;
    }
}