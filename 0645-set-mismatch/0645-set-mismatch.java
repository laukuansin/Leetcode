class Solution {
    public int[] findErrorNums(int[] nums) {
        int size = nums.length;
        
        Arrays.sort(nums);
        
        int total = 1;
        int actual = nums[0];
        int repeat = 0;
        for(int i=1;i<size;i++)
        {
            if(nums[i]==nums[i-1])
            {
                repeat = nums[i];
            }
            else{
                actual+=nums[i];
            }
            
            total +=(i+1);
        }
     
        return new int[]{repeat,total-actual};
    }
} 