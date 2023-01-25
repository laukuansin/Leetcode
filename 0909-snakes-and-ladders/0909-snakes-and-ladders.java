class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] newBoard = new int[(n*n)+1];
        int count = 1;
        boolean left = true;
        Set<Integer> visited = new HashSet<>();

        for(int i=n-1;i>=0;i--)
        {
            if(left)
            {
                for(int j=0;j<n;j++)
                {
                    newBoard[count++] = board[i][j];
                }
                left = false;
            }   
            else{
                for(int j=n-1;j>=0;j--)
                {
                    newBoard[count++] = board[i][j];
                }
                left = true;
            }
        }
        
        CurSquare cs = new CurSquare(1,0);
        Queue<CurSquare> queue = new LinkedList<>();
        queue.add(cs);

        for(int move=0;!queue.isEmpty();move++)
        {
            int size = queue.size();

            for(int i=0;i<size;i++)
            {
                CurSquare currCs = queue.poll();
                if(visited.contains(currCs.curStep))
                {
                    continue;
                }
                visited.add(currCs.curStep);
                for(int j=1;j<=6;j++)
                {
                    if(currCs.curStep==n*n)
                    {
                        return move;
                    }
                    int next = Math.min(currCs.curStep+j,n*n);
                    
                    if(newBoard[next]==-1)
                    {
                        queue.add(new CurSquare(next,currCs.res+1));
                    }
                    else{
                        queue.add(new CurSquare(newBoard[next],currCs.res+1));
                    }
                }
            }
            
        }

        return -1;
    }
}
class CurSquare
{
    int curStep;
    int res;

    public CurSquare(int curStep,int res)
    {
        this.curStep = curStep;
        this.res=res;
    }
}