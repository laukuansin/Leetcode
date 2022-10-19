import java.util.Hashtable;
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<String>();
        Hashtable<String,Integer> ht = new Hashtable<>();
        for(String word:words)
        {
            ht.put(word,ht.getOrDefault(word,0)+1);
        }
         PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
            (a,b)->{
                int com = b.getValue()-a.getValue();
                if(com==0)
                {
                    com = a.getKey().compareTo(b.getKey());
                }
                
                return com;
            }
        );
        for(Map.Entry<String, Integer> entry: ht.entrySet()) {
            queue.add(entry);
		}
        
        
        
        while(k>0)
        {
            Map.Entry<String, Integer> entry = queue.poll();
            res.add(entry.getKey());
            k--;
        }
        return res;
    }
}