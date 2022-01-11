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
        Map<TreeNode, Integer> diameter = new HashMap<>();
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        if (diameter.containsKey(root)) {
            return diameter.get(root);
        }
        int diameterLeft = diameterOfBinaryTree(root.left);
        int diameterRight = diameterOfBinaryTree(root.right);
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int diameterCurrent = (leftHeight > -1 ? leftHeight + 1 : 0) + (rightHeight > -1 ? rightHeight + 1 : 0);
        // System.out.println("root -> " + root.val + " nodes -> " + getNodes(root));
        int ans = Math.max(diameterCurrent, Math.max(diameterLeft, diameterRight));
        diameter.put(root, ans);
        return ans;
    }

    public int getNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int nodesLeft = getNodes(root.left);
        int nodesRight = getNodes(root.right);
        return 1 + Math.max(nodesLeft, nodesRight);
    }

    int getHeight(TreeNode root) {
        if(root == null) {
            return -1;
        }
        if(root.left == null && root.right == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}