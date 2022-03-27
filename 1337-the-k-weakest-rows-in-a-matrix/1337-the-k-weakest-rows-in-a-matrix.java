class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] matStr = new int[mat.length][2];
        for(int i = 0; i < mat.length; i++) {
            int sum = findSum(mat[i]);
            matStr[i][0] = i;
            matStr[i][1] = sum;
        }
        
        Arrays.sort(matStr, new Comparator<int[]>() {
            @Override
            public int compare(int[] s1, int[] s2) {
                if(s1[1] == s2[1]) {
                    return (s1[0] - s2[0]);
                } else {
                    return (s1[1] - s2[1]);
                }
            }
        });
        
        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = matStr[i][0];
        }
        
        return ans;
    }
    
    int findSum(int[] a) {
        int sum = 0;
        int ptr = 0;
        while(ptr < a.length && a[ptr] > 0) {
            sum++;
            ptr++;
        }
        return sum;
    }
}