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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder);
    }
    
    TreeNode build(int[] preorder, int[] inorder) {
        if(preorder.length == 0) {
            return null;
        }
        int val = preorder[0];
        TreeNode root = new TreeNode(val);
        int inorderIdx = getIdx(val, inorder);
        // System.out.println("pre " + Arrays.toString(preorder) + " ino " + Arrays.toString(inorder) + " val -> " + val + " idx -> " + inorderIdx);
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, inorderIdx);
        int[] inorderRight = Arrays.copyOfRange(inorder, inorderIdx + 1, inorder.length);
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, inorderIdx + 1);
        int[] preorderRight = Arrays.copyOfRange(preorder, inorderIdx + 1, preorder.length);
        root.left = build(preorderLeft, inorderLeft);
        root.right = build(preorderRight, inorderRight);
        
        return root;
        
    }
    
    int getIdx(int num, int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == num) {
                return i;
            }
        }
        return -1;
    }
}

/*

3, 9, 20, 15, 7


9, 3, 15, 20, 7

*/