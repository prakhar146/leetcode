class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                if(a1[0] != a2[0]) {
                    return a1[0] - a2[0];
                } else {
                    return a2[1] - a1[1];
                }
                
            }
        });
        
        // for(int[] i: intervals) {
        //      System.out.println(Arrays.toString(i));
        // }
        
        int cnt = 1;
        int intervalSkipped = 0;
        int left = 0, right = 0;
        int numLeft, numRight;
        
        while(right < intervals.length) {
            numLeft = intervals[left][1];
            numRight = intervals[right][1];
            if(numLeft < numRight) {
                // change left and modify cnt
                intervalSkipped += right - left - 1;
                left = right;
                cnt++;
            }
            right++;
        }   
         // System.out.println("left here -> " + left);
        intervalSkipped += (right - left) - 1;
            
        return cnt;
    }
}
/*

[1,4] [2,8] [3,6]



*/