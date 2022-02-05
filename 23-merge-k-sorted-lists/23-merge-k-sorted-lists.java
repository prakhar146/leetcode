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
    
    class Heap {
        private List<ListNode> heap;
        
        Heap() {
            this.heap = new ArrayList();
            heap.add(new ListNode(Integer.MIN_VALUE));
        }
        
        private void bubbleUp() {
            int idx = this.heap.size() - 1;
            
            while(hasParent(idx) && (getParent(idx).val > heap.get(idx).val)) {
                Collections.swap(this.heap, idx, idx / 2);
                idx = idx / 2;
            }
        }
        
        private void bubbleDown(){
            int idx = 1;
            while((hasLeftChild(idx) && leftChild(idx).val < heap.get(idx).val) ||
                 (hasRightChild(idx) && rightChild(idx).val < heap.get(idx).val)) {
                if(hasLeftChild(idx) && hasRightChild(idx)) {
                    if(leftChild(idx).val < rightChild(idx).val) {
                        Collections.swap(this.heap, idx, 2 * idx);
                        idx = 2 * idx;
                    } else {
                        Collections.swap(this.heap, idx, (2 * idx) + 1);
                        idx = (2 * idx) + 1;
                    }
                } else if (hasLeftChild(idx)) {
                    Collections.swap(this.heap, idx, 2 * idx);
                    idx = 2 * idx;
                } else {
                    Collections.swap(this.heap, idx, (2 * idx) + 1);
                    idx = (2 * idx) + 1;
                }
//                 if(hasLeftChild(idx) && (leftChild(idx).val < heap.get(idx).val)) {
                    
//                 }
//                 if(hasRightChild(idx) && (rightChild(idx).val < heap.get(idx).val)) {
//                     Collections.swap(this.heap, idx, (2 * idx) + 1);
//                     idx = (2 * idx) + 1;
//                 }
            }
            
        }
        
        private boolean hasLeftChild(int idx) {
            int leftIdx = 2 * idx;
            return leftIdx < this.heap.size();
        }
        
        private boolean hasRightChild(int idx) {
            int rightIdx = (2 * idx) + 1;
            return rightIdx < this.heap.size();
        }
        
        private ListNode leftChild(int idx) {
            int leftIdx = 2 * idx;
            return this.heap.get(leftIdx);
        }
        
        private ListNode rightChild(int idx) {
            int rightIdx = (2 * idx) + 1;
            return this.heap.get(rightIdx);
        }
        
        private boolean hasParent(int idx) {
            return idx > 0;
        }
        
        private ListNode getParent(int idx) {
            return heap.get(idx / 2);
        }
        
        public void add(ListNode ln) {
            if(ln != null) {
                this.heap.add(ln);
                bubbleUp();
            }
        }
        
        public boolean isEmpty() {
            return this.heap.size() == 1;
        }
        
        public ListNode peek() {
            return heap.get(1);
        }
        
        public void removeTop() {
            ListNode topNode = peek();
            ListNode next = topNode.next;
            if(next != null) {
                this.heap.set(1, topNode.next);
                bubbleDown();
            } else {
                ListNode tmp = this.heap.get(this.heap.size() - 1);
                this.heap.set(1, tmp);
                bubbleDown();
                this.heap.remove(this.heap.size() - 1);   
            }
        }
        
        public ListNode poll() {
            ListNode topNode = peek();
            removeTop();
            return topNode;
        }
        
        public void printHeap() {
            System.out.print("[");
            for (ListNode o: this.heap) {
                System.out.print(o.val + ", ");
            }
            System.out.println("]");
        }
    }
    
    
    public ListNode mergeKLists(ListNode[] lists) {
        Heap nodeHeap = new Heap();
        // nodeHeap.printHeap();
        for(ListNode ln: lists) {
            nodeHeap.add(ln);
            // nodeHeap.printHeap();
        }
        if(nodeHeap.isEmpty()) {
            return null;
        }
        // nodeHeap.printHeap();
        ListNode sortedListHead = new ListNode(nodeHeap.poll().val);
        ListNode currentListNode = sortedListHead;
        // System.out.println("--------------------");
        // nodeHeap.printHeap();
        
        while(!nodeHeap.isEmpty()) {
            currentListNode.next = new ListNode(nodeHeap.poll().val);
            // nodeHeap.printHeap();
            currentListNode = currentListNode.next;
        }
        
        return sortedListHead;
    }
}