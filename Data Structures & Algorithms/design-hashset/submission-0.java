class MyHashSet {
    // 769 ek prime number hai, jo collisions (टकराव) ko kam karta hai
    private static final int BASE = 769;
    private LinkedList<Integer>[] buckets;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        // Sirf 769 size ka array banaya
        buckets = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    // Hash function: Yeh kisi bhi bade number ko 0 se 768 ke beech le aata hai
    private int hash(int key) {
        return key % BASE;
    }
    
    public void add(int key) {
        int bucketIndex = hash(key);
        // Agar number pehle se nahi hai, tabhi add karo (Duplicates hatane ke liye)
        if (!buckets[bucketIndex].contains(key)) {
            buckets[bucketIndex].add(key);
        }
    }
    
    public void remove(int key) {
        int bucketIndex = hash(key);
        // Integer object ke roop mein remove karna zaroori hai, nahi toh index samajh lega
        buckets[bucketIndex].remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        int bucketIndex = hash(key);
        return buckets[bucketIndex].contains(key);
    }
}