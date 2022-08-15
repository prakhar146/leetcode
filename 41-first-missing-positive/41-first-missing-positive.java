class Solution {
    public int firstMissingPositive(int[] nums) {
        int N = nums.length;
        int max = 1;
        for(int i = 0; i < N; i++) {
            int num = nums[i];
            max = Math.max(nums[i], max);
            if(num != (i + 1)) {
                int actualIdx = num - 1;
                if(actualIdx > -1 && actualIdx < N && num != nums[actualIdx]) {
                    int tmp = nums[actualIdx];
                    nums[actualIdx] = nums[i];
                    nums[i] = tmp;
                    i--;
                }
            }
        }
        
        // System.out.println(Arrays.toString(nums));
        
        for(int i = 0; i < N; i++) {
            int num = nums[i];
            if(num != (i + 1)) {
                return (i + 1);
            }
        }
        
        
        return (max + 1);
    }
}
/*

[3, 4, -1, 1]

[1, 4, 3, 4]


*/