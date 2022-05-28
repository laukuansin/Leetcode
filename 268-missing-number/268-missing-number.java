class Solution {
    public int missingNumber(int[] nums) {
        int size = nums.length;
        int total =0;
        
        for(int i=0;i<size;i++)
        {
            total+=nums[i];
        }
        double ans = ((double)size+1)/2*(double)size;
        return (int)ans-total;
    }
}