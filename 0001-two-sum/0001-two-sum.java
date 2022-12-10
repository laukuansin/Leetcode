import java.util.Hashtable;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans =new int[2];
        Hashtable<Integer,Integer> ht = new Hashtable<>();
        for(int i=0;i<nums.length;i++)
        {
            int key = target-nums[i];
            if(ht.containsKey(key))
            {
                return new int[]{i,ht.get(key)};
            }
            else{
                ht.put(nums[i],i);
            }
        }
        return new int[2];
    }
}