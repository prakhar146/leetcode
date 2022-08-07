class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j) {
                    distance[i][j] = 10001;
                }
            }
        }
        
        for(int[] edge: edges) {
            int i = edge[0];
            int j = edge[1];
            distance[i][j] = edge[2];
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    distance[j][k] = Math.min(distance[j][k], distance[j][i] + distance[i][k]);
                    distance[k][j] = Math.min(distance[j][k], distance[j][i] + distance[i][k]);
                }
            }
        }
        int cityNum = -1;
        int maxCnt = 10001;
        for(int i = 0; i < n; i++) {
            int currentCnt = 0;
            for(int j = 0; j < n; j++) {
                int dist = Math.min(distance[i][j], distance[j][i]);
                if(distance[i][j] <= distanceThreshold) {
                    currentCnt++;
                }
            }
            // System.out.println("city " + i + " cnt " + currentCnt);
            if(currentCnt <= maxCnt) {
                maxCnt = currentCnt;
                cityNum = i;
            }
        }
        // System.out.println();
        // printMatrix(distance);
        return cityNum;
    }
    
    void printMatrix(int[][] distance) {
        for(int[] arr: distance) {
            System.out.println(Arrays.toString(arr));
        }
    }
}