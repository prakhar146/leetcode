class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }
        int min = nums[0];
        int max = nums[1];
        
        for(int i: nums) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        
        int minPossibleAns = (int) Math.ceil(((double) (max - min)) / nums.length);
        
        if(minPossibleAns == 0) {
            return 0;
        }
        
        int maxGap = minPossibleAns;
        
        LinkedList<Integer>[] buckets = new LinkedList[nums.length];
        // for(int i = 0; i < nums.length; i++) {
        //     buckets[i] = new ArrayList<Integer>();
        // }
        
        for(int i = 0; i < nums.length; i++) {
            buckets[i] = new LinkedList<Integer>();
        }
        
        // System.out.println("min poss ans -> " + minPossibleAns);
        
        for(int i: nums) {
            int diff = (i - min);
            int bucketIdx =  (diff != 0 && diff % minPossibleAns == 0) ? ((diff / minPossibleAns) - 1): (diff / minPossibleAns);
            // System.out.print("num -> " + i + " idx -> " + bucketIdx);
            LinkedList<Integer> bucket = buckets[bucketIdx];
            if(bucket.size() > 0) {
                int bucketMin = bucket.getFirst();
                int bucketMax = bucket.getLast();
                if(i < bucketMin) {
                    // bucket.set(0, i);
                    bucket.addFirst(i);
                }
                if (i > bucketMax) {
                    // bucket.set(nums.length - 1, i);
                    bucket.addLast(i);
                }
            } else {
                bucket.addFirst(i);                
            }
            // System.out.println(" bucket -> " + buckets[bucketIdx]);
        }
        
        int idx = 0;
        int currentValue = -1;
        int lastValue = -1;
        while(idx < nums.length) {
            if(buckets[idx].size() > 0) {
                // currentValue = buckets[idx].get(0);
                currentValue = buckets[idx].getFirst();
                if(lastValue > -1) {
                    maxGap = Math.max(maxGap, currentValue - lastValue);
                }
                // lastValue = buckets[idx].get(buckets[idx].size() - 1);
                lastValue = buckets[idx].getLast();
            }
            idx++;
        }
        
        return maxGap;
    }
}

/*

1,3,6,9 

*/