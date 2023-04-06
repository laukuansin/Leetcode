class Solution {
    public int closedIsland(int[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                    continue;
                if(dfs(grid,i,j))
                {
                    result++;
                }
            }
        }
        return result;
    }

    public boolean dfs(int[][] grid,int x,int y)
    {
        if(x<0||y<0||x>=grid.length||y>=grid[0].length)
        {
            return false;
        }
        if(grid[x][y]==1)
        {
            return true;
        }
        grid[x][y] = 1;
        boolean a = dfs(grid,x+1,y);
        boolean b = dfs(grid,x-1,y);
        boolean c = dfs(grid,x,y-1);
        boolean d = dfs(grid,x,y+1);
        return a&&b&&c&&d;
    }
}