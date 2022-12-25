class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] answer = new int[queries.length];
        for(int i=1;i<nums.length;i++)
        {
            nums[i]+=nums[i-1];
        }
        
        for(int i=0;i<queries.length;i++)
        {
            int start = 0;
            int end =nums.length-1;
            while(start<=end)
            {
                int middle = (end-start)/2+start;

                if(queries[i]==nums[middle])
                {
                    start=middle+1;
                    break;
                }
                else if(nums[middle]>queries[i])
                {
                    end=middle-1;
                }
                else{
                    start=middle+1;
                }
            }
            answer[i]=start;
        }
        return answer;
    }
}
/*
    mid = (start+end)/2
    mid = (2*start-end)-end/2
*/
/*
    sorting method
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] answer = new int[queries.length];

        for(int i=0;i<queries.length;i++)
        {
            int curSum = 0;
            int idx = 0;
            while(idx<nums.length&&curSum<queries[i])
            {
                curSum+=nums[idx];
                idx++;
            }

            if(curSum>queries[i])
            {
                idx--;
            }
            answer[i]=idx;
        }
        return answer;
    }
*/