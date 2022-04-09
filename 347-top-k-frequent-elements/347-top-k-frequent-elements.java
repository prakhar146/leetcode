class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        List<int[]> freqList = new ArrayList<>();
        // System.out.println(Arrays.toString(nums));
        int[] freqCnt = new int[2];
        freqCnt[0] = nums[0];
        freqCnt[1] = 1; 
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == freqCnt[0]) {
                freqCnt[1]++;
            } else {
                freqList.add(freqCnt);
                freqCnt = new int[2];
                freqCnt[0] = nums[i];
                freqCnt[1] = 1;   
            }
        }
        
        freqList.add(freqCnt);
        Collections.sort(freqList, new Comparator<int[]>() {
            public int compare(int[] obj1, int[] obj2) {
                if(obj1[1] > obj2[1]) {
                    return -1;
                } else if(obj1[1] < obj2[1]) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        
        // (freqList.stream().map(it -> it[0])).forEach(System.out::println);
        
        return freqList
            .stream()
            .limit(k)
            .map(it -> it[0])
            .mapToInt(it -> it).toArray();
    }
}

/*

[1,1,1,2,2,3]

[[1,3],[2,2],[3,1]] - sort



*/