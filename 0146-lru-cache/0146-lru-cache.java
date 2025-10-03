class LRUCache {

    class Node {
        int key, value;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.value = val;
        }
    }

    public int cap;
    public HashMap<Integer, Node> map;
    public Node head, tail;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) 
            return -1;

        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            node.value = value;
            insert(node);
            return;
        }
        if (map.size() == cap) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        Node node = new Node(key, value);
        insert(node);
        map.put(key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */