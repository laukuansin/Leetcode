class Solution {
    public int[] findErrorNums(int[] nums) {
        int size = nums.length;
        int[] hashtable = new int[size+1];
        int[] res = new int[2];
        for(int i=0;i<size;i++)
        {
            hashtable[nums[i]]+=1;
            hashtable[i+1]+=1;
        }
        
        for(int i=0;i<size;i++)
        {
            if(hashtable[i+1]==3)
            {
                res[0] = i+1;
            }
            if(hashtable[i+1]==1)
            {
                res[1] = i+1;
            }
        }
     
        return res;
    }
} 