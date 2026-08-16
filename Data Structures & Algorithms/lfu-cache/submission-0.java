public class LFUCache {

    private class Node {
        int key, val, freq;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    private class DoublyLinkedList {
        Node head, tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addNode(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeTail() {
            if (size > 0) {
                Node lruNode = tail.prev;
                removeNode(lruNode);
                return lruNode;
            }
            return null;
        }
    }

    private final int capacity;
    private int minFreq;
    private final Map<Integer, Node> keyToNode;
    private final Map<Integer, DoublyLinkedList> freqToList;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToNode = new HashMap<>();
        this.freqToList = new HashMap<>();
    }

    public int get(int key) {
        Node node = keyToNode.get(key);
        if (node == null) {
            return -1;
        }
        updateNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.val = value;
            updateNode(node);
        } else {
            if (keyToNode.size() == capacity) {
                DoublyLinkedList minFreqList = freqToList.get(minFreq);
                Node evicted = minFreqList.removeTail();
                if (evicted != null) {
                    keyToNode.remove(evicted.key);
                }
            }
            
            Node newNode = new Node(key, value);
            keyToNode.put(key, newNode);
            minFreq = 1;
            freqToList.computeIfAbsent(1, k -> new DoublyLinkedList()).addNode(newNode);
        }
    }

    private void updateNode(Node node) {
        int oldFreq = node.freq;
        DoublyLinkedList oldList = freqToList.get(oldFreq);
        oldList.removeNode(node);

        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;
        freqToList.computeIfAbsent(node.freq, k -> new DoublyLinkedList()).addNode(node);
    }
}