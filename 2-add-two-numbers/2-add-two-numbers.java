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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int currentSum = l1.val + l2.val;
        int nodeVal = currentSum % 10;
        int carry = currentSum / 10;
        ListNode head = new ListNode(nodeVal);
        ListNode firstNode = head;
        
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null && l2 != null) {
            currentSum = l1.val + l2.val + carry;
            nodeVal = currentSum % 10;
            carry = currentSum / 10;
            
            head.next = new ListNode(nodeVal);
            head = head.next;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null) {
            currentSum = l1.val + carry;
            nodeVal = currentSum % 10;
            carry = currentSum / 10;
            
            head.next = new ListNode(nodeVal);
            head = head.next;
            
            l1 = l1.next;
        }
        
        while(l2 != null) {
            currentSum = l2.val + carry;
            nodeVal = currentSum % 10;
            carry = currentSum / 10;
            
            head.next = new ListNode(nodeVal);
            head = head.next;
            
            l2 = l2.next;
        }
        
        while (carry > 0) {
            currentSum = carry;
            nodeVal = currentSum % 10;
            carry = currentSum / 10;
            
            head.next = new ListNode(nodeVal);
            head = head.next;
        }
        
        return firstNode;
    }
}