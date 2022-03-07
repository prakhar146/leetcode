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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        
        ListNode mergedListHead = null;
        ListNode mergedListPtr = null;
        ListNode mergedListPrevHead = null;
        ListNode otherListHead = null;
        if(list1.val > list2.val) {
            mergedListHead = list2;
            otherListHead = list1;
        } else {
            mergedListHead = list1;
            otherListHead = list2;
        }
        mergedListPrevHead = mergedListHead;
        mergedListPtr = mergedListHead.next;
        while(mergedListPtr != null && otherListHead != null) {
            if(mergedListPtr.val > otherListHead.val) {
                ListNode tmp = otherListHead;
                otherListHead = otherListHead.next;
                
                mergedListPrevHead.next = tmp;
                tmp.next = mergedListPtr;
                mergedListPrevHead = tmp;
            } else {
                mergedListPrevHead = mergedListPtr;
                mergedListPtr = mergedListPtr.next;
            }
        }
        
        if(otherListHead != null) {
            mergedListPrevHead.next = otherListHead;
        }
        
        return mergedListHead;
    }
}