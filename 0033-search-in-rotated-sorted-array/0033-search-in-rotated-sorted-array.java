class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while(start<=end)
        {
            int middle = (end-start)/2+start;
            int middleNum = nums[middle];

            if(target==middleNum)
            {
                return middle;
            }
            
            if(nums[start]<=middleNum)
            {
                if(target>=nums[start]&&target<middleNum)
                {
                    end = middle-1;
                }
                else{
                    start = middle+1;
                }
            }  
            else{
                if(target>middleNum&&target<=nums[end])
                {
                    start = middle+1;
                }
                else{
                    end = middle-1;
                }
            }

        }

        return -1;
    }
}