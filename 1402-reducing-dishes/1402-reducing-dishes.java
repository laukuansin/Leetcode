class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int result = 0;
        int prefixSum = 0;
        Arrays.sort(satisfaction);

        for(int i=satisfaction.length-1;i>=0;i--)
        {
            int currentMax = result+satisfaction[i]+prefixSum;
            if(currentMax<result)
            {
                break;
            }
            prefixSum+=satisfaction[i];
            result = currentMax;
        }

        return result<0?0:result;
    }
}