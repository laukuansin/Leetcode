class Solution {
    public long mostPoints(int[][] questions) {
        int size = questions.length;
        Long[] memo = new Long[size];

        return dfs(questions,memo,0);
    }

    public long dfs(int[][] questions,Long[] memo,int idx)
    {
        if(idx>=questions.length)
        {
            return 0;
        }
        if(memo[idx]!=null)
        {
            return memo[idx];
        }
        
        //No skip current question
        long curQuestion = questions[idx][0]+dfs(questions,memo,idx+questions[idx][1]+1);
        //compare skip and no skip
        long maxPoints = Math.max(curQuestion,dfs(questions,memo,idx+1));

        return memo[idx] = maxPoints;
    }
}