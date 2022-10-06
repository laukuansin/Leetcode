import java.util.Hashtable;
class TimeMap {
    Hashtable<String,Hashtable<Integer,String>> ht;
    public TimeMap() {
        ht = new Hashtable<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(ht.containsKey(key))
        {
            Hashtable<Integer,String> timeHt = ht.get(key);
            timeHt.put(timestamp,value);
            ht.put(key,timeHt);
        }
        else{
            Hashtable<Integer,String> timeHt = new Hashtable<>();
            timeHt.put(timestamp,value);
            ht.put(key,timeHt);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!ht.containsKey(key))
            return "";
        Hashtable<Integer,String> timeHt = ht.get(key);
        for(int i=timestamp;i>=1;i--)
        {
            if(timeHt.containsKey(i))
            {
                return timeHt.get(i);
            }
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */