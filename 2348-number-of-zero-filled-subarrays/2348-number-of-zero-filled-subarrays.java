class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long result = 0;
        long curZero = 0;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                curZero++;
            }
            else{
               long tmp = ((curZero+1)*(curZero))/2;
                result+=tmp;
                curZero = 0;
            }
        }
        return result+(((curZero+1)*(curZero))/2);
    }
}