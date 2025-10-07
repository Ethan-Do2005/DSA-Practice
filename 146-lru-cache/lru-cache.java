class LRUCache {
    //Step 1: Node structure
    private static class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(int k, int v){
            key = k;
            value = v;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map = new HashMap<>();
    private final Node head = new Node(-1, -1);
    private final Node tail = new Node(-1, -1);
    
    //Form this method in double linked list
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if(n == null) return -1;
        moveToHead(n);
        return n.value;
    }
/*
Get method:
Using HashMap to check exist key or not
Return key;
Reutnr -1;
*/
    public void put(int key, int value) {
        Node n = map.get(key);
        // 3 Steps:
        // Step 1: check exits that key already?
        if(n != null){
            n.value = value;
            moveToHead(n);
            return;
        }

        Node node = new Node(key, value);
        map.put(key, node);
        addToHead(node);

        if(map.size() > capacity){
            Node lru = removeTail();
            map.remove(lru.key);
        }        
    }
/*
Put method:
Using HashMap to add into with key and value 
Based on capacity
*/

/*
We also needd Double Linked List to make sure that which of pair key-value we will remove

*/
// Helper method in Double LinkedList
private void addToHead(Node n){
    n.prev = head;
    n.next = head.next;
    head.next.prev = n;
    head.next = n;
}
private void removeNode(Node n){
    n.prev.next = n.next;
    n.next.prev = n.prev;
}
private void moveToHead(Node n){
    removeNode(n);
    addToHead(n);
}
private Node removeTail(){
    Node lru = tail.prev;
    removeNode(lru);
    return lru;
}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */