class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        loadGraph(graph, prerequisites);
        Map<Integer, Boolean> visited = new HashMap<>();
        Map<Integer, Boolean> dfsStack = new HashMap<>();
        boolean hasCycle = false;
        for(int course: graph.keySet()) {
            if(!visited.containsKey(course)) {
                hasCycle = hasCycle || hasCycle(graph, visited, dfsStack, course);
            }
        }
        return !hasCycle;
    }
    
    void loadGraph(Map<Integer, List<Integer>> graph, int[][] prerequisites) {
        for(int[] prerequisite: prerequisites) {
            int course = prerequisite[0];
            int preq = prerequisite[1];
            if(!graph.containsKey(course)) {
                graph.put(course, new ArrayList<>());
            }
            List<Integer> currentPreqs = graph.get(course);
            currentPreqs.add(preq);
            graph.put(course, currentPreqs);
        }
    }
    
    boolean hasCycle(Map<Integer, List<Integer>> graph, Map<Integer, Boolean> visited, Map<Integer, Boolean> dfsStack, int src) {
        dfsStack.put(src, true);
        visited.put(src, true);
        List<Integer> nodesToVisit = graph.get(src);
        boolean hasCycle = false;
        if(nodesToVisit != null) {
            for(int node: graph.get(src)) {
                if(dfsStack.containsKey(node)) {
                    return true;
                }
                if(!visited.containsKey(node)) {
                    hasCycle = hasCycle || hasCycle(graph, visited, dfsStack, node);
                }
            }   
        }
        dfsStack.remove(src);
        return hasCycle;
    }
    
    void printMap(Map<Integer, List<Integer>> graph) {
        for(int key: graph.keySet()) {
            System.out.println(key + " -> " + graph.get(key));
        }
        System.out.println("----------");
    }
}