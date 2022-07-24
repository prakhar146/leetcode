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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelTraversal = new ArrayList<>();
        if(root == null) {
            return levelTraversal;
        }
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        while(!q.isEmpty()) {
            int totalNodesAtLevel = q.size();
            List<Integer> nodesAtLevel = new ArrayList<>();
            for(int i = 0; i < totalNodesAtLevel; i++) {
                TreeNode currentNode = q.poll();
                nodesAtLevel.add(currentNode.val);
                TreeNode left = currentNode.left;
                if(left != null) {
                    q.offer(left);
                }
                TreeNode right = currentNode.right;
                if(right != null) {
                    q.offer(right);
                }
            }
            levelTraversal.add(nodesAtLevel);
        }
        
        return levelTraversal;
    }
}