class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr=new int[2];
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int size=nums.length;
        for(int i=0;i<size;i++)
        {
            hashMap.put(target-nums[i],i);            
        }
        for(int i=0;i<size;i++)
        {
            if(hashMap.containsKey(nums[i]))
            {
                if(i!=hashMap.get(nums[i]))
                {
                     arr[0]=i;
                    arr[1]=hashMap.get(nums[i]);
                    return arr;
                }
               
            }
        }
        return arr;
        
    }
}