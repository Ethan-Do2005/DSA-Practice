class LRUCache {
    //Step 1: Node Structure
    class Node{
        int key;
        int value;

        Node prev;
        Node next;
        Node(int k, int v){
            key = k;
            value = v;
        }
    }

    //Step 3: variable outside
    private final int capacity;
    private Map<Integer, Node> map = new HashMap<>();
    private final Node head = new Node(-1,-1);
    private final Node tail = new Node(-1,-1);

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
    
    public void put(int key, int value) {
        Node n = map.get(key);

        //Exists key
        if(n != null){
            n.value = value;
            moveToHead(n);
            return;
        }

        // Not exists
        Node node = new Node(key, value);
        map.put(key, node);
        addToHead(node);

        //Check size
        if(map.size() > capacity){
            Node lru = removeTail();
            map.remove(lru.key);
        }
    }

    //Step 2: Helper method
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
/*
5 Steps:
Step 1: Node Structure
Step 2: Helper method 
Step 3: 
*/

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */