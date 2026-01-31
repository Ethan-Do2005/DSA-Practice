class LRUCache {
    
    class Node{
        int value, key;

        Node next;
        Node prev;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        addToFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            remove(node);
            addToFront(node);
            return;
        }

        Node newNode = new Node(key, value);
        addToFront(newNode);
        map.put(key, newNode);

        if(map.size() > capacity){
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
    }

    //Helper function DLL
    private void remove(Node node){
        node.next.prev = node.prev; 
        node.prev.next = node.next;
    }
    
    private void addToFront(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}
/*
head <=> 1 <=> 2 <=> tail
3
*/

/**
DLL: double linked list to make sure we can determine which one is least
head--> tail

get: HashMap
      [1,1] [3,3]
rank:   2     1 
 */