class Solution {
    public int[] ans;
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        ans = new int[n];
        for(int i=0;i<n;i++)
        {
            dfs(i,0,i,grid,m,n);
        }
        return ans;
    }
    
    public void dfs(int baseIndex,int x,int y,int[][] grid,int row,int col)
    {
        if(x>=row)
        {
            if(y>=0&&y<col)
            {
                ans[baseIndex]=y;
            }
            else{
                ans[baseIndex]=-1;
            }
            return;
        }
        
        if(grid[x][y]==1)
        {
            if(y==col-1||grid[x][y+1]==-1)
            {
                ans[baseIndex]=-1;
                return;
            }
            dfs(baseIndex,x+1,y+1,grid,row,col);
        }
        else if(grid[x][y]==-1)
        {
            if(y==0||grid[x][y-1]==1)
            {
                ans[baseIndex]=-1;
                return;
            }
            dfs(baseIndex,x+1,y-1,grid,row,col);
        }
    }
}