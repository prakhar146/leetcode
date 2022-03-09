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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode newHead = new ListNode(-1001);
        ListNode dPtr = newHead;
        ListNode pPtr = null;
        ListNode cPtr = head;
        ListNode nPtr = head.next;
        
        while(nPtr != null) {
            if((cPtr.val != nPtr.val) && (pPtr == null || (cPtr.val != pPtr.val))) {
                dPtr.next = cPtr;
                dPtr = dPtr.next;
            }
            pPtr = cPtr;
            cPtr = nPtr;
            nPtr = nPtr.next;
        }
        
        if(pPtr == null || (cPtr.val != pPtr.val)) {
                dPtr.next = cPtr;
                dPtr = dPtr.next;
        } else {
            dPtr.next = null;
        }
        
        return newHead.next;
    }
}