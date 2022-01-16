class Solution {
    public int maxEnvelopes(int[][] envelopes) {
                Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // -1, 0, 1
                if (o1[0] > o2[0]) {
                    return -1;
                }
                if (o1[0] == o2[0]) {
                    return 0;
                }
                return 1;
            }
        });

        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        for (int i = 1; i < envelopes.length; i++) {
            dp[i] = 1;
            int parentW = envelopes[i][0];
            int parentH = envelopes[i][1];
            for (int j = 0; j < i; j++) {
                int currentW = envelopes[j][0];
                int currentH = envelopes[j][1];
                if (parentH < currentH && parentW < currentW) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int max = dp[0];
        for (int i: dp) {
            max = Math.max(max, i);
        }

        return  max;
    }
}