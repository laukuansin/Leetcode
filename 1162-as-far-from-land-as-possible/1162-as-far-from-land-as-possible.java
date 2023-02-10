class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int counter = -1;
        int[] pos = new int[]{0,1,0,-1,0};

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(grid[i][j]==1)
                    queue.add(new int[]{i,j});
        
        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i=0;i<size;i++)
            {
                int[] currentPos = queue.poll();
                for(int j=0;j<4;j++)
                {
                    int x = currentPos[0]+pos[j];
                    int y = currentPos[1]+pos[j+1];

                    if(x<0||x>=n||y<0||y>=n||grid[x][y]==1)
                    {
                        continue;
                    }
                    grid[x][y]  = 1;
                    queue.add(new int[]{x,y});
                }
            }
            counter++;
        }
        return counter<1?-1:counter;    
    }

    
}