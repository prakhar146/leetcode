class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums) {
            set.add(i);
        }
        int N = nums.length;
        int maxCnt = 0;
        for(int i = 0; i < N; i++) {
            int currentNum = nums[i];
            if(set.contains(nums[i] - 1)) {
                continue;
            } else {
                int currentCnt = 0;
                while(set.contains(currentNum)) {
                    currentNum++;
                    currentCnt++;
                }
                maxCnt = Math.max(maxCnt, currentCnt);
            }
        }
        
        return maxCnt;
    }
}