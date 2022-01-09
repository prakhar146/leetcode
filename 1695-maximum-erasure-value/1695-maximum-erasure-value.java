class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int start = 0;
        int end = 0;
        int currentScore = 0;
        int maxScore = 0;

        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        // System.out.println("Sums -> " + Arrays.toString(sum));
        // System.out.println("nums -> " + Arrays.toString(nums));
        // System.out.println("sub \t | \t Score \t | \t start | \t end");
        Map<Integer, Integer> numWithIdx = new HashMap<>();

        while (end < nums.length) {
            if (numWithIdx.containsKey(nums[end])) {
                start = Math.max(numWithIdx.get(nums[end]) + 1, start);
            }

            currentScore = sum[end + 1] - sum[start];
            maxScore = Math.max(currentScore, maxScore);
            numWithIdx.put(nums[end], end);
            end++;

            // System.out.println(Arrays.toString(Arrays.copyOfRange(nums, start, end)) + "\t" + currentScore + "\t" + start + "\t" + end);
        }

        return maxScore;
    }
}