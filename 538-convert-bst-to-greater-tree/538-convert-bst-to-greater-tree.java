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
class Solution {
    public TreeNode convertBST(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        doInorder(root, nodes);
        populatePostsum(nodes);
        return root;
    }
    
    void doInorder(TreeNode root, List<TreeNode> nodes) {
        if(root == null) {
            return;
        }
        doInorder(root.left, nodes);
        nodes.add(root);
        doInorder(root.right, nodes);
    }
    
    void populatePostsum(List<TreeNode> nodes) {
        int m = nodes.size() - 1;
        int lastSum = 0;
        TreeNode tmp = null;
        for(int i = m; i > -1; i--) {
            tmp = nodes.get(i);
            tmp.val = tmp.val + lastSum;
            lastSum = tmp.val;
        }
    }
}