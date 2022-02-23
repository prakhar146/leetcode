/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> createdNodes = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) {
            return node;
        }
        if(createdNodes.containsKey(node.val)) {
            return createdNodes.get(node.val);
        }
        // if(node.neighbors.isEmpty()) {
        //     return new Node(node.val);
        // }
        Node newRootNode = new Node(node.val);
        createdNodes.put(node.val, newRootNode);
        Node clonedNode;
        for(Node n: node.neighbors) {
            clonedNode = cloneGraph(n);
            newRootNode.neighbors.add(clonedNode);
        }
        return newRootNode;
    }
}