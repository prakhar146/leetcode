class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        loadGraph(graph, prerequisites);
        // printMap(graph);
        boolean hasCycle = false;
        // for(int i: graph.keySet()) {
        //     hasCycle = hasCycle || hasCycle(graph, i);
        // }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> dfsVisited = new HashSet<>();
        for(int i: graph.keySet()) {
            if(!visited.contains(i)) {
                boolean ans = hasCycleDFS(graph, i, visited, dfsVisited);
                // System.out.println("Node " + i + " ans " + ans);
                hasCycle = hasCycle || ans;
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
    
    boolean hasCycleDFS(Map<Integer, List<Integer>> graph, int src, Set<Integer> visited, Set<Integer> dfsVisited) {
        if(visited.contains(src)) {
            return false;
        }
        // System.out.println("Checking for " + src);
        boolean hasCycle = false;
        dfsVisited.add(src);
        visited.add(src);
        if(!graph.containsKey(src)) {
            dfsVisited.remove(src);
            return false;
        }
        for(int nextNode: graph.get(src)) {
            if(dfsVisited.contains(nextNode)) {
                return true;
            }
            if(hasCycleDFS(graph, nextNode, visited, dfsVisited)) {
                return true;
            }
        }
        dfsVisited.remove(src);
        return hasCycle;
    }
    
    boolean hasCycle(Map<Integer, List<Integer>> graph, int src) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        Set<Integer> hasVisited = new HashSet<>();
        while(!queue.isEmpty()) {
            int node = queue.poll();
            if(node == 5) {
                // System.out.print("currentnode -> " + node);
            }
            if(hasVisited.contains(node)) {
                // System.out.println("currentnode -> " + node + " visited -> true");
                return true;
            }
            hasVisited.add(node);
            List<Integer> nodesToVisit = graph.get(node);
            if(nodesToVisit != null && nodesToVisit.size() > 0) {
                for(int nextNode: nodesToVisit) {
                     // System.out.println(" nextNode -> " + nextNode);
                    queue.offer(nextNode);
                }
            }
        }
        
        return false;
        
    }
    
    void printMap(Map<Integer, List<Integer>> graph) {
        for(int key: graph.keySet()) {
            System.out.println(key + " -> " + graph.get(key));
        }
        System.out.println("----------");
    }
}