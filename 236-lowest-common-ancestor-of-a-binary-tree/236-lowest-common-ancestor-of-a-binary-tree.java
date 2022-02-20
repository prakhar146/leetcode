/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        visitNode(root, p, q);
        return lca;
    }
    
    boolean visitNode(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return false;
        }
        
        int visitLeft = visitNode(root.left, p, q) ? 1 : 0;
        int visitRight = visitNode(root.right, p, q) ? 1 : 0;
        
        int currentIsRight = (root == p || root == q) ? 1 : 0;
        
        
        if(visitLeft + visitRight + currentIsRight > 1) {
            this.lca = root;
        }
        
        return ((visitLeft + visitRight + currentIsRight) > 0);
        
    }
}