public class Solution {
    public int[] delta= new int[]{0,1,0,-1,0};
    public int MinimumEffortPath(int[][] heights) {
        int left = 0;
        int right = 1000000;
        while(left+1<right)
        {
            int median = left+(right-left)/2;
            if(valid(median,heights))
            {
                right=median;
            }
            else{
                left=median;
            }
        }
        if(valid(left,heights))
        {
            return left;
        }
        return right;
    }
    
    public bool valid(int effort, int[][] heights)
    {
        Queue<int[]> queue = new Queue<int[]>();
        bool[,] visited = new bool[heights.Length,heights[0].Length];
        queue.Enqueue(new int[]{0,0});
        visited[0,0] = true;
        
        while(queue.Count!=0)
        {
            int size = queue.Count;
            for(int i=0;i<size;i++)
            {
                int[] cur = queue.Dequeue();
                int x = cur[0];
                int y = cur[1];
                
                if(x==heights.Length-1&&y==heights[0].Length-1)
                {
                    return true;
                }
                
                for(int j=0;j<4;j++)
                {
                    int a=x+delta[j];
                    int b=y+delta[j+1];
                    
                    if(inBound(a,b,heights)&&!visited[a,b]&&Math.Abs(heights[a][b]-heights[x][y])<=effort)
                    {
                        queue.Enqueue(new int[]{a,b});
                        visited[a,b]=true;
                    }
                }
            }
            
        }
        return false;
    }
    
    public bool inBound(int x,int y,int[][] heights)
    {
        return x>=0&&x<heights.Length&&y>=0&&y<heights[0].Length;
    }
}