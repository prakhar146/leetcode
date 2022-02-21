class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length < 2) {
            return nums[0];
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int currentCnt = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for(int i: nums) {
            if(cntMap.containsKey(i)) {
                currentCnt = cntMap.get(i);
                if(currentCnt == (nums.length / 2)) {
                    return i;
                }
                currentCnt++;
                cntMap.put(i, currentCnt);
            } else {
                 cntMap.put(i, 1);
            }
               
            // min = Math.min(min, i);
            // max = Math.max(max, i);
        }
//         int minBucketRange = min + ((max - min) / 2);
        
//         Integer minBucketNum = null, maxBucketNum = null;
        
//         for(int i: nums) {
             
//         }
        return 0;
    }
}

/*
[2, 3, 3]

0.5 + 2 = 2.5

[1, 2, 3]

1,2 2,3


*/