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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }
        if((root == null && subRoot != null) || (root != null && subRoot == null)) {
            return false;
        }
        boolean op1 = false, op2 = false, op3 = false;
        if(root.val == subRoot.val) {
            op1 = isSameTree(root, subRoot);
        }
        op2 = isSubtree(root.left, subRoot);
        op3 = isSubtree(root.right, subRoot);
        return (op1 || op2 || op3);
    }
    
    boolean isSubtree(TreeNode root, TreeNode subRoot, TreeNode currentNode) {
        if(currentNode == null && root == null) {
            return true;
        }
        if((currentNode != null && root == null) || (currentNode == null && root != null)) {
            return false;
        }
        boolean op1 = false, op2 = false, op3 = false;
        if(currentNode.val == root.val) {
            op1 = (isSubtree(root.left, subRoot, currentNode.left) && isSubtree(root.right, subRoot, currentNode.right));
        }
        op2 = isSubtree(root.left, subRoot, subRoot);
        op3 = isSubtree(root.right, subRoot, subRoot);
        return (op1 || op2 || op3);
    }
    
    boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }
        if((root == null && subRoot != null) || (root != null && subRoot == null)) {
            return false;
        }
        if(root.val != subRoot.val) {
            return false;
        }
        boolean cond1 = isSameTree(root.left, subRoot.left);
        boolean cond2 = isSameTree(root.right, subRoot.right);
        return (cond1 && cond2);
    }
}