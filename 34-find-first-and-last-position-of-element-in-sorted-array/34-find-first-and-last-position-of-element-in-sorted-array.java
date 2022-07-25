class Solution {
    enum PositionType {
        START, END
    }
    
    public int[] searchRange(int[] nums, int target) {
        int start = doBinarySearch(nums, target, PositionType.START);
        int end = doBinarySearch(nums, target, PositionType.END);
        return new int[]{start, end};
    }
    
    int doBinarySearch(int[] nums, int target, PositionType positionType) {
        int N = nums.length;
        int left = 0;
        int right = N;
        int ans = -1;
        
        while(left < right) {
            int mid = (left + right) / 2;
            int midNum = nums[mid];
            if(midNum > target) {
                right = mid;
            } else if (midNum < target) {
                left = mid + 1;
            } else {
                ans = mid;
                if(positionType == PositionType.START) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        
        return ans;
    }
}