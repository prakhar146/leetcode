class KthLargest {
    int k = 0;
    List<Integer> nums;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = new ArrayList<Integer>(Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new)));
        Collections.sort(this.nums, Collections.reverseOrder());
    }
    
    public int add(int val) {
        if((this.nums.size() >= k) && (val < this.nums.get(k - 1))) {
            return this.nums.get(k - 1);
        }
        int i = 0;
        while(i < nums.size() && nums.get(i) > val) {
            i++;
        }
        this.nums.add(i, val);
        return this.nums.get(k - 1);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */