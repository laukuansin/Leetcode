import java.util.*;  

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Hashtable<Integer,Integer> hashtable = new Hashtable<Integer,Integer>();
        
        int max=0;
        int track=0;
        
        for(int start=0,end=0;end<nums.length;end++)
        {
            track+=nums[end];
            hashtable.put(nums[end],hashtable.getOrDefault(nums[end],0)+1);
            if(hashtable.get(nums[end])<2)
            {
                max=Math.max(max,track);
            }
            else{
                while(hashtable.get(nums[end])>1)
                {
                    hashtable.put(nums[start],hashtable.getOrDefault(nums[start],0)-1);
                    track-=nums[start++];
                }
            }
            
        }
         
        return max;
    }
}