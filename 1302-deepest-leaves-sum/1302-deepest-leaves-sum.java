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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        List<Integer> sum = new ArrayList<>();
        int level = 0;
        
        while(!nodes.isEmpty()) {
            int nodesAtThisLevel = nodes.size();
            for(int i = 0; i < nodesAtThisLevel; i++) {
                TreeNode node = nodes.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;
            
                if(left != null) {
                    nodes.add(left);
                }
                if(right != null) {
                    nodes.add(right);
                }
                if(level >= sum.size()) {
                    sum.add(node.val);
                } else {
                    int currentSum = sum.get(level);
                    currentSum += node.val;
                    sum.set(level, currentSum);
                }
            }
            level++;
        }
        
        // System.out.println(sum);
        return sum.get(sum.size() - 1);
    }
}
/*
1
2,3
*/