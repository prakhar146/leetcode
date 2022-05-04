class LRUCache {
    class Node {
        int key;
        int val;
        Node next;
        Node prev;
        
        Node(int k, int v) {
            this.key = k;
            this.val = v;
            this.next = null;
            this.prev = null;
        }
    }
    
    class DoublyList {
        Node head;
        Node tail;
        
        DoublyList() {
            this.head = null;
            this.tail = null;
        }
        
        public Node delete(Node n) {
            Node prev = n.prev;
            Node next = n.next;
            
            if(prev != null) {
                prev.next = next;
            }
            if(next != null) {
                next.prev = prev;
            }
            if(head == n) {
                head = next;
            }
            if(tail == n) {
                tail = prev;
            }
            return n;
        }
        
        public Node delete() {
            Node tmp = this.head;
            this.head = this.head.next;
            if(this.head != null) {
                this.head.prev = null;   
            }
            if(this.tail == tmp) {
                this.tail = null;
            }
            tmp.next = null;
            return tmp;
        }
        
        public void add(Node n) {
            if(tail == null || head == null) {
                this.head = n;
                this.tail = n;
                return;
            }
            this.tail.next = n;
            n.prev = this.tail;
            this.tail = n;
        }
    }
    
    class Pair {
        int key;
        Node n;
        
        Pair(int k, Node n) {
            this.key = k;
            this.n = n;
        }
    }
    
    private Map<Integer, Node> hm;
    private DoublyList dl;
    private int capacity;

    public LRUCache(int capacity) {
        hm = new HashMap<>();
        dl = new DoublyList();
        this.capacity = capacity;
        // cache = new LinkedList<>();
    }
    
    public int get(int key) {
        // System.out.println("Getting " + key);
        if(hm.containsKey(key)) {
            refreshNode(key, hm.get(key).val, hm.get(key));
            return hm.get(key).val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        // System.out.println("Putting " + key);
        if(hm.containsKey(key)) {
            refreshNode(key, value, hm.get(key));
        } else {
            if(hm.size() == capacity) {
                pop();   
            }
            Node toPut = new Node(key, value);
            dl.add(toPut);
            this.hm.put(key, toPut);
        }
    }
    
    
    private void refreshNode(int key, int value, Node n) {
        Node toPop = dl.delete(n);
        Node toUpdate = new Node(key, value);
        this.hm.put(key, toUpdate);
        dl.add(toUpdate);
    }
    
    private void pop() {
        Node toPop = dl.delete();
        int keyToPop = toPop.key;
        this.hm.remove(keyToPop);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */