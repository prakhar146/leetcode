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
    private TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, Boolean> visitedNodes = new HashMap<>();
        lca = null;
        visitNode(root, p, visitedNodes);
        // printMap(visitedNodes);
        // System.out.println("-----------------------");
        visitNode(root, q, visitedNodes);
        // printMap(visitedNodes);
        
        return lca;
    }
    
    boolean visitNode(TreeNode root, TreeNode targetNode, Map<TreeNode, Boolean> visitedNode) {
        if(root == targetNode) {
            if(visitedNode.containsKey(root) && lca == null) {
                lca = root;
                // System.out.println("lca -> " + lca.val);
            }
            visitedNode.put(root, true);
            // if(visitedNode.containsKey(root)) {
            // lca = root;
            // // System.out.println("lca -> " + lca.val);
            // }
           return true; 
        }
        if(root == null) {
            return false;
        }
        
        // visitedNode.put(root, true);
        boolean isCorrect = visitNode(root.left, targetNode, visitedNode);
        if(!isCorrect) {
            isCorrect = visitNode(root.right, targetNode, visitedNode);
        }
        if(isCorrect) {
            if(visitedNode.containsKey(root) && lca == null) {
                lca = root;
                // System.out.println("lca -> " + lca.val);
            }
            visitedNode.put(root, true);
        }
//         if(!isCorrect) {
//             visitedNode.remove(root);
//         } else {
            
//         }
        return isCorrect;
    }
    
    void printMap(Map<TreeNode, Boolean> visitedNodes) {
        System.out.println("-----------------------");
        for(TreeNode tn: visitedNodes.keySet()) {
            System.out.println("node -> " + tn.val);
        }
    }
}