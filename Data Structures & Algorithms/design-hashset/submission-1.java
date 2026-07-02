class MyHashSet {
    // Array to keep track of present keys
    // Size 1000001 handles keys from 0 to 1,000,000 inclusive
    private boolean[] set;

    public MyHashSet() {
        set = new boolean[1000001];
    }
    
    public void add(int key) {
        set[key] = true;
    }
    
    public void remove(int key) {
        set[key] = false;
    }
    
    public boolean contains(int key) {
        return set[key];
    }
}