public class Solution {
    public int MaxOperations(int[] nums, int k) {
        int start = 0;
        int end=nums.Length-1;
        int ans =0;
        
        Array.Sort(nums);
        
        while(start<end)
        {
            if(nums[start]+nums[end]==k)
            {
                start++;
                end--;
                ans++;
            }
            else if(nums[start]+nums[end]>k)
            {
                end--;
            }
            else{
                start++;
            }
        }
        
        return ans;
    }
}