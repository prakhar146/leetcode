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
    public void flatten(TreeNode root) {
        flattenTree(root);
    }
    
    TreeNode flattenTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        TreeNode left = flattenTree(root.left);
        TreeNode right = flattenTree(root.right);
        root.right = left;
        root.left = null;
        TreeNode prevPtr = root;
        TreeNode ptr = root.right;
        while(ptr != null) {
            prevPtr = ptr;
            ptr = ptr.right;
        }
        prevPtr.right = right;
        return root;
    }
}