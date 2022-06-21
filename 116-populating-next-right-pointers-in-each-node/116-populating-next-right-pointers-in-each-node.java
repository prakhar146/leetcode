/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return root;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            int numberOfNodes = q.size();
            Node prev = null;
            Node current = null;
            for(int i = 0; i < numberOfNodes; i++) {
                prev = current;
                current = q.poll();
                if(prev != null) {
                    prev.next = current;
                    // System.out.println("prev " + prev.val + " current " + current.val);
                }
                if(current.left != null) {
                    q.offer(current.left);
                }
                if(current.right != null) {
                    q.offer(current.right);
                }
            }
        }
        
        return root;
    }
}