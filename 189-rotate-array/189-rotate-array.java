class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] arr2 = Arrays.copyOf(nums, nums.length);
        for(int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = arr2[i];
        }
        return;
    }
}