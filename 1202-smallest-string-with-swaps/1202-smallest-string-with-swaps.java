class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        List<Integer>[] graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (List<Integer> edge : pairs) {
            int source = edge.get(0);
            int destination = edge.get(1);
            
            graph[source].add(destination);
            graph[destination].add(source);
        }
        
        char[] answer = new char[n];
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]){
                List<Character> chars = new ArrayList<>();
                List<Integer> indices = new ArrayList<>();
                
                doDFS(s, i, chars, indices, visited, graph);
                
                Collections.sort(chars);
                Collections.sort(indices);
                
                for(int idx = 0; idx < chars.size(); idx++) {
                    answer[indices.get(idx)] = chars.get(idx);
                }
            }
        }
        
        return new String(answer);
        
    }
    
    void doDFS(String s, int v, List<Character> chars, List<Integer> indices, boolean[] visited, List<Integer>[] graph) {
        chars.add(s.charAt(v));
        indices.add(v);
        visited[v] = true;
        for(int vertex: graph[v]) {
            if(!visited[vertex]) {
                doDFS(s, vertex, chars, indices, visited, graph);
            }
        }
    }
}