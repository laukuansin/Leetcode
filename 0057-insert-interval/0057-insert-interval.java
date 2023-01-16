class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> newIntervals = new ArrayList<>();

        boolean addedNewInterval = false;
        int start = 0;
        int end = intervals.length;

        while(start<end)
        {
            int[] interval = intervals[start];
            if(addedNewInterval)
            {
                newIntervals.add(interval);
                start++;
                continue;
            }

            int newIntervalStart = newInterval[0];
            int newIntervalEnd = newInterval[1];
            
            if(newIntervalStart>interval[1])
            {
                newIntervals.add(interval);
            }
            else if(newIntervalEnd<interval[0])
            {
                newIntervals.add(newInterval);
                newIntervals.add(interval);
                addedNewInterval = true;
            }
            else if(newIntervalEnd<=interval[1]&&interval[0]<=newIntervalStart)
            {
                newIntervals.add(interval);
                addedNewInterval = true;
            }
            else 
            {
                newInterval[0] = Math.min(newInterval[0],interval[0]);
                newInterval[1] = Math.max(newInterval[1],interval[1]);
            }
            start++;
        }

        if(!addedNewInterval)
        {
            newIntervals.add(newInterval);
        }

        int[][] res = new int[newIntervals.size()][2];

        for(int i=0;i<newIntervals.size();i++)
        {
            res[i] = newIntervals.get(i);
        }

        return res; 
    }
}