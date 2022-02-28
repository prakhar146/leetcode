class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> rangeList = new ArrayList();
        if(nums.length < 1) {
            return rangeList;
        }
        
        String currentRange = "";
        
        int leftPtr = 0;
        int rightPtr = 1;
        String rangeToAdd = "";
        
        while(rightPtr < nums.length) {
            if((nums[rightPtr] - nums[rightPtr - 1]) != 1) {
                if(nums[leftPtr] == nums[rightPtr - 1]) {
                    rangeToAdd = String.valueOf(nums[leftPtr]);
                } else {
                   rangeToAdd = String.valueOf(nums[leftPtr]) + "->" + String.valueOf(nums[rightPtr - 1]);
                }
                rangeList.add(rangeToAdd);
                leftPtr = rightPtr;
                rightPtr++;
            } else {
                rightPtr++;
            }
        }
        
        if(nums[leftPtr] == nums[rightPtr - 1]) {
            rangeToAdd = String.valueOf(nums[leftPtr]);
        } else {
           rangeToAdd = String.valueOf(nums[leftPtr]) + "->" + String.valueOf(nums[rightPtr - 1]);
        }
        rangeList.add(rangeToAdd);
        
        
        return rangeList;
    }
}