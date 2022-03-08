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
    public boolean hasCycle(ListNode head) {
        ListNode ptr = head;
        ListNode fastPtr = null;
        if(head != null && head.next != null) {
            fastPtr = head.next.next;
        } else {
            return false;
        }
        while(ptr != null && fastPtr != null && ptr != fastPtr) {
            ptr = ptr.next;
            fastPtr = fastPtr.next;
            if(fastPtr != null) {
                fastPtr = fastPtr.next;
            }
        }
        
        if(ptr == null || fastPtr == null) {
            return false;
        }
        return true;
    }
}