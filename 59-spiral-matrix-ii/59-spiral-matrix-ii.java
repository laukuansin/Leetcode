class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
            int[] pos = new int[]{0,1,0,-1,0};
        
            int count=0;
            int totalSize = n*n;
            int i=0;
            int j=0;
            int posIdx = 0;
            while(count<totalSize)
            {
                matrix[i][j]=count+1;

                int x=i+pos[posIdx];
                int y=j+pos[posIdx+1];
                if(x<0||y<0||x>=n||y>=n||matrix[x][y]!=0)
                {
                    posIdx+=1;
                    posIdx%=4;
                    x=i+pos[posIdx];
                    y=j+pos[posIdx+1];
                }
                i=x;
                j=y;
                count++;
            }
            return matrix;
    }
}