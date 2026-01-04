class LRUCache {
    //Step 1: Node structure
    class Node{
        int value, key;

        Node prev;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> map = new HashMap<>();
    private int capacity;
    private Node head = new Node(0,0);
    private Node tail = new Node(0,0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!(map.containsKey(key))){
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        addToFront(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        
        //If key exits and just update the value
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            remove(node);
            addToFront(node);
            return;
        }

        Node newNode = new Node(key,value);
        map.put(key, newNode);
        addToFront(newNode);

        if(map.size() > capacity){
            Node lru = tail.prev;   // Least recently used
            remove(lru);
            map.remove(lru.key);
        }
    }

    //Helper method for DLL
    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToFront(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
/*
Using HashMap + Doubly Linked List 
HashMap for O(1) in Get and Put
DLL for O(1) Find least used and Track Usage Order
4 steps total:
Step 1: Node structure  
*/
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */