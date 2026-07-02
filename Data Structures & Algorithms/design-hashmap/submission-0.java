class MyHashMap {
    
    // 1. Ek Jodi (Pair) ko bandhne ke liye custom class
    static class Entry {
        int key;
        int value;
        
        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // 2. Constants aur Buckets Array
    private static final int BASE = 769; // Prime number size
    private LinkedList<Entry>[] buckets;

    // 3. Constructor - Baltiyon ko shuruat mein khali ready karna
    @SuppressWarnings("unchecked")
    public MyHashMap() {
        buckets = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    // 4. Hash Function - Badi key ko 0 se 768 ke beech address dena
    private int hash(int key) {
        return key % BASE;
    }
    
    // 5. Put - Naya data daalna ya purana update karna
    public void put(int key, int value) {
        int bucketIndex = hash(key);
        LinkedList<Entry> bucket = buckets[bucketIndex];
        
        // Loop chala kar check karo ki key pehle se hai kya?
        for (Entry entry : bucket) {
            if (entry.key == key) {
                entry.value = value; // Mil gayi toh purani value badal do (Update)
                return;
            }
        }
        // Nahi mili toh naya packet bana kar balti mein daal do
        bucket.add(new Entry(key, value));
    }
    
    // 6. Get - Key dekar Value nikalna
    public int get(int key) {
        int bucketIndex = hash(key);
        LinkedList<Entry> bucket = buckets[bucketIndex];
        
        // Balti ke andar dhoondho
        for (Entry entry : bucket) {
            if (entry.key == key) {
                return entry.value; // Key milte hi uske samne wali value de do
            }
        }
        return -1; // Poori balti dekh li par nahi mili toh -1
    }
    
    // 7. Remove - Data ko hamesha ke liye mita dena
    public void remove(int key) {
        int bucketIndex = hash(key);
        LinkedList<Entry> bucket = buckets[bucketIndex];
        
        for (Entry entry : bucket) {
            if (entry.key == key) {
                bucket.remove(entry); // Milte hi poori jodi ko balti se phenk do
                return;
            }
        }
    }
}