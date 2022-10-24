import java.util.Hashtable;
class Solution {
    public int[] findErrorNums(int[] nums) {
        int size = nums.length;
        Hashtable<Integer,Integer> ht = new Hashtable<>();
        
        //Arrays.sort(nums);
        int[] res = new int[2];
        
        for(int i=0;i<size;i++)
        {
            ht.put(nums[i],ht.getOrDefault(nums[i],0)+1);
            ht.put(i+1,ht.getOrDefault(i+1,0)+1);
        }
        
      for(Map.Entry<Integer,Integer> m:ht.entrySet()){  
            if(m.getValue()==3)
            {
                res[0]=m.getKey();
            }
          if(m.getValue()==1)
          {
              res[1]=m.getKey();
          }
      }  
        return res;
    }
} 