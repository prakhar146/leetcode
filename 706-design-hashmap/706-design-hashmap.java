class MyHashMap {
    
    class HashNode {
        int key;
        int value;
        HashNode prev;
        HashNode next;
        
        HashNode(int k, int v) {
            this.key = k;
            this.value = v;
            prev = null;
            next = null;
        }
    }
    
    class HashNodeList {
        HashNode head;
        HashNode tail;
        
        HashNodeList() {
            head = null;
            tail = null;
        }
        
        public void addNode(HashNode hn) {
            // replace if present
            // HashNode tmpHead = this.head;
            // while(tmpHead != null) {
            //     if(tmphead.key == hn.key) {
            //         tmpHead.value = hn.value;
            //         return;
            //     }
            //     tmpHead = tmpHead.next;
            // }
            HashNode tmpNode = getNode(hn.key);
            if(tmpNode != null) {
                tmpNode.value = hn.value;
                return;
            }
            
            // add if absent
            this.tail.next = hn;
            hn.prev = this.tail;
            this.tail = this.tail.next;
        }
        
        public HashNode getNode(int key) {
            HashNode tmpHead = this.head;
            while(tmpHead != null) {
                if(tmpHead.key == key) {
                    // tmpHead.value = hn.value;
                    if(tmpHead.value == 725) {
                        System.out.println(" --- KEY " + tmpHead.key);
                    }
                    return tmpHead;
                }
                tmpHead = tmpHead.next;
            }
            return null;
        }
        // 725
        public void deleteNode(int key) {
            HashNode tmpHead = this.head;
            while(tmpHead != null) {
                if(tmpHead.key == key) {
                    break;
                    // tmpHead.value = hn.value;
                    // if(tmpHead.value == 725) {
                    //     System.out.println(" --- KEY " + tmpHead.key);
                    // }
                    // return tmpHead;
                }
                tmpHead = tmpHead.next;
            }
            // System.out.println("-------------------");
            // printList();
            // System.out.println("REMOVING " + key);
            if(tmpHead == null) {
                return;
            }
            HashNode prevNode = tmpHead.prev;
            HashNode nextNode = tmpHead.next;
            if(prevNode == null && nextNode == null) {
                this.head = null;
                this.tail = null;
            }
            if(prevNode != null) {
                tmpHead.prev.next = nextNode;
                // prevNode.next = 
                if(nextNode == null) {
                    this.tail = prevNode;
                }
            }
            if(nextNode != null) {
                tmpHead.next.prev = prevNode;
                // nextNode.prev = prevNode;
                if(prevNode == null) {
                    this.head = nextNode;
                }
            }
            // tmpHead.prev = null;
            // tmpHead.next = null;
            // printList();
            // System.out.println("-----------------");
        }
        
        public void printList() {
        // HashNode hn = hnl.head;
        HashNode tmpNode = this.head;
        while(tmpNode != null) {
            System.out.print("k: " + tmpNode.key + ", v: "  + tmpNode.value + ", ");
            tmpNode = tmpNode.next;
        }
        System.out.println();
    }
    }
    
    int size = 100;
    HashNodeList[] hashNodeList;

    public MyHashMap() {
        hashNodeList = new HashNodeList[size];
    }
    
    public void put(int key, int value) {
        int hashValue = key % size;
        HashNode newNode = new HashNode(key, value);
        // System.out.println("Inserting k: " + key + " value: " + value);
        HashNodeList hnl = hashNodeList[hashValue];
        if(hnl == null) {
            hnl = new HashNodeList();
            hnl.head = newNode;
            hnl.tail = newNode;
            hashNodeList[hashValue] = hnl;
        } else {
            hnl.addNode(newNode);
        }
        // printList(hnl);
    }
    
    public int get(int key) {
        int hashValue = key % size;
        HashNodeList hnl = hashNodeList[hashValue];
        if(hnl == null) {
            // System.out.println("Fetching " + key + " NULL");
            return -1;
        } else {
            // System.out.println("Fetching " + key);
            // printList(hnl);
            HashNode hn = hnl.getNode(key);
            if(hn == null) {
                // System.out.println("NOT FOUND");
                // System.out.println("-----------");
                return -1;
            } else {
                // System.out.println("MATCH");
                // System.out.println("-----------");
                return hn.value;
            }
        }
    }
    
    public void remove(int key) {
        int hashValue = key % size;
        HashNodeList hnl = hashNodeList[hashValue];
        if(hnl == null) {
            return;
        } else {
            hnl.deleteNode(key);
            if(hnl.head == null) {
                hashNodeList[hashValue] = null;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */