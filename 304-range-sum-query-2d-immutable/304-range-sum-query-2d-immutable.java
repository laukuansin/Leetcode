class NumMatrix {
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix =matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int startRow = row1;
        int endRow = row2;
        int startCol = col1;
        int endCol = col2;
        int size=0;
        for(int i=startRow;i<=endRow;i++)
        {
            for(int j=startCol;j<=endCol;j++)
            {
                size+=matrix[i][j];
            }
        }
        return size;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */