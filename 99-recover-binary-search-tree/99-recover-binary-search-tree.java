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
    TreeNode firstIncorrect = null;
    TreeNode secondIncorrect = null;
    TreeNode prevNode = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        inorder(root);
        
        int tmp = firstIncorrect.val;
        firstIncorrect.val = secondIncorrect.val;
        secondIncorrect.val = tmp;
        
    }
    
    void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        if(firstIncorrect == null && prevNode.val > root.val) {
            // First incorrect will always be a false greater
            firstIncorrect = prevNode;
        }
        if(firstIncorrect != null && prevNode.val > root.val) {
            secondIncorrect = root;
        }
        prevNode = root;
        inorder(root.right);
    }
}