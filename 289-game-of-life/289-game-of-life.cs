public class Solution {
    public void GameOfLife(int[][] board) {
        int row = board.Length;
        int col = board[0].Length;
        int[,] tmp = new int[row,col];
        
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                tmp[i,j]=board[i][j];
            }
        }
        
        for(int i=0;i<row;i++)
        {
            for(int j =0;j<col;j++)
            {
                int live=0;
                int die = 0;
                if(i-1>=0&&j-1>=0)
                {
                    if(tmp[i-1,j-1]==0)
                    {
                        die++;
                    }
                    else{
                        live++;
                    }
                }
                if(i-1>=0)
                {
                    if(tmp[i-1,j]==0)
                    {
                        die++;
                    }
                    else{
                        live++;
                    }
                }
                if(i-1>=0&&j+1<col)
                {
                    if(tmp[i-1,j+1]==0)
                    {
                        die++;
                    }
                    else{
                        live++;
                    }
                }
                if(j-1>=0)
                {
                    if(tmp[i,j-1]==0)
                    {
                        die++;
                    }
                    else{
                        live++;
                    }
                }
                if(j+1<col)
                {
                    if(tmp[i,j+1]==0)
                    {
                        die++;
                    }
                    else{
                        live++;
                    }
                }
                if(i+1<row&&j-1>=0)
                {
                    if(tmp[i+1,j-1]==0)
                    {
                        die++;
                    }
                    else{
                        live++;
                    }
                }
                if(i+1<row)
                {
                    if(tmp[i+1,j]==0)
                    {
                        die++;
                    }
                    else{
                        live++;
                    }
                }
                if(i+1<row&&j+1<col)
                {
                    if(tmp[i+1,j+1]==0)
                    {
                        die++;
                    }
                    else{
                        live++;
                    }
                }
                if(tmp[i,j]==1&&live<2)
                {
                    board[i][j]=0;
                }
                else if(tmp[i,j]==1&&live>=2&&live<=3)
                {
                    continue;
                }
                else if(tmp[i,j]==1&&live>3)
                {
                    board[i][j]=0;
                }
                else if(tmp[i,j]==0&&live==3)
                {
                    board[i][j]=1;
                }
            }
        }
    }
}