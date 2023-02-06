class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] shuffledNums = new int[nums.length];
        for(int i=0;i<n;i++)
        {
            shuffledNums[2*i] = nums[i];
            shuffledNums[2*i+1] = nums[i+n];
        }

        return shuffledNums;
    }
}