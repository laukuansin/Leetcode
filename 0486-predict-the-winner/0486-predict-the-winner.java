class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if(nums.length<3)
            return true;
        return dfs(0,nums.length-1,nums,0,true);
    }

    public boolean dfs(int left,int right,int[] nums,int totalSum,boolean player1Turn)
    {
        if(left>right)
        {
            return totalSum>=0;
        }

        if(player1Turn)
        {
            return dfs(left+1,right,nums,totalSum+nums[left],!player1Turn) || dfs(left,right-1,nums,totalSum+nums[right],!player1Turn);

        }
        else{
            return dfs(left+1,right,nums,totalSum-nums[left],!player1Turn) && dfs(left,right-1,nums,totalSum-nums[right],!player1Turn);

        }

    }
}