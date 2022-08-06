class Solution {
    public boolean canJump(int[] nums) {
        int N = nums.length;
        int goodIdx = N - 1;
        for(int i = (N - 2); i > -1; i--) {
            int maxDistance = nums[i] + i;
            // System.out.println("i -> " + i + " maxD -> " + maxDistance + " goodIdx -> " + goodIdx);
            if(maxDistance >= goodIdx) {
                goodIdx = i;
            }
        }
        
        return (goodIdx == 0);
    }
}

/*

    for(i = (N - 1); i > 0; i--) {
        for(int j = i; j < (i + nums[i]); j++) {
            dp[i] = dp[i] || nums[j];
        }
    }

*/