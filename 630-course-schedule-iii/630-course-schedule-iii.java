class Solution {
    public int scheduleCourse(int[][] courses) {
        /*
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
        */
         Arrays.sort(courses, Comparator.comparingDouble(o -> o[1]));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int time=0;
        int count=0;
        for(int[]arr: courses)
        {
            if(time+arr[0]<=arr[1])
            {
                time+=arr[0];
                queue.add(arr[0]);
            }
            else{
                if(!queue.isEmpty()&&queue.peek()>arr[0])
                {
                    time+=arr[0]-queue.poll();
                    queue.add(arr[0]);
                }
            }
        }
        
        return queue.size();
    }
}