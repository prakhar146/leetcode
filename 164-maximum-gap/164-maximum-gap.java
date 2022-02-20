class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }
        int numOfIntervals = nums.length - 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i: nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        
        Integer[] minBuckets = new Integer[numOfIntervals];
        Integer[] maxBuckets = new Integer[numOfIntervals];
        
        fillBuckets(minBuckets, maxBuckets, numOfIntervals, min, max, nums);
        
        // System.out.println("min bucket -> " + Arrays.toString(minBuckets));
        // System.out.println("max bucket -> " + Arrays.toString(maxBuckets));
        
        return compareBuckets(minBuckets, maxBuckets);
    }
    
    void fillBuckets(Integer[] minBuckets, Integer[] maxBuckets, int numOfIntervals, int min, int max, int[] nums) {
        // System.out.println("min -> " + min + " max -> " + max);
        int avgInterval = (int)Math.ceil((double)(max + 1 - min) / (double)numOfIntervals);
        
        // System.out.println("avg interval size -> " + avgInterval);
        
        for(int i: nums) {
            int bucketIdx = (i - min) / avgInterval;
            if(minBuckets[bucketIdx] == null) {
                minBuckets[bucketIdx] = i;
            }
            if(maxBuckets[bucketIdx] == null) {
                maxBuckets[bucketIdx] = i;
            }
            minBuckets[bucketIdx] = Math.min(minBuckets[bucketIdx], i);
            maxBuckets[bucketIdx] = Math.max(maxBuckets[bucketIdx], i);
        }
    }
    
    int compareBuckets(Integer[] minBuckets, Integer[] maxBuckets) {
    
        int max = 0;
        
        for(int i = 0; i < minBuckets.length; i++) {
            if(minBuckets[i] != null) {
                max = maxBuckets[i] - minBuckets[i];
                break;
            }
        } 
        
        int ptr1 = 0, ptr2 = 0;
        
        while(ptr2 < minBuckets.length) {
            if(ptr2 <= ptr1 || (minBuckets[ptr2] == null)) {
                ptr2++;
            } else {
                max = Math.max(max, minBuckets[ptr2] - maxBuckets[ptr1]);
                ptr1 = ptr2;
                ptr2++;
            }
        }
        
        // for(int i = 1; i < minBuckets.length; i++) {
        //     if(minBuckets[i] != null && maxBuckets[i - 1] != null) {
        //          max = Math.max(max, minBuckets[i] - maxBuckets[i - 1]);
        //     }
        // }
        // max = Math.max()
        
        return max;
    }
}

/* 

3, 6, 9, 1
 intervals = 3
 min = 1
 max = 9

avgInterval = 8 / 3 = ceil(2.34) = 3

2 / 3 = 0
5 / 3 = 1.6 = 



*/