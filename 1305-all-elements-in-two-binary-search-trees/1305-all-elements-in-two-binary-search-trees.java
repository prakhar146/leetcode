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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inOrderTraversal(root1, list1);
        inOrderTraversal(root2, list2);
        
        // System.out.println(Arrays.toString(list1.toArray()));
        // System.out.println(Arrays.toString(list2.toArray()));
        
        return mergeIntoSortedList(list1, list2);
    }
    
    void inOrderTraversal(TreeNode root, List<Integer> inOrderList) {
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left, inOrderList);
        inOrderList.add(root.val);
        inOrderTraversal(root.right, inOrderList);
    }
    
    List<Integer> mergeIntoSortedList(List<Integer> l1, List<Integer> l2) {
        List<Integer> mergedList = new ArrayList<>();
        
        int leftPtr = 0, rightPtr = 0;
        
        while(leftPtr < l1.size() && rightPtr < l2.size()) {
            if(l1.get(leftPtr) <= l2.get(rightPtr)) {
                mergedList.add(l1.get(leftPtr));
                leftPtr++;
            } else {
                mergedList.add(l2.get(rightPtr));
                rightPtr++;
            }
        }
        
        while(leftPtr < l1.size()) {
            mergedList.add(l1.get(leftPtr));
            leftPtr++;
        }
        
        while(rightPtr < l2.size()) {
            mergedList.add(l2.get(rightPtr));
            rightPtr++;
        }
        
        return mergedList;
    }
}