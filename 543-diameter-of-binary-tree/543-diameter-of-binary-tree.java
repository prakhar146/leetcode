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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return diameter;
    }
    
    int getHeight(TreeNode root) {
        if(root == null) {
            return -1;
        }
        if((root.left == null && root.right == null)) {
            return 0;
        }
        int leftH = 1 + getHeight(root.left);
        int rightH = 1 + getHeight(root.right);
        diameter = Math.max(diameter, (rightH + leftH));
        return Math.max(leftH, rightH);
    }
}