/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        
        Map<Node, Node> oldToNewNode = new HashMap();
        
        
        // Node copyHead = new Node(head.val);
        // oldToNewNode.set(head, copyHead);
        // Node copyListPtr = copyHead;
        
        Node copyHead = new Node(-1);
        Node copyListPtr = copyHead;
        // copyHead.next = copyListPtr;
        
        // Node nextNode = head.next;
        // Node randNode = head.random;

        // if(nextNode != null) {
        //     if(oldToNewNode.containsKey(nextNode)) {
        //         copyListPtr.next = oldToNewNode.get(nextNode);
        //         copyListPtr = copyListPtr.next;
        //     } else {
        //         oldToNewNode.set(nextNode, new Node(nextNode.val));
        //     }
        // }
        
        while(head != null) {
            if(!oldToNewNode.containsKey(head)) {
                 oldToNewNode.put(head, new Node(head.val));
            }
            copyListPtr.next = oldToNewNode.get(head);
            copyListPtr = copyListPtr.next;
            Node randNode = head.random;
            if(randNode != null) {
                if(!oldToNewNode.containsKey(randNode)) {
                    oldToNewNode.put(randNode, new Node(randNode.val));
                }
                copyListPtr.random = oldToNewNode.get(randNode);
            }
            // printList(copyHead.next);
            head = head.next;
            // Node nextNode = head.next;
            // if(nextNode != null) {
            //     copyListPtr.next = new Node(nextNode.);
            // }
        }

        return copyHead.next;
    }
    void printList(Node head) {
        System.out.println("-----PRINTING LIST------");
        while(head != null) {
            System.out.println(head + " val " + head.val + " next -> " + (head.next != null ? head.next.val : null) + " random -> " + " address " + head.random + " val -> " +(head.random != null ? head.random.val : null));
            head = head.next;
        }
    }
}