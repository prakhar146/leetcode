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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val >= Math.min(p.val, q.val) && root.val <= Math.max(p.val, q.val)) {
            return root;
        }
        
        TreeNode lca = null;
        if(root.val <= Math.min(p.val, q.val)) {
            lca = lowestCommonAncestor(root.right, p, q);
        }
        if(root.val >=  Math.max(p.val, q.val)) {
            lca = lowestCommonAncestor(root.left, p, q);
        }
        return lca;
    }
}