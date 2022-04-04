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
    public ListNode swapNodes(ListNode head, int k) {
        int size = getListLength(head);
        if(size < 2) {
            return head;
        }
        int ptr1 = k;
        int ptr2 = (size + 1 - k);
        
        int ptr = 1;
        ListNode n1 = null;
        ListNode n2 = null;
        ListNode n = head;
        System.out.println("ptr1 -> " + ptr1 + " ptr2 -> " + ptr2);
        while(n != null) {
            if(ptr == ptr1) {
                n1 = n;
            }
            if(ptr == ptr2) {
                n2 = n;
            }
            n = n.next;
            ptr++;
        }
        swapValues(n1, n2);
        return head;
    }
    
    int getListLength(ListNode head) {
        int cnt = 0;
        while(head != null) {
            head = head.next;
            cnt++;
        }
        return cnt;
    }
    
    void swapValues(ListNode n1, ListNode n2) {
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }
}