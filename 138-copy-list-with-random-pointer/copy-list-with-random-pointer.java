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

        //Step 1 
        Node curr = head;
        while(curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        //Step 2
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next; // A' -> C'
            }

            curr = curr.next.next;
        }

        //Step 3:
        curr = head;
        Node dummy = new Node(0);
        Node node = dummy;
        while(curr != null){
            Node copy = curr.next;
            Node nextOri = copy.next;

            node.next = copy;
            node = copy;

            curr.next = nextOri;
            curr = nextOri;
        }

        return dummy.next;
    }
}
/*
3 step
Step 1: Fake Node A -> A' -> B -> B'
Step 2: poin fake random to another fake pointer
Step 3: seperate A' into new ListNode

*/