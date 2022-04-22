class MyHashSet {

    class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        
        ListNode(int v) {
            this.val = v;
            this.next = null;
            this.prev = null;
        }
    }
    
    class HashList {
        ListNode head;
        ListNode tail;
        
        HashList() {
            this.head = new ListNode(-1);
            this.tail = this.head;
        }
    }
    

    HashList[] hashList;
    
    public MyHashSet() {
        hashList = new HashList[10];
    }
    
    public void add(int key) {
        if(contains(key)) {
            return;
        }
        // System.out.println("Adding " + key);
        int idx = key % 10;
        HashList hl = hashList[idx];
        if(hl == null) {
            hashList[idx] = new HashList();
            hl = hashList[idx];
        }
        hl.tail.next = new ListNode(key);
        ListNode newNode = hl.tail.next;
        newNode.prev = hl.tail;
        hl.tail = newNode;
        // printList(idx);
    }
    
    public void remove(int key) {
        int idx = key % 10;
        HashList hl = hashList[idx];
        if(hl == null) {
            return;
        }
        ListNode tmpHead = hl.head;
        if(tmpHead == null) {
            return;
        }
        ListNode prevNode = null;
        ListNode nextNode = null;
        ListNode newTail = null;
        while(tmpHead != null) {
            if(tmpHead.val == key) {
                prevNode = tmpHead.prev;
                nextNode = tmpHead.next;
                prevNode.next = nextNode;
                if(nextNode != null) {
                    nextNode.prev = prevNode;
                }
                newTail = tmpHead;
                tmpHead = prevNode;
            } else {
                newTail = tmpHead;
                tmpHead = tmpHead.next;   
            }
        }
    
        hl.tail = newTail;
        // tmpHead = null;
    }
    
    public boolean contains(int key) {
        // System.out.println("---------------");
        // System.out.println("Searching for " + key);
        int idx = key % 10;
        // printList(idx);
        HashList hl = hashList[idx];
        if(hl == null) {
            // System.out.println("NULL for idx " + idx);
            // System.out.println("---------------");
            return false;
        }
        ListNode head = hl.head;
        // System.out.println("Searching " + key + " in ");
        // printList(idx);
        // System.out.println("------------");
        while(head != null) {
            if(head.val == key) {
                // System.out.println("MATCH -------");
                return true;
            }
            head = head.next;
        }
        // System.out.println("NO MATCH -------");
        return false;
    }
    
    void printList(int idx) {
        HashList hl = hashList[idx];
        if(hl == null) {
            System.out.println("NULL for idx " + idx);
            return;
        }
        System.out.print("idx -> " + idx + " : -> ");
        ListNode tmp = hl.head;
        while(tmp != null) {
            System.out.print(tmp.val + ", ");
            tmp = tmp.next;
        }
        System.out.println();
        return;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */