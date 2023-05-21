class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean breakOut = true;
        Queue<int[]> queue = new LinkedList<>();
        int[] direction = new int[]{0,1,0,-1,0};
        int change = 0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(breakOut&&grid[i][j]==1)
                {
                    dfs(grid,i,j);
                    breakOut = false;
                    break;
                }
            }
            if(!breakOut)
                break;
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    queue.add(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty())
        {
            change++;
            int size = queue.size();

            for(int i=0;i<size;i++)
            {
                int[] tmp= queue.poll();
                int x = tmp[0];
                int y = tmp[1];

                for(int j=0;j<=3;j++)
                {
                    int newX = x+direction[j];
                    int newY = y+direction[j+1];

                    if(newX>=0&&newY>=0&&newX<n&&newY<n)
                    {
                        if(grid[newX][newY]==0)
                        {
                            grid[newX][newY] = 2;
                            queue.add(new int[]{newX,newY});
                        }

                        if(grid[newX][newY]==1)
                        {
                            return change-1;
                        }
                    }
                }
            }
        }
        return 0;
    }

    public void dfs(int[][] grid,int x,int y)
    {
        if(x<0||y<0||x>=grid.length||y>=grid.length||grid[x][y]==2)
        {
            return;
        }
        if(grid[x][y]==0)
        {
            return;
        }
        grid[x][y]= 2;

        dfs(grid,x+1,y);
        dfs(grid,x-1,y);
        dfs(grid,x,y-1);
        dfs(grid,x,y+1);
    }
}