class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> subsetList = new ArrayList<>();
        getSubsetList(nums, 0, subset, subsetList);
        return subsetList;
    }
    
    private void getSubsetList(int[] nums, int idx, List<Integer> subset, List<List<Integer>> subsetList) {
        if(idx == nums.length) {
            subsetList.add(new ArrayList<>(subset));
            return;
        }
        
        int currentNum = nums[idx];
        // op1
        int currentNumIdx = subset.size();
        subset.add(currentNum);
        getSubsetList(nums, idx + 1, subset, subsetList);
        // op2
        subset.remove(currentNumIdx);
        getSubsetList(nums, idx + 1, subset, subsetList);
    }
}