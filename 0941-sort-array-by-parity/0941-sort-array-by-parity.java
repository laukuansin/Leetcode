class Solution {
    public int[] sortArrayByParity(int[] nums)
    {
        int start = 0;
        int end = nums.length - 1;

        while(start < end)
        {
            if(nums[start] % 2 == 1 && nums[end] % 2 ==0)
            {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
            }

            if(nums[start]%2==0)
            {
                start++;
            }

            if(nums[end]%2==1)
            {
                end--;
            }
        }

        return nums;
    }

    //brute force method
    // public int[] sortArrayByParity(int[] nums) {
    //     if(nums.length==1)
    //     {
    //         return nums;
    //     }
    //     int start = 0;

    //     while(start < nums.length)
    //     {
    //         int end = start+1;
    //         while(end < nums.length)
    //         {
    //             if(nums[start]%2 == 1 && nums[end]%2 == 0)
    //             {
    //                 int tmp = nums[start];
    //                 nums[start] = nums[end];
    //                 nums[end] = tmp;
    //                 break;
    //             }
    //             end++;
    //         }
    //         start++;
    //     }
    //     return nums;
    // }
}