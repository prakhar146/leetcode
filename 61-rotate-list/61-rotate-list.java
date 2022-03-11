/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int listLength = getListLength(head);
        if(listLength < 1) {
            return head;
        }
        int modK = k % listLength;
        
        int noOfUnchangedElements = listLength - modK;
        if(noOfUnchangedElements == 0 || modK == 0) {
            return head;
        }
        int n = 1;
        ListNode ptr = head;
        while(n < noOfUnchangedElements) {
            ptr = ptr.next;
            n++;
        }
        
        ListNode rotatedListHead = ptr.next;
        ListNode rotatedListPtr = rotatedListHead;
        ptr.next = null;
        
        while(rotatedListPtr.next != null) {
            rotatedListPtr = rotatedListPtr.next;
        }
        rotatedListPtr.next = head;
        return rotatedListHead;
        
    }
    
    int getListLength(ListNode head) {
        int len = 0;
        while(head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}