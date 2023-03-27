class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        //initial state
        dp[0][0] = grid[0][0];

        for(int i=1;i<m;i++)
        {
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for(int i=1;i<n;i++)
        {
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }

        //formula
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }
/*
    public void dfs(int[][] grid, int x,int y, boolean[][] visited,int sum)
    {
        if(x<0||y<0||x>=grid.length||y>=grid[0].length)
        {
            return;
        }

        if(visited[x][y])
        {
            return;
        }
        visited[x][y] = true;

        if(x==grid.length-1&&y==grid[0].length-1)
        {
            min = Math.min(min,sum);
            //return;
        }
        dfs(grid,x+1,y,visited,sum+grid[x][y]);
        dfs(grid,x,y+1,visited,sum+grid[x][y]);

    }*/
}