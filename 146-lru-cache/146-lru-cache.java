class LRUCache {

    class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class ListNode {
        Pair p;
        ListNode next;
        ListNode prev;

        ListNode(int key, int value) {
            this.p = new Pair(key, value);
            next = null;
            prev = null;
        }
    }


    int capacity;
    ListNode head;
    ListNode tail;
    Map<Integer,ListNode> keySet;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keySet = new HashMap<>();
        this.head = null;
        this.tail = null;
    }

    public int get(int key) {
        // this.printMap();
        if(!keySet.containsKey(key)) {
            return -1;
        }
        int value = keySet.get(key).p.value;
        this.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        ListNode kv = null;
        if(this.keySet.containsKey(key)) {
            kv = this.keySet.get(key);
            removeNode(kv);
        }
        kv = new ListNode(key, value);
        if (head != null) {
            kv.next = this.head;
            this.head.prev = kv;
        }
        this.head = kv;
        if(tail == null) {
            this.tail = kv;
        }

        this.updateKeyset(key, kv);

    }

    private void removeNode(ListNode ln) {
        ListNode prev = ln.prev;
        ListNode next = ln.next;
        if(this.head == ln) {
            this.head = next;
        }
        if (this.tail == ln) {
            this.tail = prev;
        }
        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }
        ln.next = null;
        ln.prev = null;
    }

    private void updateKeyset(int key, ListNode ln) {
        this.keySet.put(key, ln);
        if(keySet.size() > this.capacity) {
            ListNode nodeToRemove = removeFromTail();
            this.keySet.remove(nodeToRemove.p.key);
        }
        return;
    }

    private ListNode removeFromTail() {
        ListNode nodeToRemove = this.tail;
        ListNode newTail = this.tail.prev;
        this.tail.prev = null;
        if(newTail != null) {
            newTail.next = null;
        }
        this.tail = newTail;
        return nodeToRemove;
    }

    public void printMap() {
        System.out.println("----------------");
        for(Integer key: this.keySet.keySet()) {
            System.out.println("key -> " + key + " value -> " + this.keySet.get(key).p.value);
        }
        System.out.println("----------------");
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */