class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        
        while(left < right) {
            int mid = (left + right) / 2;
            int midNum = nums[mid];
            int leftNum = nums[left];
            int rightNum = nums[right];
            
            if(midNum < rightNum && midNum < leftNum) {
                right = mid;
                continue;
            }
            if(midNum > rightNum && midNum > leftNum) {
                left = mid + 1;
                continue;
            }
            if(midNum >= leftNum && midNum <= rightNum) {
                right = left;
                continue;
            }
            if(midNum <= leftNum && midNum >= rightNum) {
                left = right;
                continue;
            }
            
        }
        
        int minElement = nums[(left + right) / 2];
        return minElement;
    }
}
/*




*/