class Solution {
    public int lengthOfLIS(int[] nums) {
                int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int maxNumber = -1;
        for (int i: dp) {
            maxNumber = Math.max(maxNumber, i);
        }
        return maxNumber;
    }
}

/*

maxSubsequence(i) = 1 + max(maxSubsequence(j), maxSubsequence(j + 1)...);

where j < i;
    nums[j] < nums[i];



*/