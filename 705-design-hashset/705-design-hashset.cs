public class MyHashSet {
    bool[] list;
    public MyHashSet() {
        list = new bool[1000001];
    }
    
    public void Add(int key) {
        list[key]=true;
    }
    
    public void Remove(int key) {
        list[key]=false;
    }
    
    public bool Contains(int key) {
        return list[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.Add(key);
 * obj.Remove(key);
 * bool param_3 = obj.Contains(key);
 */