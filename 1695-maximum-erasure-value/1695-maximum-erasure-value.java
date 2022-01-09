class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        short[] nmap = new short[10001];

        int total = 0;
        int start = 0;
        int end = 0;

        int max = 0;

        while (end < nums.length) {
            nmap[nums[end]]++;
            total += nums[end];

            while (nmap[nums[end]] > 1) {
                nmap[nums[start]]--;
                total -= nums[start];
                start++;
            }

            max = Math.max(total, max);
            end++;
        }

        return max;
    }
}