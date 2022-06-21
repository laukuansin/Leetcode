class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<heights.length-1;i++)
        {
            if(heights[i+1]<=heights[i])
                continue;
            int distance=heights[i+1]-heights[i];
            queue.add(distance);
            bricks-=distance;
            if(bricks<0)
            {
                
                    bricks+=queue.poll();
                if(ladders>0){
                    ladders--;
                }
                else{
                    return i;
                }
          
            }
          
        }
        return heights.length-1;
    }
}