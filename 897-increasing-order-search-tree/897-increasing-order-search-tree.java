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
    TreeNode currentRoot = new TreeNode(-1);
    public TreeNode increasingBST(TreeNode root) {
        TreeNode listNode = currentRoot;
        inorder(root);
        return listNode.right;
    }
    
    void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        currentRoot.right = root;
        currentRoot = currentRoot.right;
        currentRoot.left = null;
        inorder(root.right);
    }
}