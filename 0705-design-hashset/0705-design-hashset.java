class MyHashSet {
    boolean[] setArray;
    public MyHashSet() {
        setArray = new boolean[1000001];
    }
    
    public void add(int key) {
        setArray[key] = true;
    }
    
    public void remove(int key) {
        setArray[key] = false;
    }
    
    public boolean contains(int key) {
        return setArray[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */