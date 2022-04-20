/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    int ptr;
    List<TreeNode> nodes;
    
    
    public BSTIterator(TreeNode root) {
        nodes = new ArrayList<>();
        nodes.add(new TreeNode(-1));
        ptr = 0;
        loadNodes(root);
    }
    
    private void loadNodes(TreeNode root) {
        if(root == null) {
            return;
        }
        loadNodes(root.left);
        nodes.add(root);
        loadNodes(root.right);
        
    }
    
    public int next() {
        this.ptr++;
        int val = nodes.get(this.ptr).val;
        return val;
    }
    
    public boolean hasNext() {
        return ((this.ptr + 1) < this.nodes.size()); 
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */