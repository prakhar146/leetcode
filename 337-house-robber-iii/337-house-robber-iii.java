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
    public int rob(TreeNode root) {
        Map<Pair, Integer> map = new HashMap<>();
        
        return rob(root, false, map);
    }
    
    int rob(TreeNode root, boolean skip, Map<Pair, Integer> map) {
        if(root == null) {
            return 0;
        }
        Pair p = new Pair(root, skip);
        // System.out.println(p);
        if(map.containsKey(p)) {
            // System.out.println("DP ");
            return map.get(p);
        }
        int op1 = -1;
        if(!skip) {
            op1 = root.val + rob(root.left, true, map) + rob(root.right, true, map);
        }
        int op2 = rob(root.left, false, map) + rob(root.right, false, map);
        int ans = Math.max(op1, op2);
        map.put(p, ans);
        return ans;
    }
    
    class Pair {
        TreeNode node;
        boolean b;
        
        Pair(TreeNode tn, boolean b) {
            node = tn;
            this.b = b;
        }
        
        public String toString() {
            return (node.val + " b -> " + b);
        }
        
        public int hashCode() {
            // System.out.println("HashCode called");
            return (node.hashCode() + (b ? 1 : 0));
        }
        
        public boolean equals(Object o) {
            Pair p = (Pair) o;
            return (p.node.equals(node) && p.b == this.b);
        }
    }
}