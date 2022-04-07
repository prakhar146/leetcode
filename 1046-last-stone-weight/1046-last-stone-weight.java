class Solution {
    public int lastStoneWeight(int[] stones) {
        // PriorityQueue<Integer> my_p_queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        Arrays.sort(stones);
        int n = stones.length;
        while(stones.length > 1 && stones[n - 2] > 0) {
            int diff = stones[n - 1] - stones[n - 2];
            stones[n - 1] = diff;
            stones[n - 2] = 0;
            Arrays.sort(stones);
            // System.out.println(Arrays.toString(stones));
        }
        return stones[n - 1];
    }
}

/*


7,3,2

0,4,2

4,2,0

2,2,0




*/