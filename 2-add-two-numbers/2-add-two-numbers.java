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
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode head = l1;
        ListNode prev = head;
        int carry = 0;
        int sum = 0;
        while(l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            l1.val = sum % 10;
            carry = sum / 10;
            
            prev = l1;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null) {
            sum = l1.val+ carry;
            l1.val = sum % 10;
            carry = sum / 10;
            
            prev = l1;
            l1 = l1.next;
        }
        
        if(l2 != null) {
            prev.next = l2;
        }
        
        while(l2 != null) {
            sum = l2.val+ carry;
            l2.val = sum % 10;
            carry = sum / 10;
            
            prev = l2;
            l2 = l2.next;
        }
        
        while(carry > 0) {
            sum = carry;
            prev.next = new ListNode(sum % 10);
            carry = sum / 10;
            
            prev = prev.next;
        }
        
        return head;
    }
}