class Solution {
    int temp=0;
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        boolean[][] visited= new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==0||visited[i][j])
                {
                    visited[i][j]=true;
                    continue;
                }
                helper(grid,i,j,visited); 
                max=Math.max(max,temp);
                temp=0;
            }
        }
        return max;
    }
    
    public void helper(int[][] grid, int x, int y, boolean[][] visited)
    {
        if(x<0||y<0||x>=grid.length||y>=grid[0].length||visited[x][y]||grid[x][y]==0)
        {
            return;
        }
        
        visited[x][y]=true;
        temp++;
        helper(grid,x+1,y,visited);
        helper(grid,x-1,y,visited);
        helper(grid,x,y+1,visited);
        helper(grid,x,y-1,visited);
    }
}

