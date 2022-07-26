/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayDeque<TreeNode> pPath = new ArrayDeque<>();
        ArrayDeque<TreeNode> qPath = new ArrayDeque<>();
        loadPath(root, p, pPath);
        loadPath(root, q, qPath);
        // printList(pPath);
        // printList(qPath);
        // System.out.println("------");
        return getLCA(pPath, qPath);
    }
    
    boolean loadPath(TreeNode root, TreeNode target, ArrayDeque<TreeNode> path) {
        if(root == null) {
            return false;
        }
        if(root == target) {
            path.push(root);
            return true;
        }
        boolean atLeft = loadPath(root.left, target, path);
        boolean atRight = loadPath(root.right, target, path);
        if(atLeft || atRight) {
            path.push(root);
        }
        return (atLeft || atRight);
    }
    
    TreeNode getLCA(ArrayDeque<TreeNode> p1, ArrayDeque<TreeNode> p2) {
        TreeNode lca = null;
        while((!p1.isEmpty() && !p2.isEmpty()) && (p1.peek() == p2.peek())) {
            lca = p1.poll();
            p2.poll();
        }
        return lca;
        
    }
    
    void printList(ArrayDeque<TreeNode> q) {
        for(TreeNode i: q) {
            System.out.print(i.val + " -> ");
        }
        System.out.println();
    }
}