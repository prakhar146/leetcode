class Solution {
    public int search(int[] nums, int target) {
        int startPt = getStartPt(nums);
        // System.out.println("Starting Pt " + startPt);
        return binarySearch(startPt, nums, target);
    }
    
    int binarySearch(int startIdx, int[] nums, int target) {
        int l = startIdx;
        int e = l + nums.length - 1;
        
        while(l <= e) {
            int mid = (l + e) / 2;
            int midNum = nums[mid % nums.length];
            int lNum = nums[l % nums.length];
            // System.out.println("left " + l + " end " + e + " mid " + mid + " midnum " + midNum);
            // int rNum = nums[e % nums.length];
            // System.out.println("l " + (l % nums.length) + " end " + (e % nums.length) + " mid " + midNum);
            if(midNum == target) {
                return (mid % nums.length);
            }
            if(midNum < target) {
                l = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        
        return -1;
    }
    
    int getStartPt(int[] nums) {
        int s = 0;
        int e = nums.length;
        
        while(s < e) {
            int mid = (s + e) / 2;
            if(nums[mid] > nums[s]) {
                s = mid;
            } else {
                e = mid;
            }
        }
        
        return s + 1;
    }
}
/*
[4, 5, 6, 7, 0, 1, 2] --> 7
 0, 1, 2, 3, 4, 5, 6 ,7
getPivot()
s = 0
e = 7
while(s < e) {
    mid = (0 + 7) / 2 = 3
    if(nums[3] > nums[0]) --> if(7 > 4) --> true
        s = 3
    -----
    mid = (4 + 7) / 2 = 5
    if(nums[5] > nums[4]) --> if(1 > 0) --> true
        s = 6
    -----
    mid = (6 + 7) / 2 = 6
    if(nums[6] > nums[6]) --> if(1 > 0) --> true
        s = 6
}

*/