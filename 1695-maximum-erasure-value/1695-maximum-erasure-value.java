import java.util.*;  

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int max=0;
        int track=0;
        
        for(int start=0,end=0;end<nums.length;end++)
        {
            while(set.contains(nums[end]))
            {
                set.remove(nums[start]);
                track-=nums[start++];
            }
            
            track+=nums[end];
            set.add(nums[end]);
             max=Math.max(max,track);
            
              
            
        }
         
        return max;
    }
}