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
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        // System.out.println("call -> " + root.val + " minRo -> " + minRoot + " maxRo -> " + maxRoot);
        if(root == null) {
            return true;
        }
        if(((long) root.val <= minValue) || ((long)root.val >= maxValue)) {
            return false;
        }
        
        boolean cond1 = false, cond2 = false;
        cond1 = isValidBST(root.left, minValue, (long) root.val);
        cond2 = isValidBST(root.right, (long) root.val, maxValue);
        return (cond1 && cond2);
    }
}