public class Solution {
    public int[] SortArrayByParity(int[] nums) {
        int start = 0;
        int end =nums.Length-1;
        
        while(start<end)
        {
            if(nums[start]%2==0)
            {
                if(nums[end]%2==0)
                {
                    start++;
                    continue;
                }
                end--;
            }
            else{
                if(nums[end]%2==0)  
                {
                    int temp=nums[start];
                    nums[start]=nums[end];
                    nums[end]=temp;
                    start++;
                    end--;
                }
                else{
                    end--;
                    
                }
            }
        }
        
        return nums;
    }
}