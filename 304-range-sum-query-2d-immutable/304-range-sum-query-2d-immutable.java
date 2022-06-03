class NumMatrix {
    int[][] dp;
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        dp = new int[row][col+1];
        
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                dp[i][j+1]=dp[i][j]+matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int size =0;
        for(int i=row1;i<=row2;i++)
        {
            size+=dp[i][col2+1]-dp[i][col1];
        }
        return size;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */