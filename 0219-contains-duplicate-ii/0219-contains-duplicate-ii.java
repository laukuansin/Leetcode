import java.util.Hashtable;
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length==1) return false;
        Hashtable<Integer,Integer> ht = new Hashtable<>();
        k = k>=nums.length?nums.length-1:k;
        for(int i=0;i<=k;i++)
        {
            ht.put(nums[i],ht.getOrDefault(nums[i],0)+1);
            if(ht.get(nums[i])>1)
                return true;
        }
        for(int i=1;i<nums.length-k;i++)
        {
            ht.put(nums[i-1],ht.get(nums[i-1])-1);
            ht.put(nums[i+k],ht.getOrDefault(nums[i+k],0)+1);
            if(ht.get(nums[i+k])>1)
                return true;
        }
        return false;
        
    }
}