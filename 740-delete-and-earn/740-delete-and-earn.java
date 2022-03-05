class Solution {
    public int deleteAndEarn(int[] nums) {
        // Arrays.sort(nums);
        Map<Integer, Integer> counter = new HashMap<>();
        
        for(int i: nums) {
            if(counter.containsKey(i)) {
                int currentCnt = counter.get(i);
                currentCnt++;
                counter.put(i, currentCnt);
            } else {
                counter.put(i, 1);
            }
        }
        
        Integer[] sortedAndUniqueNums = counter.keySet().toArray(new Integer[counter.keySet().size()]);
        Arrays.sort(sortedAndUniqueNums);
        Integer[] dp = new Integer[sortedAndUniqueNums.length];
        return solution(sortedAndUniqueNums, counter, 0, dp);
        
    }
    
    int solution(Integer[] sortedAndUniqueNums, Map<Integer, Integer> map, int idx, Integer[] dp) {
        if(idx >= sortedAndUniqueNums.length) {
            return 0;
        }
        if(dp[idx] != null) {
            return dp[idx];
        }
        int currentScore = (map.get(sortedAndUniqueNums[idx]) * sortedAndUniqueNums[idx]);
        // op1
        int op1;
        if((idx + 1) < sortedAndUniqueNums.length && ((sortedAndUniqueNums[idx + 1] - sortedAndUniqueNums[idx]) == 1)) {
            op1 = currentScore + solution(sortedAndUniqueNums, map, idx + 2, dp);
        } else {
            op1 = currentScore + solution(sortedAndUniqueNums, map, idx + 1, dp);
        }
        int op2 = solution(sortedAndUniqueNums, map, idx + 1, dp);
        int ans = Math.max(op1, op2);
        dp[idx] = ans;
        return ans;
    }
}