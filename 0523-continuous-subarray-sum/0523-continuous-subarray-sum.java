import java.util.Hashtable;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Hashtable<Integer,Integer> ht = new Hashtable<>();
        ht.put(0,0);
        
        int sum = 0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            
            if(!ht.containsKey(sum%k))
                ht.put(sum%k,i+1);
            else if(ht.get(sum%k)<i)
                return true;
        }
        return false;
    }
}