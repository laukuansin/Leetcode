public class MyHashMap {
    int[] keysVals;
    bool[] checks;
    
    public MyHashMap() {
        keysVals = new int[1000001];
        checks= new bool[1000001];
    }
    
    public void Put(int key, int value) {
        checks[key]=true;
        keysVals[key]=value;
        
    }
    
    public int Get(int key) {
        if(checks[key])
        {
            return keysVals[key];
        }
        else{
            return -1;
        }
    }
    
    public void Remove(int key) {
        checks[key]=false;
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.Put(key,value);
 * int param_2 = obj.Get(key);
 * obj.Remove(key);
 */