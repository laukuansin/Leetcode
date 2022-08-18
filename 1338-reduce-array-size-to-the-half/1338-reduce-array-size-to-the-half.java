import java.util.Hashtable;
class Solution {
    public int minSetSize(int[] arr) {
        Hashtable<Integer,Integer> ht = new Hashtable<>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++)
        {
            ht.put(arr[i],ht.getOrDefault(arr[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> m:ht.entrySet()){  
           pq.add(m.getValue());
          }  
        int size=0;
        int ans=0;
        while(size<arr.length/2)
        {
            
            int tmp = pq.poll();
            //System.out.println(tmp);
            size+=tmp;
            ans++;
        }return ans;
        
    }
}