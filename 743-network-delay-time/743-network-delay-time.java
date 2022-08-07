class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Pair>> graph = new HashMap<>();
        Map<Integer, Integer> visited = new HashMap<>();
        loadGraph(graph, times);
        // printGraph(graph);
        
        doDijkstra(graph, visited, k);
        if(visited.size() < n) {
            return -1;
        }
        int max = 0;
        for(int node: visited.keySet()) {
            // System.out.println(node + " -> " + visited.get(node));
            max = Math.max(max, visited.get(node));
        }
        return max;
    }
    
    void loadGraph(Map<Integer, List<Pair>> graph, int[][] times) {
        for(int[] time: times) {
            int source = time[0];
            Pair dest = new Pair(time[1], time[2]);
            if(!graph.containsKey(source)) {
                graph.put(source, new ArrayList<>());
            }
            List<Pair> currentList = graph.get(source);
            currentList.add(dest);
            graph.put(source, currentList);
        }
    }
    
    void doDijkstra(Map<Integer, List<Pair>> graph, Map<Integer, Integer> visited, int src) {
        Queue<Pair> q = new PriorityQueue<>();
        q.offer(new Pair(src, 0));
        
        while(!q.isEmpty()) {
            Pair nodeVisited = q.poll();
            int disSoFar = nodeVisited.weight;
            if(!visited.containsKey(nodeVisited.node)) {
                visited.put(nodeVisited.node, disSoFar);
            }
            List<Pair> nodesToVisit = graph.get(nodeVisited.node);
            if(nodesToVisit != null) {
                for(Pair nodeToVisit: nodesToVisit) {
                    if(!visited.containsKey(nodeToVisit.node)) {
                        // System.out.println("add");
                        q.offer(new Pair(nodeToVisit.node, nodeToVisit.weight + disSoFar));
                        // visited.put(nodeToVisit.node, nodeToVisit.weight + disSoFar);
                    }
                }
            }
        }
        return;
    }
    
    class Pair implements Comparable<Pair> {
        int node;
        int weight;
        
        Pair(int n, int w) {
            node = n;
            weight = w;
        }
        
        public String toString() {
            return "n: " + node + " w: " + weight; 
        }
        
        public int compareTo(Pair p2) {
            return this.weight - p2.weight;
        }
    }
    
    void printGraph(Map<Integer, List<Pair>> graph) {
        for(int node: graph.keySet()) {
            System.out.println(node + " -> " + graph.get(node));
        }
        System.out.println("****************");
    }
}