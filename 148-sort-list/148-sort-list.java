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
    public ListNode sortList(ListNode head) {
        int listSize = getLength(head);
        // System.out.println("length -> " + listSize);
        if(listSize <= 1) {
            return head;
        }
        ListNode sortedSecHalf = sortList(getList(head, listSize / 2));
        ListNode sortedFirstHalf = sortList(head);
        return mergeList(sortedFirstHalf, sortedSecHalf);
        // return head;
        
    }
    
    int getLength(ListNode head) {
        int cnt = 0;
        ListNode tmp = head;
        // while(tmp != null) {
        //     cnt++;
        //     tmp = tmp.next;
        // }
        
        while(head != null) {
            cnt++;
            head = head.next;
        }
        return cnt;
    }
    
    ListNode getList(ListNode head, int length) {
        int cnt = 0;
        ListNode prev = null;
        while(cnt < length) {
            cnt++;
            prev = head;
            head = head.next;
        }
        prev.next = null;
        return head;
    }
    
    ListNode mergeList(ListNode ln1, ListNode ln2) {
        ListNode sortedListHead = null;
        ListNode otherListHead = null;
        // System.out.println("Merging ");
        // printList(ln1);
        // System.out.println("AND" );
        // printList(ln2);
        if(ln1.val <= ln2.val) {
            sortedListHead = ln1;
            otherListHead = ln2;
        } else {
            sortedListHead = ln2;
            otherListHead = ln1;
        }
        
        ListNode sortedListPrevPtr = sortedListHead;
        ListNode sortedListCurrentPtr = sortedListHead.next;
        ListNode otherListCurrentPtr = otherListHead;
        
        while(sortedListCurrentPtr != null && otherListCurrentPtr != null) {
            if(sortedListCurrentPtr.val <= otherListCurrentPtr.val) {
                sortedListPrevPtr = sortedListCurrentPtr;
                sortedListCurrentPtr = sortedListCurrentPtr.next;
            } else {
                ListNode tmp = otherListCurrentPtr;
                otherListCurrentPtr = otherListCurrentPtr.next;
                tmp.next = null;
                
                sortedListPrevPtr.next = tmp;
                tmp.next = sortedListCurrentPtr;
                sortedListPrevPtr = tmp;
            }
        }
        
        if(otherListCurrentPtr != null) {
            sortedListPrevPtr.next = otherListCurrentPtr;
        }
        
        // System.out.println("MERGED -> ");
        // printList(sortedListHead);
        // System.out.println("----------------------------------");
        
        return sortedListHead;
        
        
//         ListNode head = null;
//         ListNode nodeToAdd = null;
//         while(ln1 != null && ln2 != null) {
//             if(ln1.val > ln2.val) {
//                 head = addNode(head, ln2);
//                 ln2 = ln2.next;
//             } else {
//                 head = addNode(head, ln1);
//                 ln1 = ln1.next;
//             }
//         }
//         System.out.println("merging 1");
        
//         while(ln1 != null) {
//             head = addNode(head, ln1);
//             ln1 = ln1.next;
//         }
//         System.out.println("merging 2");
//         while(ln2 != null) {
//             head = addNode(head, ln2);
//             ln2 = ln2.next;
//         }
//         System.out.println("merging 3");
//         return head;
    }
    
    ListNode addNode(ListNode head, ListNode node) {
        if(head == null) {
            head = node;
            return head;
        }
        ListNode tmp = head;
        while(tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = node;
        return head;
    }
    
    void printList(ListNode ln1) {
        while(ln1 != null) {
            System.out.print(ln1.val + " --> ");
            ln1 = ln1.next;
        }
        System.out.println();
    }
}

/*


4 --> 2 --> 1 --> 3



*/