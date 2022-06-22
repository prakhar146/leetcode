class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 9\n[[0,7],[2,0],[0,4],[0,8],[6,1],[1,3],[3,5],[5,8],[6,5]]
        // 
        Map<Integer, List<Integer>> graph = new HashMap<>();
        loadGraph(graph, prerequisites);
        return !hasCycle(graph);
    }

    boolean hasCycle(Map<Integer, List<Integer>> graph) {
        Map<Integer, Boolean> visited = new HashMap<>();
        for(int course: graph.keySet()) {
            if(!visited.containsKey(course)) {
                Map<Integer, Boolean> currentStack = new HashMap<>();
                boolean hasCycle = hasCycleFromCourse(graph, course, visited, currentStack);
                if(hasCycle) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean hasCycleFromCourse(Map<Integer, List<Integer>> graph, int vertex, Map<Integer, Boolean> visited, Map<Integer, Boolean> currentStack) {
        List<Integer> adjVertex = graph.get(vertex);
        visited.put(vertex, true);
        if(adjVertex == null) {
            return false;
        }
        currentStack.put(vertex, true);
        boolean hasCycle = false;
        for(int v: adjVertex) {
            if(currentStack.containsKey(v)) {
                return true;
            }
            if(!visited.containsKey(v)) {
                hasCycle = hasCycle || hasCycleFromCourse(graph, v, visited, currentStack);
            }
        }
        currentStack.remove(vertex);
        return hasCycle;
    }

    void loadGraph(Map<Integer, List<Integer>> graph, int[][] prerequisites) {
        for(int[] prerequisite: prerequisites) {
            int course = prerequisite[0];
            int coursePrerequisite = prerequisite[1];

            if(!graph.containsKey(course)) {
                graph.put(course, new ArrayList<>());
            }
            List<Integer> currentPrerequisites = graph.get(course);
            currentPrerequisites.add(coursePrerequisite);
            graph.put(course, currentPrerequisites);
        }
    }
}