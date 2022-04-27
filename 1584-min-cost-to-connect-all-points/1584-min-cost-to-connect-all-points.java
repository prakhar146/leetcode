class Solution {
    class Edge {
        int src;
        int dest;
        int w;
        
        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.w = w;
        }
        
        public String toString() {
            return "[s: " + this.src + ", d: " + this.dest + ", w: " + this.w + "]";
        }
    }
    
    public int minCostConnectPoints(int[][] points) {
        int noOfVertices = points.length;
        List<Edge>[] graph = new ArrayList[noOfVertices];
        
        int edgeWeight = 0;
        for(int i = 0; i < noOfVertices; i++) {
            graph[i] = new ArrayList<>();
            for(int j = 0; j < noOfVertices; j++) {
                if(i != j) {
                    edgeWeight = getEdgeWeight(points, i, j);
                    graph[i].add(new Edge(i, j, edgeWeight));
                }
            }
        }
        
        Map<Integer, Integer> visitedNodes = new HashMap<>();
        
        Queue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return (e1.w - e2.w);
            }
        });
        pq.add(new Edge(-1, 0, 0));
        
        while(!pq.isEmpty()) {
            Edge topEdge = pq.poll();
            int topEdgeDest = topEdge.dest;
            int currentDistanceToDest = topEdge.w;
            if(visitedNodes.containsKey(topEdgeDest)) {
                int minDistanceToDest = visitedNodes.get(topEdgeDest);
                if(minDistanceToDest <= currentDistanceToDest) {
                    continue;
                } else {
                    visitedNodes.put(topEdgeDest, currentDistanceToDest);
                }
                // minDistanceToDest = Math.min(topEdge.w, minDistanceToDest);
            } else {
                 visitedNodes.put(topEdgeDest, topEdge.w);
            }
            List<Edge> edgeList = graph[topEdgeDest];
            for(Edge e: edgeList) {
                if(!visitedNodes.containsKey(e.dest)) {
                    pq.add(e);   
                }
            }
        }
        
        int cost = 0;
        for(int i: visitedNodes.keySet()) {
            cost += visitedNodes.get(i);
        }
        
        // printGraph(graph);
        // printMap(visitedNodes);
        
        return cost;
    }
    
    int getEdgeWeight(int[][] points, int s, int d) {
        int xDis = Math.abs(points[s][0] - points[d][0]);
        int yDis = Math.abs(points[s][1] - points[d][1]);
        int minD = (xDis + yDis);
        // System.out.println("S -> [" + points[s][0] + ", " + points[s][1] + "] D -> [" + points[d][0] + ", " + points[d][1] + "] minD -> " + minD);
        return minD;
    }
    
    void printGraph(List<Edge>[] graph) {
        for(int i = 0; i < graph.length; i++) {
            System.out.print(i + " -> ");
            for(Edge e: graph[i]) {
                System.out.print(e + ", ");
            }
            System.out.println();
        }
    }
    
    void printMap(Map<Integer, Integer> visitedNodes) {
        System.out.println("-------------------------");
        for(int i: visitedNodes.keySet()) {
            System.out.println(i + " -> " + visitedNodes.get(i));
        }
    }
}

/*
[0,0] -> [0,0], [1,4], [2, 10]
[2,2]
[3,10]
[5,2]
[7,0]




*/