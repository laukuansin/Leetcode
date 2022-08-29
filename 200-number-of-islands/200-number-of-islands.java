class Solution {
    boolean[][] visited;  
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col = grid[0].length;
        visited = new boolean[row][col];   
        int count = 0;
        
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]=='0'||visited[i][j])
                    continue;
                
                helper(i,j,grid);
                count++;
                
            }
        }
        
        return count;
    }
    
    public void helper(int x,int y,char[][] grid)
    {
        if(x<0||y<0||x>=visited.length||y>=visited[0].length||grid[x][y]=='0')
        {
            return;
        }
        if(visited[x][y])
        {
            return;
        }
        visited[x][y]=true;
        
        helper(x+1,y,grid);
        helper(x-1,y,grid);
        helper(x,y+1,grid);
        helper(x,y-1,grid);
    }
}