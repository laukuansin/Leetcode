class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        if(k >= m-1 + n-1) { 
            return m + n - 2;
        }
         boolean[][][] visited = new boolean[m][n][k + 1];
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{0,0,k});
        while(queue.size()!=0)
        {
            int size = queue.size();
            for(int i=0;i<size;i++)
            {
                int[] temp = queue.poll();
                int x = temp[0];
                int y = temp[1];
                int obs = temp[2];
                
                if(x==m-1&&y==n-1&&obs>=0)
                    return res;
                
                if(obs<0||visited[x][y][obs])
                {
                    continue;
                }
                visited[x][y][obs]=true;
                if(x>0)
                {
                    queue.add(new int[]{x-1,y,obs-grid[x-1][y]});
                }
                if(y>0)
                {
                    queue.add(new int[]{x,y-1,obs-grid[x][y-1]});
                }
                if(x<m-1)
                {
                    queue.add(new int[]{x+1,y,obs-grid[x+1][y]});
                }
                if(y<n-1)
                {
                    queue.add(new int[]{x,y+1,obs-grid[x][y+1]});
                }
            }
            res++;
        }
        return -1;
    }
    
   
}