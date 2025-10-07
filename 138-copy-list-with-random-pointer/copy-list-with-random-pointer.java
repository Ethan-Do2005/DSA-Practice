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
        if(head == null) return null;

        // Step 1: Create Node's copy
        Node curr = head;
        while(curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }
        // A -> A' -> B -> B' -> C -> C'

        // Step 2: Pointer fake randon node
        // Want to make for ex: A' -> C'
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next; // A' -> C-
                //curr.next.random: the copy of node random (pointer of A' - pointer A.random)
                // curr.random.next: the random of original node 
            }
            curr = curr.next.next;
        }

        Node dummy = new Node(0);
        Node node = dummy; 
        curr = head;
        while(curr != null){
            Node copy = curr.next;
            Node nextOri = copy.next;

            node.next = copy;
            node = copy;

            curr.next = nextOri;
            curr= nextOri;
        }

        return dummy.next;
    }
}
/*
My idea:
3 Total Steps:
Step 1: Create Fake Node with Node'
Step 2: Node'.random = Node1' 
Step 3: new List Node (just get fake node)
*/