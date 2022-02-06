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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1, ListNode l2) {
                if(l1.val < l2.val) {
                    return -1;
                } else if (l1 == l2) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        
        for(ListNode ln: lists) {
            if(ln != null) {
                pq.add(ln);
            }
        }
        
        ListNode sortedListHead = null;
        ListNode currentNode = null;
        
        while(!pq.isEmpty()) {
            ListNode top = pq.poll();
            if(sortedListHead == null) {
                sortedListHead = top;
                currentNode = sortedListHead;
            } else {
                currentNode.next = top;
                currentNode = currentNode.next;
            }
            if(top.next != null) {
                pq.add(top.next);
            }
        }
        
        return sortedListHead;
        
    }
}