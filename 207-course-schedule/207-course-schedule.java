class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        loadGraph(graph, prerequisites, prerequisites.length);
        return !hasCycle(graph);
    }
    
//     private boolean hasCycle(Map<Integer, List<Integer>> graph) {
//         if(graph.size() < 1) {
//             return false;
//         }
        
//         StringBuilder cyc = new StringBuilder();
        
//         Queue<Integer> dq = new ArrayDeque<>();
//         Map<Integer, Boolean> finished = new HashMap<>();
//         for(int course: graph.keySet()) {
//             System.out.println("--------------");
//             Map<Integer, Boolean> pathStack = new HashMap<>();
//             if(!finished.containsKey(course)) {
//                 dq.offer(course);
//                 pathStack.put(course, true);
//                 cyc.append(course);
//                 while(!dq.isEmpty()) {
//                     int courseToStudy = dq.poll();
//                     System.out.print("Study " + courseToStudy);
//                     pathStack.remove(courseToStudy);
//                     if(finished.containsKey(courseToStudy)) {
//                         return true;
//                     }
//                     if(graph.containsKey(courseToStudy)) {
//                         List<Integer> preReqs = graph.get(courseToStudy);
//                         System.out.println(" Preq + " + Arrays.toString(preReqs.toArray()));
//                         for(int preReq: preReqs) {
//                             cyc.append(" -> " + preReq);
//                             if(!finished.containsKey(preReq)) {
//                                 pathStack.put(preReq, true);
//                                 dq.offer(preReq);
//                             }
//                         }
//                     } else System.out.println();
//                     finished.put(courseToStudy, true);
//                 }   
//             } else System.out.println("Study " + course + " -> Already studied!");
//         }
        
//         return false;
//     }
    
    private boolean hasCycle(Map<Integer, List<Integer>> graph) {
        if(graph.size() < 1) {
            return false;
        }
        Map<Integer, String> status = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();
        Stack<Integer> s = new Stack<>();
        boolean ans = false;
        for(int vertex: graph.keySet()) {
            q.add(vertex);
            s.add(vertex);
            ans = ans || hasCycleDFS(graph, vertex, status, q, s);
        }
        
        return ans;
    }
    
    private boolean hasCycleDFS(Map<Integer, List<Integer>> graph, int vertex, Map<Integer, String> status, Queue<Integer> q, Stack<Integer> s) { 
        if(!graph.containsKey(vertex)) {
            return false;
        }
        boolean ans = false;
        for(int v: graph.get(vertex)) {
            if(status.containsKey(v) && status.get(v) == "IN_STACK") {
                return true;
            }
            if(!status.containsKey(v) || status.get(v) != "VISITED") {
                status.put(v, "IN_STACK");
                q.offer(v);
                s.push(v);
                ans = ans || hasCycleDFS(graph, v, status, q, s);   
            }
            status.put(v, "VISITED");
        }
        q.poll();
        if(s.size() > 0) {
            s.pop();   
        }
        return ans;
    }
    
    private void printStack(Queue<Integer> q) {
        System.out.println("--Path--");
        while(!q.isEmpty()) {
            System.out.print(q.poll() + " ->");
        }
        System.out.println();
    }
    
        private void printStack(Stack<Integer> s) {
        System.out.println("--Path--");
        while(!s.isEmpty()) {
            System.out.print(s.pop() + " ->");
        }
        System.out.println();
    }
    
    private void loadGraph(Map<Integer, List<Integer>> graph, int[][] prerequisites, int n) {
        for(int i = 0; i < n; i++) {
            int course = prerequisites[i][0];
            int preReq = prerequisites[i][1];
            if(!graph.containsKey(course)) {
                graph.put(course, new ArrayList<>());
            }
            List<Integer> currentPreReq = graph.get(course);
            currentPreReq.add(preReq);
            graph.put(course, currentPreReq);
        }
    }
}

/*
1 -> 0

*/