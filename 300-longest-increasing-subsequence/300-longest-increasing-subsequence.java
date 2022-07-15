class Solution {
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        
        for(int i = 0; i < N; i++) {
            dp[i] = 1;
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(1 + dp[j], dp[i]);   
                }
            }
        }
        // System.out.println("dp -> " + Arrays.toString(dp));
        int ans = 1;
        for(int i: dp) {
            ans = Math.max(ans, i);
        }
        return ans;
    }
}