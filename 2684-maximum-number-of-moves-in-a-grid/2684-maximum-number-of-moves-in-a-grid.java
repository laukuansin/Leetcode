class Solution {
    public int maxMoves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Integer[][] memo = new Integer[row][col];
        
        int max = 0;
        for(int i=0;i<row;i++)
        {
            max = Math.max(dfs(i,0,-1,grid,memo)-1,max);
        }
        return max;
    }
    
    public int dfs(int x,int y,int previousNum,int[][] grid,Integer[][] memo)
    {
        if(x<0||y<0||x>=grid.length||y>=grid[0].length||grid[x][y]<=previousNum)
        {
            return 0;
        }
        if(memo[x][y]!=null)
        {
            return memo[x][y];
        }
        memo[x][y] = Math.max(dfs(x-1,y+1,grid[x][y],grid,memo),Math.max(dfs(x,y+1,grid[x][y],grid,memo),dfs(x+1,y+1,grid[x][y],grid,memo)));
        
        
        return 1+memo[x][y];
    }
}