class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if(arr1[0] == arr2[0]) {
                    return arr1[1] - arr2[1];
                } else {
                    return arr1[0] - arr2[0];
                }
            }
        });
        int idx = 1;
        int N = intervals.length;
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> merged = new ArrayList<>();
        while(idx < N) {
            int currentStart = intervals[idx][0];
            int currentEnd = intervals[idx][1];
            if(end >= currentStart && end >= currentEnd) {
                idx++;
            } else if (end >= currentStart && end < currentEnd) {
                end = currentEnd;
                idx++;
            } else if (end < currentStart) {
                merged.add(new int[]{start, end});
                start = currentStart;
                end = currentEnd;
                idx++;
            }
        }
        merged.add(new int[]{start, end});
        return merged.stream().toArray(int[][]::new);
    }
}
/*
[1,3] [2, 6] [8, 10] [15,18]


*/