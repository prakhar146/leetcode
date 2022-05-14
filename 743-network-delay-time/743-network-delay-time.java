class Solution {
    class Travel {
        int d, t;
        
        Travel(int d, int t) {
            this.d = d;
            this.t = t;
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        int visited[] = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        int[][] graph = new int[n + 1][n + 1];
        for(int i = 0; i < (n + 1); i++) {
            for(int j = 0; j < (n + 1); j++) {
                graph[i][j] = -1;
            }
        }
        
        loadGraph(graph, times);
        
        // System.out.println("---GRAPH----");
        // for(int nodes[]: graph) {
        //     System.out.println(Arrays.toString(nodes));
        // }
        visited[k] = 0;
        
        Deque<Travel> nodesToVisit = new ArrayDeque<>();
        nodesToVisit.push(new Travel(k, 0));
        
        while(!nodesToVisit.isEmpty()) {
            Travel currentTravel = nodesToVisit.pop();
            int dest = currentTravel.d;
            int travelWeight = currentTravel.t;
            // System.out.println("Visited " + dest + " weight -> " + travelWeight);
            visited[dest] = Math.min(visited[dest], travelWeight);
            
            int[] nextNodes = graph[dest];
            for(int d = 0; d <= n; d++) {
                int dTravelWeight = nextNodes[d];
                if(dTravelWeight != -1) {
                    int currentTravelWeight = dTravelWeight + travelWeight;
                    if(visited[d] == -1 ||  (visited[d] > currentTravelWeight)) {
                        nodesToVisit.push(new Travel(d, currentTravelWeight));
                    }
                    
                }
            }
        }
        
        int ans = 0;
        
        // System.out.println("-----Ans-----");
        // System.out.println(Arrays.toString(visited));
        
        for(int i = 1; i <= n; i++) {
            int num = visited[i];
            if(num == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, num);
        }
        
        return ans;
        
    }
    
    void loadGraph(int[][] graph, int[][] times) {
        for(int[] time: times) {
            int from = time[0];
            int to = time[1];
            int w = time[2];
            graph[from][to] = w;
        }
    }
}
/*
2
s -> 1, 3
3
s -> 1, 3, 4




*/