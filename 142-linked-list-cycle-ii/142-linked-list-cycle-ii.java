/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode ptr = head.next;
        ListNode fastPtr = (head.next != null) ? head.next.next : null;
        
        while(fastPtr != null && fastPtr != ptr) {
            ptr= ptr.next;
            fastPtr = (fastPtr != null) ? ((fastPtr.next != null) ? fastPtr.next.next : fastPtr.next): fastPtr;
        }
        
        if(fastPtr == null) {
            return null;
        }
        ListNode startPtr = head;
        int cnt = 0;
        while(startPtr != ptr) {
            startPtr = startPtr.next;
            ptr = ptr.next;
            cnt++;
        }
        return startPtr;
    }
}