class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};
        int start=0;
        int end=nums.length-1;
        while(start<=end)
        {
            int middle=(start+end)/2;
            if(nums[middle]==target)
            {
                ans[0]=middle;
                ans[1]=middle;
                int left=middle-1;
                int right = middle+1;
                while(left>=-1)
                {
                    if(left==-1)
                    {
                        ans[0]=left+1;
                        break;
                    }
                    if(nums[left]==target)
                    {
                        left--;
                    }
                    else{
                        ans[0]=left+1;
                        break;
                    }
                }
                
                while(right<=nums.length)
                {
                    if(right==nums.length)
                    {
                        ans[1]=right-1;
                        break;
                    }
                    if(nums[right]==target)
                    {
                        right++;
                    }
                    else{
                        ans[1]=right-1;
                        break;
                    }
                }
                return ans;
            }
            else if(nums[middle]>target)
            {
                end=middle-1;
            }
            else{
                start=middle+1;
            }
        }
        return new int[]{-1,-1};
    }
}