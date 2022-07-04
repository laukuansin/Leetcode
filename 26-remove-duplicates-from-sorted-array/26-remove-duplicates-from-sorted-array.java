class Solution {
    public int removeDuplicates(int[] nums) {
        int countIndex = 0;
        int size = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=nums[countIndex])
            {
                nums[countIndex+1]=nums[i];
                size++;
                countIndex++;
            }
        }
        return size+1;
    }
}