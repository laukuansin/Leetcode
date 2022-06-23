class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingDouble(o -> o[1]));
        int max=0;
        int time=0;
        for(int j=0;j<courses.length;j++)
        {
            if(time+courses[j][0]<=courses[j][1])
            {
                time+=courses[j][0];
                max++;
            }
            else{
                int max_i = j;
                for(int i=0;i<j;i++)
                {
                    if(courses[i][0]==-1)
                    {
                        continue;
                    }else{
                        if(courses[max_i][0]<courses[i][0])
                        {
                            max_i=i;
                        }
                    }
                }
                if(courses[max_i][0]>courses[j][0])
                {
                    time+=courses[j][0]-courses[max_i][0];
                }
                courses[max_i][0]=-1;
            }
        }
        return max;
    }
}