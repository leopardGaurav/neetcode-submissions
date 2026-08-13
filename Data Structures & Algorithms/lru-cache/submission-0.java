class LRUCache {

    // Doubly Linked List Node
    private class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head; // Sentinel Head (Most Recently Used)
    private final Node tail; // Sentinel Tail (Least Recently Used)

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        
        // Initialize dummy head & tail to eliminate boundary null-checks
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        // Move visited node to the Most Recently Used position (right after head)
        remove(node);
        insertAtHead(node);

        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Update value and move to MRU position
            Node node = map.get(key);
            node.val = value;
            remove(node);
            insertAtHead(node);
        } else {
            // Check capacity before inserting new key
            if (map.size() == capacity) {
                // Remove LRU node (node right before sentinel tail)
                Node lru = tail.prev;
                map.remove(lru.key);
                remove(lru);
            }

            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertAtHead(newNode);
        }
    }

    // Unlinks a node from the doubly linked list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Inserts a node right after the dummy head (Most Recently Used side)
    private void insertAtHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}