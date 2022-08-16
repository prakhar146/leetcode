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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode currNode = head;
        ListNode nNode = currNode;
        for(int i = 0; i < n; i++) {
            nNode = nNode.next;
        }
        ListNode prevNode = null;
        while(nNode != null) {
            prevNode = currNode;
            currNode = currNode.next;
            nNode = nNode.next;
        }
        if(prevNode == null) {
            return head.next;
        }
        prevNode.next = currNode.next;
        currNode.next = null;
        currNode = null;
        return head;
    }
}