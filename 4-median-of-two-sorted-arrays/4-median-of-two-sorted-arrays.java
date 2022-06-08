class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mergedLength = nums1.length + nums2.length;
        int desCnt = mergedLength / 2;
        int median1, median2;
        median1 = getMedian(nums1, nums2, desCnt);
        median2 = median1;
        if(mergedLength % 2 == 0) {
            median2 = getMedian(nums1, nums2, desCnt - 1);
        }
        
        // System.out.println("med1 " + median1 + " median2 " + median2);
    
        double median = (double)(median1 + median2) / (double)2;
        return median;   
    }
    
    int getMedian(int[] nums1, int[] nums2, int desCnt) {
        // System.out.println("des cnt " + desCnt);
        if(nums1.length == 0 && nums2.length == 0) {
            return 0;
        }
        if(nums1.length == 0) {
            return nums2[desCnt];
        }
        if(nums2.length == 0) {
            return nums1[desCnt];
        }
        int median = getNumForDesCnt(nums1, nums2, desCnt);
        if(median < 0) {
            median = getNumForDesCnt(nums2, nums1, desCnt);
        }
        return median;
    }
    
    int getNumForDesCnt(int[] smallArr, int[] largeArr, int desCnt) {
        if(desCnt == 0) {
            return Math.min(smallArr[0], largeArr[0]);
        }
        int s = 0;
        int e = smallArr.length;
        int median = -1;
        
        while(s < e) {
            int m = (s + e) / 2;
            int midNum = smallArr[m];
            int numsGreater = m;
            int tmp = greaterNums(largeArr, midNum, (desCnt - m));
            numsGreater += tmp;
            // System.out.println("mid num " + midNum + "; small greater -> " + m + "; larger greater -> " + tmp);
            if(numsGreater == desCnt) {
                median = midNum;
                break;
            }
            if(numsGreater > desCnt) {
                // median = midNum;
                e = m;
            } else {
                s = m + 1;
            }
        }
        
        return median;
    }
    
    int greaterNums(int[] nums, int n, int desCnt) {
        int s = 0;
        int e = nums.length;
        int ans = 0;
        while(s < e) {
            int mid = (s + e) / 2;
            int midNum = nums[mid];
            if(n == midNum) {
                ans = mid + 1;
                if(ans == desCnt) {
                    return ans;
                } else if(ans < desCnt) {
                    s = mid + 1;
                } else {
                    e = mid;
                }
            } else if(n > midNum) {
                ans = mid + 1;
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        
        return ans;
    }
}