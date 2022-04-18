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
    int K = -1;
    TreeNode kthNode = null;
    public int kthSmallest(TreeNode root, int k) {
        K = k;
        inorder(root);
        return kthNode.val;
    }
    
    void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        K--;
        if(K == 0) {
           kthNode = root;
        }
        inorder(root.right);
    }
}